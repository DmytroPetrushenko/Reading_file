public class Main {
    public static void main(String[] args) {
        FileWork read = new FileWork();
        System.out.println(read.readFromFile("text.txt").length);
    }
}
