import java.util.Scanner;

public class Main {
    public static String word, rWord;
    public static char letter;
    public static String [] wordTwo;

    public static void main(String[] args) {


        System.out.print("\nInput a word: ");
        Scanner translateWord = new Scanner(System.in);
        word = translateWord.nextLine();

        word = word.toLowerCase();


        String tWord = "";

        if (word.charAt(1) == 'a' && (word.charAt(2) == '1' || word.charAt(2) == '2' || word.charAt(2) == '3' || word.charAt(2) == '4' || word.charAt(2) == '5')) {
            translateTwo();
        } else if ((word.charAt(0) == '1' || word.charAt(0) == '2' || word.charAt(0) == '3' || word.charAt(0) == '4' || word.charAt(0) == '5') && word.charAt(2) == 'a') {
            translateTwo();
        } else if ((word.charAt(0) == '1' || word.charAt(0) == '2' || word.charAt(0) == '3' || word.charAt(0) == '4' || word.charAt(0) == '5') && (word.charAt(1) == '1' || word.charAt(1) == '2' || word.charAt(1) == '3' || word.charAt(1) == '4' || word.charAt(1) == '5') && word.charAt(3) == 'a') {
            translateTwo();
        }

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
            case ' ' -> {
                rWord = " ";
            }
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

    public static void translateTwo() {
        /*switch(letter) {
            default -> {
                rWord = letter.;
            }
        }*/
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