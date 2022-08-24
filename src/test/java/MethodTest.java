import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

    public static void printVar(String var) {
        System.out.println(var + " success!");
    }

    @Test
    public void methodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = MethodTest.class.getDeclaredMethod("printVar", String.class);

        String input = "Hello World";

        method.invoke(MethodTest.class, input);
    }
}
