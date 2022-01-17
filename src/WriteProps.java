import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteProps {
    private String wrstr;

    void trueWriterString(String wrstr) {
        this.wrstr = wrstr;

        FileWriter fwr = null;
        String string = wrstr;
        File file = new File("src/app.properties");

        try {
            fwr = new FileWriter(file, true);
            fwr.write(string);
            fwr.write("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fwr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void trueClearFile() {

        FileWriter fwr = null;
        String string = "";
        File file = new File("src/app.properties");

        try {
            fwr = new FileWriter(file, false);
            fwr.write(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fwr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
