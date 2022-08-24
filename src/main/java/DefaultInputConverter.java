import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DefaultInputConverter implements InputConverter {

    @Override
    public Object convertInput(String string, Class<?> aClass) {
        Object result = null;
        if (aClass.equals(String.class)) {
            result = string;
        } else if (aClass.equals(Integer.class) || aClass.equals(Integer.TYPE)) {
            result = Integer.parseInt(string);
        } else if (aClass.equals(Double.class)) {
            result = Double.parseDouble(string);
        } else if (aClass.equals(Long.class)) {
            result = Long.parseLong(string);
        } else if (aClass.equals(Float.class)) {
            result = Float.parseFloat(string);
        } else if (aClass.equals(Boolean.class)) {
            result = Boolean.parseBoolean(string);
        } else {
            try {
                Constructor<?> c = aClass.getConstructor(String.class);
                try {
                    //YOLO: try constructor with a String
                    result   = c.newInstance(string);
                } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
