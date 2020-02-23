package my.azamat;

import java.io.*;

public class OptionalTask2 {
    static final String fileOriginPath = "files/filefortask2-origin.java";
    static final String fileChangedPath = "files/filefortask2-changed.java";

    public static void main(String[] args) {
        File fileOrigin = new File(fileOriginPath);
        File fileChanged = new File(fileChangedPath);
        if (fileChanged.exists()) {
            fileChanged.delete();
        }
        try (FileReader fileReader = new FileReader(fileOrigin); BufferedReader in = new BufferedReader(fileReader)) {
            String s = null;
            String s1 = null;
            while ((s = in.readLine()) != null) {
                s1 = s;
                if (s.contains("public")) {
                    s1 = s.replace("public", "private");
                }
                try (FileWriter fileWriter = new FileWriter(fileChanged, true)) {
                    fileWriter.write(s1);
                    fileWriter.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
