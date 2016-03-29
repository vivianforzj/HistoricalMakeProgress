package personal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jzhou on 16-3-29.
 */
public class TryCatchVerifier {

    public void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file");
        } finally {
            System.out.println("Whatever happens, game over!");
            if (fr != null)
                fr.close();

            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {
        TryCatchVerifier verifier = new TryCatchVerifier();
        verifier.readFile("test.txt");
    }
}
