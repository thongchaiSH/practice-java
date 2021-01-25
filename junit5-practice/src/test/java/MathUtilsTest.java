import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Testing Math Utils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        //ทำก่อนแต่ละการทดสอบ ช่วยลด code ที่ซ้ำกัน
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running "+testInfo.getDisplayName()+" tag "+testInfo.getTags());
//        System.out.println("Running "+testInfo.getDisplayName()+" tag "+testInfo.getTags());
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up....");
    }

    @AfterAll
    void afterAllInit() {
        System.out.println("This need to run after all");
    }

    @Test
    @DisplayName("Testing add method")
    @Tag("Math")
    void addTest() {
//        System.out.println("Running "+testInfo.getDisplayName()+" tag "+testInfo.getTags());
//        testReporter.publishEntry("Running "+testInfo.getDisplayName()+" tag "+testInfo.getTags());
        int expect = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expect, actual, "The add method should add two number"); //message when fail
    }

    @Test
    @Tag("Circle")
    void testComputeCircleArea() {
        mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
    }

    @Test
    @DisplayName("Test Exception")
    @Tag("Math")
    void testDivide() {
        mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw");
    }

    @Test
    @Disabled //ignore test method
    @DisplayName("TDD method. should not  run")
    void testDisabled() {
        fail("This test should be disabled");
    }

    //Condition Execution
    @Test
    @EnabledOnOs(OS.LINUX)
    void testEnableOsLinux() {
        System.out.println("Linux");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_8)
    void testEnableOsWindows() {
        System.out.println("Windows and jre8");
    }

    //Assumetion
    @Test
    void testServerUp() {
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        System.out.println("Server is Up !!");
    }


    /*
     * Do multiple test asserts for the multiply method using assertAll
     * Using nested
     * Using assertAll
     * */
    @Test
    @DisplayName("Multiply method")
    @Tag("Math")
    void testMultiply() {
//        assertEquals(4,mathUtils.multiply(2,2),"should return the right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    //เทสควรจะมี method ต่อ 1 เทส
    //ทดสอบแบบกลุ่ม
    @Nested
    @DisplayName("add method")
    class addTest {

        @Test
        @DisplayName("Testing add method +")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return positive");
        }

        @Test
        @DisplayName("Testing add method -")
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), "should return positive");
        }
    }

    //Repeated test ทดสอบซ่ำ
    @RepeatedTest(3)
    void testRepeated3Time(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo);
        mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
    }

    //@Tag กำหนดกลุ่มแล้ว set ให้รันเฉพาะ tag ได้
}
