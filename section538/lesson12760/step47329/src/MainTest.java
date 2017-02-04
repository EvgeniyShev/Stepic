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
    private static final String MESSAGE_TEMPLATE = "Main.isPowerOfTwo(%d)";
    private static Method charExpression;
    private static Class<?> mainClass;

    @BeforeClass
    public static void beforeClass() {
        mainClass = TestUtils.getUserClass("Main");
        charExpression = TestUtils.getMethod(mainClass,
                "isPowerOfTwo",
                Modifier.PUBLIC | Modifier.STATIC,
                Boolean.TYPE, Integer.TYPE);
    }

    @Test
    public void isPowerOfTwoSample1() throws Exception {
        int value = 0;
        String message = String.format(MESSAGE_TEMPLATE, value);
        assertEquals(message, false, TestUtils.invokeMethod(mainClass, charExpression, value));
    }

    @Test
    public void isPowerOfTwoSample2() throws Exception {
        int value = 1;
        String message = String.format(MESSAGE_TEMPLATE, value);
        assertEquals(message, true, TestUtils.invokeMethod(mainClass, charExpression, value));
    }

    @Test
    public void isPowerOfTwoSample3() throws Exception {
        int value = -2;
        String message = String.format(MESSAGE_TEMPLATE, value);
        assertEquals(message, true, TestUtils.invokeMethod(mainClass, charExpression, value));
    }

    @Test
    public void isPowerOfTwoSample4() throws Exception {
        int value = 1458;
        String message = String.format(MESSAGE_TEMPLATE, value);
        assertEquals(message, false, TestUtils.invokeMethod(mainClass, charExpression, value));
    }

    @Test
    public void isPowerOfTwoSample5() throws Exception {
        int value = -536_870_912;
        String message = String.format(MESSAGE_TEMPLATE, value);
        assertEquals(message, true, TestUtils.invokeMethod(mainClass, charExpression, value));
    }
}