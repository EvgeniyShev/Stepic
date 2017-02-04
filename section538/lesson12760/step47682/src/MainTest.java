// Don't edit this file

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;

/**
 * @author meanmail
 */
public class MainTest {
    private static final String MESSAGE_TEMPLATE = "Main.charExpression(%d)";
    private static Method charExpression;
    private static Class<?> mainClass;

    @BeforeClass
    public static void beforeClass() {
        mainClass = TestUtils.getUserClass("Main");
        charExpression = TestUtils.getMethod(mainClass,
                "charExpression",
                Modifier.PUBLIC | Modifier.STATIC,
                Character.TYPE, Integer.TYPE);
    }

    @Test
    public void charExpressionSample1() throws Exception {
        int offset = 32;
        char expected = '|';
        String message = String.format(MESSAGE_TEMPLATE, offset);
        assertEquals(message, expected, TestUtils.invokeMethod(mainClass, charExpression, offset));
    }

    @Test
    public void charExpressionSample2() throws Exception {
        int offset = 29;
        char expected = 'y';
        String message = String.format(MESSAGE_TEMPLATE, offset);
        assertEquals(message, expected, TestUtils.invokeMethod(mainClass, charExpression, offset));
    }

    @Test
    public void charExpressionSample3() throws Exception {
        int offset = 0;
        char expected = '\\';
        String message = String.format(MESSAGE_TEMPLATE, offset);
        assertEquals(message, expected, TestUtils.invokeMethod(mainClass, charExpression, offset));
    }

    @Test
    public void charExpressionSample4() throws Exception {
        int offset = -20;
        char expected = 'H';
        String message = String.format(MESSAGE_TEMPLATE, offset);
        assertEquals(message, expected, TestUtils.invokeMethod(mainClass, charExpression, offset));
    }
}