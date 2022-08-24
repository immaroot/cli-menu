import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.function.Consumer;

public class CliMenuOptionTable extends AbstractList<CliMenuOption> implements Iterable<CliMenuOption> {

    private final List<CliMenuOption> optionTable = new ArrayList<>();

    public void addMenuOption(int index, String name, Method method, Object handler) {
        List<CliMenuOptionParam> params = new ArrayList<>();
        for (Parameter parameter : method.getParameters()) {
            params.add(new CliMenuOptionParam(parameter.getAnnotation(OptionParam.class).name(), parameter));
        }
        CliMenuOption option = new CliMenuOption(index, name, method, handler, params);
        optionTable.add(option);
    }

    @Override
    public CliMenuOption get(int index) {
        return optionTable.get(index - 1);
    }

    @Override
    public void add(int index, CliMenuOption element) {
        super.add(index - 1, element);
    }

    @Override
    public Iterator<CliMenuOption> iterator() {
        return optionTable.iterator();
    }

    @Override
    public int size() {
        return optionTable.size();
    }

    @Override
    public void forEach(Consumer<? super CliMenuOption> action) {
        optionTable.forEach(action);
    }

    @Override
    public Spliterator<CliMenuOption> spliterator() {
        return optionTable.spliterator();
    }
}
