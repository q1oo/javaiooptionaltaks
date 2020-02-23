package my.azamat;

import java.io.*;
import java.util.Arrays;

public class OptionalTask5 {
    static final String fileOriginPath = "files/filefortask5.txt";
    static final String fileChangedPath = "files/filefortask5-changed.txt";

    public static void main(String[] args) {
        File fileOrigin = new File(fileOriginPath);
        File fileChanged = new File(fileChangedPath);
        if (fileOrigin.exists()) {
            fileOrigin.delete();
        }
        if (fileChanged.exists()) {
            fileChanged.delete();
        }
        try (FileWriter fileWriter = new FileWriter(fileOrigin)) {
            fileWriter.write("Ivanov,5,5,6,7,9,10\n");
            fileWriter.write("Petrov,8,8,9,7,9,10\n");
            fileWriter.write("Sidorov,6,7,1,5,7,8\n");
            fileWriter.write("Kozlov,9,9,9,9,9,9\n");
            fileWriter.write("Sokolov,7,6,3,8,9,4");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(fileOrigin); BufferedReader in = new BufferedReader(fileReader)) {
            String s = null;
            while ((s = in.readLine()) != null) {
                String[] array = s.split(",");
                int sum = 0;
                for (int i = 1; i < array.length; i++) {
                    sum += Integer.parseInt(array[i]);
                }
                if (sum / (array.length - 1) > 7) {
                    String str = array[0].toUpperCase();
                    s = s.replace(array[0], str);
                }
                try (FileWriter fileWriter = new FileWriter(fileChanged, true)) {
                    fileWriter.write(s + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileOrigin.delete();
        fileChanged.renameTo(new File(fileOriginPath));
    }
}
