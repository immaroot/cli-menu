import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDefaultInputConverter {


    private DefaultInputConverter converter;

    @Before
    public void setUp() {
        converter = new DefaultInputConverter();
    }

    @Test
    public void testElementaryTypes() {
        System.out.println("testElementaryTypes");
        String[] strings = {
                "aString",
                "some-object",
                "1243",
                "12432141231256",
                "12.6",
                "12.6",
                "true",
        };
        Class<?>[] classes = {
                String.class,
                Object.class,
                Integer.class,
                Long.class,
                Double.class,
                Float.class,
                Boolean.class,
        };
        Object[] results = {
                "aString",
                "some-object",
                1243,
                12432141231256L,
                12.6,
                12.6f,
                Boolean.TRUE,
        };

        for (int i = 0; i < strings.length; i++) {
            assertEquals(results[i], converter.convertInput(strings[i], classes[i]));
        }
    }

}
