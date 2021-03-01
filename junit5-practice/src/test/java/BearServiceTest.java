import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BearServiceTest {
    @Test
    @DisplayName("Testing bear hello")
    public void testItShouldReturnHelloFromBear(){
        BearService bearService=new BearService();
        String actual=bearService.say();
        assertEquals("Hello",actual);
    }
}
