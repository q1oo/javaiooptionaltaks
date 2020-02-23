package my.azamat;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class OptionalTask1 {

    static final String filePath = "files/filefortask1.txt";

    public static void main(String[] args) {
        File file = new File(filePath);
        Random random = new Random();
        String[] arr = new String[20];
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = random.nextInt(100);
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(Arrays.toString(array));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(filePath); BufferedReader in = new BufferedReader(fileReader)) {
            arr = in.readLine().split(", ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = arr[i].replace("[", "");
            } else if (i == arr.length - 1) {
                arr[i] = arr[i].replace("]", "");
            }
            array[i] = Integer.parseInt(arr[i]);
        }
        Arrays.parallelSort(array);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(Arrays.toString(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
