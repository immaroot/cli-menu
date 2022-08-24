import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;

public class CliMenuOption {

    private final int index;
    private final String description;
    private final Method method;
    private final Object handler;
    private final List<CliMenuOptionParam> params;

    public CliMenuOption(int index, String description, Method method, Object handler, List<CliMenuOptionParam> params) {
        this.index       = index;
        this.description = description;
        this.method      = method;
        this.handler     = handler;
        this.params      = params;
    }

    public void invoke(Object[] params) {
        assert method != null;
        try {
            method.invoke(handler, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public int getIndex() {
        return index;
    }

    public List<CliMenuOptionParam> getParams() {
        return params;
    }
}
