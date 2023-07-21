import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter = 'А'; letter <= 'Я'; letter++) {
            alphabet.add(letter);
        }
        alphabet.add('Є');
        alphabet.add('Ґ');
        alphabet.add('Ї');
        alphabet.add('.');
        alphabet.add(',');
        alphabet.add('”');
        alphabet.add(':');
        alphabet.add('-');
        alphabet.add('!');
        alphabet.add('?');
        alphabet.add(' ');

        System.out.println(alphabet);
        System.out.println(alphabet.size());
        System.out.println("Введіть шлях до файлу, який треба закодувати");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        encrypt(src,0);

    }

    private static void encrypt(String src, int key) {
        int index = src.indexOf(".");
        String dest = src.substring(0, index) + "_Caesar";
        try(FileReader reader = new FileReader(src);
            FileWriter writer = new FileWriter(dest))
        {
            char[] buffer = new char[65536]; // 128Kb
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dest);
    }
}