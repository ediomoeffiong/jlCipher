import java.util.Scanner;

public class Main {
    public static String word, rWord, buffer;
    public static char letter;
    public static char[] jlWord = new char[1000];
    public static int j;
    public static boolean jl, jlConfirmation1, jlConfirmation2;
    public static String tWord = "";

    public static void main(String[] args) {

        // Defining Variables
        buffer = "";
        rWord = "";
        word = "";
        jlWord = new char[1000];
        j = 0;
        jl = false;
        jlConfirmation1 = false;
        jlConfirmation2 = false;

        // Collects the word
        System.out.print("\nInput a word: ");
        Scanner translateWord = new Scanner(System.in);
        word = translateWord.nextLine();
        System.out.print("\n");

        word = word.toLowerCase();

        //Breaks down the sentence to words then passes it to the translation method

        checkLang(word);

        //Removed language detection
        //Enables language detection for accurate translation

        tryAgain();
        translateWord.close();
    }


    // Checks language if it is English or Jungle Language
    public static void checkLang(String word) {
        for (j = 0; j < word.length(); j++) {
            if (word.charAt(j) == 'a') {
                jlConfirmation1 = true;
            } if (word.charAt(j) == '1' || word.charAt(j) == '2' || word.charAt(j) == '3' || word.charAt(j) == '4' || word.charAt(j) == '5') {
                jlConfirmation2 = true;
            }
        }
        if (jlConfirmation1 && jlConfirmation2) {
            jl = true;
        }

        if (jl) {
            translateJL(word);
            System.out.println("Language Detected: Jungle Language");
            System.out.println(word + " | " + buffer);
            tryAgain();
        } else {
            tWord = "";
            for (int i = 0; i < word.length(); i++) {
                letter = word.charAt(i);
                translateENG(letter);
                tWord = tWord.concat(rWord);
            }
        }

        System.out.println("Language Detected: English Language");
        System.out.println(tWord);
    }


    // Translates from English to Jungle language
    public static void translateENG(char letter) {
        switch (letter) {
            case ' ':
                rWord = " ";
                break;
            case 'u':
                letter = '5';
                rWord = String.valueOf(letter);
                break;
            case 'o':
                letter = '4';
                rWord = String.valueOf(letter);
                break;
            case 'i':
                letter = '3';
                rWord = String.valueOf(letter);
                break;
            case 'e':
                letter = '2';
                rWord = String.valueOf(letter);
                break;
            case 'a':
                letter = '1';
                rWord = String.valueOf(letter);
                break;
            default:
                rWord = letter + "a";
                break;
        }

        //Resolves for character
        if (letter == '\'' || letter == '\"' || letter == '.' || letter == ',' || letter == '~' || letter == '`' || letter == '!' || letter == '@' || letter == '#') {
            rWord = String.valueOf(letter);
        } else if (letter == '$' || letter == '%' || letter == '^' || letter == '&' || letter == '*' || letter == '(' || letter == ')') {
            rWord = String.valueOf(letter);
        } else if (letter == '-' || letter == '_' || letter == '+' || letter == '=' || letter == '{' || letter == '}' || letter == '[') {
            rWord = String.valueOf(letter);
        } else if (letter == ']' || letter == '|' || letter == '\\' || letter == ':' || letter == ';' || letter == '?' || letter == '/') {
            rWord = String.valueOf(letter);
        }

    }

    // Translates from Jungle language to English Language
    public static void translateJL(String word) {
        for (j = 0; j < word.length(); j++) {
            //Resolves characters
            if (word.charAt(j) == '\'' || word.charAt(j) == '\"' || word.charAt(j) == '.' || word.charAt(j) == ',' || word.charAt(j) == '~' || word.charAt(j) == '`' || word.charAt(j) == '!' || word.charAt(j) == '@' || word.charAt(j) == '#') {
                jlWord[j] = word.charAt(j);
                buffer = buffer.concat(String.valueOf(jlWord[j]));
                continue;
            } else if (word.charAt(j) == '$' || word.charAt(j) == '%' || word.charAt(j) == '^' || word.charAt(j) == '&' || word.charAt(j) == '*' || word.charAt(j) == '(' || word.charAt(j) == ')') {
                jlWord[j] = word.charAt(j);
                buffer = buffer.concat(String.valueOf(jlWord[j]));
                continue;
            } else if (word.charAt(j) == '-' || word.charAt(j) == '_' || word.charAt(j) == '+' || word.charAt(j) == '=' || word.charAt(j) == '{' || word.charAt(j) == '}' || word.charAt(j) == '[') {
                jlWord[j] = word.charAt(j);
                buffer = buffer.concat(String.valueOf(jlWord[j]));
                continue;
            } else if (word.charAt(j) == ']' || word.charAt(j) == '|' || word.charAt(j) == '\\' || word.charAt(j) == ':' || word.charAt(j) == ';' || word.charAt(j) == '?' || word.charAt(j) == '/') {
                jlWord[j] = word.charAt(j);
                buffer = buffer.concat(String.valueOf(jlWord[j]));
                continue;
            }

            /*  Resolves vowel letters
                If they appear in the first index
                Solves problems of them being exempted when printed out to the screen
                Remember to fix the case assuming this is found at the beginning of
                a sentence or after a period mark.
            */
            if (j == 0) {
                switch (word.charAt(j)) {
                    case '1':
                        jlWord[j] = 'a';
                        buffer = buffer.concat(String.valueOf(jlWord[j]));
                        break;
                    case '2':
                        jlWord[j] = 'e';
                        buffer = buffer.concat(String.valueOf(jlWord[j]));
                        break;
                    case '3':
                        jlWord[j] = 'i';
                        buffer = buffer.concat(String.valueOf(jlWord[j]));
                        break;
                    case '4':
                        jlWord[j] = 'o';
                        buffer = buffer.concat(String.valueOf(jlWord[j]));
                        break;
                    case '5':
                        jlWord[j] = 'u';
                        buffer = buffer.concat(String.valueOf(jlWord[j]));
                        break;
                    case ' ':
                        jlWord[j] = ' ';
                        buffer = buffer.concat(String.valueOf(jlWord[j]));
                        break;
                }
            }

            // Deciphers consonant letters
            if ((j+1) < (word.length())) {
                if (word.charAt(j+1) == 'a') {
                    jlWord[j] = word.charAt(j);
                    buffer = buffer.concat(String.valueOf(jlWord[j]));
                } else {
                    // Deciphers vowel letters
                    switch (word.charAt(j+1)) {
                        case '1':
                            jlWord[j] = '1';
                            buffer = buffer.concat("a");
                            break;
                        case '2':
                            jlWord[j] = '2';
                            buffer = buffer.concat("e");
                            break;
                        case '3':
                            jlWord[j] = '3';
                            buffer = buffer.concat("i");
                            break;
                        case '4':
                            jlWord[j] = '4';
                            buffer = buffer.concat("o");
                            break;
                        case '5':
                            jlWord[j] = '5';
                            buffer = buffer.concat("u");
                            break;
                        case ' ':
                            jlWord[j] = ' ';
                            buffer = buffer.concat(String.valueOf(jlWord[j]));
                            break;
                    }
                }
            }
        }
    }


    // Runs the program again depending on the user choice
    public static void tryAgain() {
        System.out.print("\nDo you want to translate again (Y/N): ");
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