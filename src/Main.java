import java.util.Scanner;

public class Main {
    public static String word, rWord;
    public static char letter;

    public static void main(String[] args) {


        System.out.print("\nInput a word: ");
        Scanner translateWord = new Scanner(System.in);
        word = translateWord.nextLine();

        word = word.toLowerCase();


        String tWord = "";
        for (int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            translate(letter);
            tWord = tWord.concat(rWord);
        }

        System.out.println(word + " | " + tWord);

        tryAgain();


    }

    public static void translate(char letter) {
        switch (letter) {
            case 'u' -> {
                letter = '5';
                rWord = String.valueOf(letter);
            }
            case 'o' -> {
                letter = '4';
                rWord = String.valueOf(letter);
            }
            case 'i' -> {
                letter = '3';
                rWord = String.valueOf(letter);
            }
            case 'e' -> {
                letter = '2';
                rWord = String.valueOf(letter);
            }
            case 'a' -> {
                letter = '1';
                rWord = String.valueOf(letter);
            }
            default -> {
                rWord = letter + "a";
            }
        }

    }


    public static void tryAgain() {
        System.out.println("\nDo you want to translate again (Y/N): ");
        Scanner scanOpp = new Scanner(System.in);
        String option = scanOpp.nextLine();

        option = option.toLowerCase();

        if (option.equals("y")) {
            String[] call = {"call"};
            main(call);
        } else if (option.equals("n")) {
            System.exit(0);
        } else {
            System.out.println("\nPlease input the right option!");
            tryAgain();
        }
    }
}