package my.azamat;

import java.io.*;
import java.util.Arrays;

public class OptionalTask3 {
    static final String fileOriginPath = "files/filefortask2-origin.java";
    static final String fileChangedPath = "files/filefortask3.java";

    public static void main(String[] args) {
        File fileOrigin = new File(fileOriginPath);
        File fileChanged = new File(fileChangedPath);
        if (fileChanged.exists()) {
            fileChanged.delete();
        }
        try (FileReader fileReader = new FileReader(fileOrigin); BufferedReader in = new BufferedReader(fileReader)) {
            String s = null;
            String s1 = "";
            while ((s = in.readLine()) != null) {
                char[] charArray = s.toCharArray();
                for (int i = charArray.length - 1; i >= 0; i--) {
                    s1 += charArray[i];
                }
                try (FileWriter fileWriter = new FileWriter(fileChanged, true)) {
                    fileWriter.write(s1);
                    fileWriter.write("\n");
                    s1 = "";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
