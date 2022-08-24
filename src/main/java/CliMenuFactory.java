import java.lang.reflect.Method;

public class CliMenuFactory {

    Class<?> aClass;
    String title;
    CliMenuOptionTable options;
    InputConverter converter;
    Object menuObject;

    private CliMenuFactory() {
    }

    public CliMenuFactory setMenuClass(Class<?> aClass) {
        this.aClass = aClass;
        return this;
    }

    public CliMenuFactory setMenuObject(Object menuObject) {
        this.menuObject = menuObject;
        return this;
    }

    public CliMenuFactory setConverter(InputConverter converter) {
        this.converter = converter;
        return this;
    }

    public static CliMenuFactory createFactory(Object menuObject) {
        return new CliMenuFactory().setMenuObject(menuObject).setMenuClass(menuObject.getClass());
    }

    public CliMenu build() {
        title   = aClass.getAnnotation(Menu.class).title();
        options = new CliMenuOptionTable();
        int index = 1;

        for (Method method : aClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MenuOption.class)) {
                options.addMenuOption(index++, method.getAnnotation(MenuOption.class).description(), method, menuObject);
            }
        }

        if (converter == null) {
            converter = new DefaultInputConverter();
        }
        return new CliMenu(title, options, converter);
    }
}