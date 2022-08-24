import java.io.*;

public class ConsoleIO {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleIO() {
    }

    public static int readUserOption() throws IOException {
        return Integer.parseInt(readUserInput());
    }

    public static String readUserInput() throws IOException {
        return in.readLine();
    }
}
