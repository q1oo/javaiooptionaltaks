package my.azamat;

import java.io.*;

public class OptionalTask4 {
    static final String fileOriginPath = "files/filefortask2-origin.java";
    static final String fileChangedPath = "files/filefortask4.java";

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
                String[] array = s.split(" ");
                for (String str : array) {
                    s1 += (str.length() > 2 ? str.toUpperCase() : str) + " ";
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
