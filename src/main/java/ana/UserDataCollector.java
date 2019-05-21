package ana;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;
// import org.beryx.textio.demo.app;
import java.time.Month;
import java.util.function.BiConsumer;

/**
 * A simple application illustrating the use of TextIO.
 */
public class UserDataCollector {
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        String user = textIO.newStringInputReader()
        .withDefaultValue("admin")
        .read("Username");

String password = textIO.newStringInputReader()
        .withMinLength(6)
        .withInputMasking(true)
        .read("Password");

int age = textIO.newIntInputReader()
        .withMinVal(13)
        .read("Age");

Month month = textIO.newEnumInputReader(Month.class)
        .read("What month were you born in?");

TextTerminal<?> terminal = textIO.getTextTerminal();
terminal.printf("\nUser %s is %d years old, was born in %s and has the password %s.\n",
        user, age, month, password);
    }

    // @Override
    // public void accept(TextIO textIO, RunnerData runnerData) {
    //     TextTerminal<?> terminal = textIO.getTextTerminal();
    //     String initData = (runnerData == null) ? null : runnerData.getInitData();
    //     AppUtil.printGsonMessage(terminal, initData);

    //     String user = textIO.newStringInputReader()
    //             .withDefaultValue("admin")
    //             .read("Username");

    //     String password = textIO.newStringInputReader()
    //             .withMinLength(6)
    //             .withInputMasking(true)
    //             .read("Password");

    //     int age = textIO.newIntInputReader()
    //             .withMinVal(13)
    //             .read("Age");

    //     Month month = textIO.newEnumInputReader(Month.class)
    //             .read("What month were you born in?");

    //     terminal.printf("\nUser %s is %d years old, was born in %s and has the password %s.\n", user, age, month, password);

    //     textIO.newStringInputReader().withMinLength(0).read("\nPress enter to terminate...");
    //     textIO.dispose("User '" + user + "' has left the building.");
    // }

    // @Override
    // public String toString() {
    //     return getClass().getSimpleName() + ": reading personal data.\n" +
    //             "(Properties are initialized at start-up.\n" +
    //             "Properties file: " + getClass().getSimpleName() + ".properties.)";
    // }
}
