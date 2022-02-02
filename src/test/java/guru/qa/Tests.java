package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    void test1() {
        Assertions.assertTrue(100 <= 90);
    }

    @Test
    void test2() {
        String string1 = new String("JAVA");
        String string2 = "Java";
        Assertions.assertTrue(string1.equalsIgnoreCase(string2));
    }
}
