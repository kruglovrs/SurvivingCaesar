import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter = 'А'; letter <= 'Я'; letter++) {
            alphabet.add(letter);
        }
        alphabet.add('Є');
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
    }
}