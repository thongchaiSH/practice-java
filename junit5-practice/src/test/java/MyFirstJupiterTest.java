import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyFirstJupiterTest {
    //https://phayao.medium.com/%E0%B8%A1%E0%B8%B2%E0%B8%97%E0%B8%B3%E0%B8%84%E0%B8%A7%E0%B8%B2%E0%B8%A1%E0%B8%A3%E0%B8%B9%E0%B9%89%E0%B8%88%E0%B8%B1%E0%B8%81-junit-5-%E0%B8%81%E0%B8%B1%E0%B8%99%E0%B9%80%E0%B8%96%E0%B8%AD%E0%B8%B0-8082fe7e7b60

    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void setup() {
        //ทำก่อนการทดสอบทั้งหมด
        System.out.println("Execute before all test method");
    }

    @BeforeEach
    void init() {
        //ทำก่อนแต่ละการทดสอบ
        System.out.println("Execute before each test method");
    }

    @AfterAll
    static void done() {
        //ทำหลังจากการทดสอบ
        System.out.println("Execute after all test method");
    }

    @AfterEach
    void tearDown() {
        //ทำหลังแต่ละการทดสอบ
        System.out.println("Execute after each test method");
    }

    @Test
    @DisplayName("Addition test successful")
        //ตั้งชื่อ Test
    void addition() {
        System.out.println("addition");
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @Disabled("Not implement yet.")
        //จะไม่ทำ Test  นี้
    void minus() {
        System.out.println("minus");
        assertEquals(0, calculator.minus(1, 1));
    }

    @RepeatedTest(10)
        //ทำการทดสอบซ้ำจำนวน 10 ครั้ง
    void additionTest() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("Should check all item in list")
    void shouldCheckAllItemInTheList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertEquals(1, numbers.get(0));
        assertEquals(2, numbers.get(1));
        assertEquals(3, numbers.get(2));
        assertEquals(4, numbers.get(3));
    }

    @Test
    @DisplayName("Group Assertion")
    void groupAssertion() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertAll("Numbers",
                () -> assertEquals(1, numbers.get(0)),
                () -> assertEquals(2, numbers.get(1)),
                () -> assertEquals(3, numbers.get(2)),
                () -> assertEquals(4, numbers.get(3))
        );
    }
}

