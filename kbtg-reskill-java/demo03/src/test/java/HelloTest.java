import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    void should_say_hello_thongchai() {

        Hello hello=new Hello();
        String actualResult=hello.sayHi("thongchai");
        assertThat(actualResult).isEqualTo("Hello thongchai");
    }
}