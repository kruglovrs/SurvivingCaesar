import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCipherEncryption {

    private static char encryptChar(char ch, int shift, ArrayList<Character> alphabet) {
        if (Character.isLetter(ch)) {
            int alphabetSize = alphabet.size();
            int currentIndex = alphabet.indexOf(Character.toUpperCase(ch));
            int newIndex = (currentIndex + shift) % alphabetSize;
            if (Character.isLowerCase(ch)) {
                return Character.toLowerCase(alphabet.get(newIndex));
            } else {
                return alphabet.get(newIndex);
            }
        }
        return ch;

    }

    public static void encryptFile(String inputFilePath, String outputFilePath, int shift, ArrayList<Character> ukrainianAlphabet) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                char encryptedChar = encryptChar((char) ch, shift, ukrainianAlphabet);
                writer.write(encryptedChar);
            }

            System.out.println("Файл успішно зашифрований і збережений у " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Помилка під час шифрування файлу: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        ArrayList<Character> ukrainianAlphabet = new ArrayList<>();
        for (char ch = 'А'; ch <= 'Я'; ch++) {
            ukrainianAlphabet.add(ch);
        }
        ukrainianAlphabet.add('Є');
        ukrainianAlphabet.add('І');
        ukrainianAlphabet.add('Ї');
        ukrainianAlphabet.add('Ґ');
        ukrainianAlphabet.add('.');
        ukrainianAlphabet.add(',');
        ukrainianAlphabet.add('"');
        ukrainianAlphabet.add(':');
        ukrainianAlphabet.add('-');
        ukrainianAlphabet.add('!');
        ukrainianAlphabet.add('?');
        ukrainianAlphabet.add(' ');

        Scanner scanner = new Scanner(System.in);
        System.out.println("Якщо ви хочете зашифрувати повідомлень введіть 1, якщо розшифрувати введіть 0.");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.print("Введіть шлях до вихідного текстового файлу: ");
            String inputFilePath = scanner.nextLine();
            System.out.print("Введіть шлях для збереження зашифрованого файлу: ");
            String outputFilePath = scanner.nextLine();
            System.out.print("Введіть ключ для шифру Цезаря (ціле число): ");
            int shift = scanner.nextInt();

            CaesarCipherEncryption.encryptFile(inputFilePath, outputFilePath, shift, ukrainianAlphabet);
        } else {
            System.out.println("Поки ще не готово");
        }
    }
}