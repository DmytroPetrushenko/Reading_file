import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    StringBuilder finalString = new StringBuilder();
    StringBuilder draftString = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                draftString.append(value.replaceAll("[,!:;.?]", "")).append(" ");
                value = bufferedReader.readLine();
            }
            for (String word: (draftString.toString().split(" "))) {
                if (checkWord(word)) {
                    finalString.append(word.toLowerCase()).append(" ");
                }
            }
            return sortArray(finalString.toString().split(" "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkWord(String word) {
        return word.toLowerCase().startsWith(SPECIFIED_CHARACTER);
    }

    private String[] sortArray(String[] array) {
        if (array[0].equals("") && array.length == 1) {
            return new String[0];
        }
        String buffer;
        boolean flag = false;

        while (!flag) {
            flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i+1]) > 0) {
                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1 ] = buffer;
                    flag = false;
                }
            }
        }
        return array;
    }
}
