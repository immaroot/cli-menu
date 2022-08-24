import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class CliMenuOptionParam {

    String name;
    Parameter parameter;

    public CliMenuOptionParam(String name, Parameter parameter) {
        this.name      = name;
        this.parameter = parameter;
    }
}
