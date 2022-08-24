import java.io.IOException;

@Menu(title = "A Menu Title")
public class MockMenuTest {

    @MenuOption(description = "Do something cool")
    public void doMenuOption(
            @OptionParam(name = "First Name") String firstName,
            @OptionParam(name = "Last Name") String lastName) {
        System.out.println("Hello " + firstName + " " + lastName);
    }

    @MenuOption(description = "Do more things")
    public void doMoreThings(
            @OptionParam(name = "Your age") int age) {
        System.out.println("Age: " + age);
    }

    @MenuOption(description = "Do another thing")
    public void doOtherThings(
            @OptionParam(name = "Your Salary") int salary) {
        System.out.println("Salary: " + salary);
    }

    @MenuOption(description = "Sum some numbers")
    public void summation(@OptionParam(name = "first number") int a, @OptionParam(name = "second number") int b) {
        System.out.println("The sum is " + (a+b));
    }

    public static void main(String[] args) throws IOException {
        CliMenuFactory.createFactory(new MockMenuTest()).setConverter(new DefaultInputConverter()).setConverter((original, toClass) -> {
            if (toClass.equals(Integer.class) || toClass.equals(Integer.TYPE)) {
                return Integer.parseInt(original) + 3;
            } else {
                return null;
            }
        }).build()
                .menuLoop();
    }
}
