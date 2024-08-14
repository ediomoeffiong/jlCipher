import java.util.Scanner;

public class Main {
    public static String word, rWord;
    public static String buffer;
    public static char letter;
    public static String[] jlWord = new String[1000];
    public static int j;
    public static boolean jl, noPresent, noPresentFirst;

    public static void main(String[] args) {

        buffer = "";
        rWord = "";
        word = "";
        jlWord = new String[1000];
        j = 0;
        jl = false;
        noPresentFirst = false;
        noPresent = false;

        // Collects the word
        System.out.print("\nInput a word or sentence: ");
        Scanner translateWord = new Scanner(System.in);
        word = translateWord.nextLine();
        System.out.print("\n");

        word = word.toLowerCase();


        String tWord = "";

        //Translates from Jungle Language to English
        for (j = 0; j < word.length(); j++) {
            if (word.charAt(j) == '\'' || word.charAt(j) == '\"' || word.charAt(j) == '.' || word.charAt(j) == ',' || word.charAt(j) == '~' || word.charAt(j) == '`' || word.charAt(j) == '!' || word.charAt(j) == '@' || word.charAt(j) == '#') {
                jlWord[j] = String.valueOf(word.charAt(j));
                buffer = buffer.concat(jlWord[j]);
                continue;
            } else if (word.charAt(j) == '$' || word.charAt(j) == '%' || word.charAt(j) == '^' || word.charAt(j) == '&' || word.charAt(j) == '*' || word.charAt(j) == '(' || word.charAt(j) == ')') {
                jlWord[j] = String.valueOf(word.charAt(j));
                buffer = buffer.concat(jlWord[j]);
                continue;
            } else if (word.charAt(j) == '-' || word.charAt(j) == '_' || word.charAt(j) == '+' || word.charAt(j) == '=' || word.charAt(j) == '{' || word.charAt(j) == '}' || word.charAt(j) == '[') {
                jlWord[j] = String.valueOf(word.charAt(j));
                buffer = buffer.concat(jlWord[j]);
                continue;
            } else if (word.charAt(j) == ']' || word.charAt(j) == '|' || word.charAt(j) == '\\' || word.charAt(j) == ':' || word.charAt(j) == ';' || word.charAt(j) == '?' || word.charAt(j) == '/') {
                jlWord[j] = String.valueOf(word.charAt(j));
                buffer = buffer.concat(jlWord[j]);
                continue;
            }

            if (j == 0) {
                //Ciphers vowel letters if they appear in the first index
                //Solves problems of them being exempted when printed out to the screen
                noPresentFirst = true;
                switch (word.charAt(j)) {
                    case '1' -> {
                        jlWord[j] = "a";
                        buffer = buffer.concat(jlWord[j]);
                        noPresent = true;
                    }
                    case '2' -> {
                        jlWord[j] = "e";
                        buffer = buffer.concat(jlWord[j]);
                        noPresent = true;
                    }
                    case '3' -> {
                        jlWord[j] = "i";
                        buffer = buffer.concat(jlWord[j]);
                        noPresent = true;
                    }
                    case '4' -> {
                        jlWord[j] = "o";
                        buffer = buffer.concat(jlWord[j]);
                        noPresent = true;
                    }
                    case '5' -> {
                        jlWord[j] = "u";
                        buffer = buffer.concat(jlWord[j]);
                        noPresent = true;
                    }
                    case ' ' -> {
                        jlWord[j] = " ";
                        buffer = buffer.concat(jlWord[j]);
                    }
                }
            }
            //Ciphers consonant letters
            if ((j+1) < (word.length())) {
                if (word.charAt(j+1) == 'a') {
                    jlWord[j] = String.valueOf(word.charAt(j));
                    buffer = buffer.concat(jlWord[j]);
                } else {
                    // Ciphers vowel letters
                    switch (word.charAt(j+1)) {
                        case '1' -> {
                            jlWord[j+1] = "a";
                            buffer = buffer.concat(jlWord[j+1]);
                            noPresent = true;
                        }
                        case '2' -> {
                            jlWord[j+1] = "e";
                            buffer = buffer.concat(jlWord[j+1]);
                            noPresent = true;
                        }
                        case '3' -> {
                            jlWord[j+1] = "i";
                            buffer = buffer.concat(jlWord[j+1]);
                            noPresent = true;
                        }
                        case '4' -> {
                            jlWord[j+1] = "o";
                            buffer = buffer.concat(jlWord[j+1]);
                            noPresent = true;
                        }
                        case '5' -> {
                            jlWord[j+1] = "u";
                            buffer = buffer.concat(jlWord[j+1]);
                            noPresent = true;
                        }
                        case ' ' -> {
                            jlWord[j+1] = " ";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                    }
                }
            }
        }

        //Enables
        jl = !buffer.isEmpty() && noPresent && noPresentFirst;

        rWord = buffer;

        if (jl) {
            System.out.println("Language Detected: Jungle Language");
            System.out.println(word + " | " + rWord);
            tryAgain();
        } else {
            tWord = "";
            for (int i = 0; i < word.length(); i++) {
                letter = word.charAt(i);
                translate(letter);
                tWord = tWord.concat(rWord);
            }

            System.out.println("Language Detected: English Language");
            System.out.println(word + " | " + tWord);

            tryAgain();
        }
    }


    // Translates from English to Jungle language
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


    // Runs the program again depending on the user input
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