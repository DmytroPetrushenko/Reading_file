import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try {
            StringBuilder result = new StringBuilder();
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String value = input.readLine();
            while (value != null) {
                result.append(value.replaceAll("[A-Za-z]", "")).append(" ");
                value = input.readLine();
            }
            System.out.println(result);
        } catch (IOException e)  {
            throw new RuntimeException("Can't read file", e);
        }
        return null;
    }
}
