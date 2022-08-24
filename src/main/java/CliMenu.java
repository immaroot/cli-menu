import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CliMenu {

    private final String title;
    private final CliMenuOptionTable options;
    private final InputConverter converter;

    public CliMenu(String title, CliMenuOptionTable options, InputConverter converter) {
        this.title     = title;
        this.options   = options;
        this.converter = converter;
    }

    public String getTitle() {
        return title;
    }

    public void printTitle() {
        System.out.println(getTitle());
    }

    public void printOptions() {
        options.forEach(option -> System.out.println(option.getIndex() + " - " + option.getDescription()));
        System.out.println("0 - Exit");
    }

    public void menuLoop() throws IOException {
        boolean exit = false;
        int option = -1;
        while (!exit){
            printTitle();
            printOptions();
            try {
                option = ConsoleIO.readUserOption();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (option <= 0) {
                exit = true;
            } else {
                CliMenuOption method = options.get(option);

                List<CliMenuOptionParam> menuOptionParams = method.getParams();

                List<Object> params = new ArrayList<>();

                for (CliMenuOptionParam param : menuOptionParams) {
                    System.out.println(param.name + ": ");
                    String input = ConsoleIO.readUserInput();

                    params.add(converter.convertInput(input, param.parameter.getType()));
                }

                method.invoke(params.toArray());
            }
        }
    }
}
