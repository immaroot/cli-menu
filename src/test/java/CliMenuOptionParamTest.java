import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class CliMenuOptionParamTest extends TestCase {


    public static class MockClass {

        void mockMethod(String var) {
        }

        void anotherMockMethod(@OptionParam(name = "var") String var) {

        }

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testParamType() {
        MockClass mock = new MockClass();

        Arrays.stream(mock.getClass().getDeclaredMethods()).forEach(System.out::println);

        int i = 1;


        for (Method method : mock.getClass().getDeclaredMethods()) {
            System.out.println(i++ + " : " + method.getName());

            for (Parameter param : method.getParameters()) {
                System.out.println(Arrays.toString(param.getDeclaredAnnotations()));
            }
        }

        System.out.println("-----");
    }
}