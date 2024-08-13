import java.util.Scanner;

public class Main {
    public static String word, rWord;
    public static String buffer = "";
    public static char letter;
    public static String[] jlWord = new String[50];
    public static int j;
    public static boolean jl;

    public static void main(String[] args) {


        System.out.print("\nInput a word: ");
        Scanner translateWord = new Scanner(System.in);
        word = translateWord.nextLine();

        word = word.toLowerCase();


        String tWord = "";

        //Translates from Jungle Langauge to English
        for (j = 0; j < word.length(); j++) {
            if (j == 0) {
                switch (word.charAt(j)) {
                    case '1' -> {
                        jlWord[j] = "a";
                        buffer = buffer.concat(jlWord[j]);
                    }
                    case '2' -> {
                        jlWord[j] = "e";
                        buffer = buffer.concat(jlWord[j]);
                    }
                    case '3' -> {
                        jlWord[j] = "i";
                        buffer = buffer.concat(jlWord[j]);
                    }
                    case '4' -> {
                        jlWord[j] = "o";
                        buffer = buffer.concat(jlWord[j]);
                    }
                    case '5' -> {
                        jlWord[j] = "u";
                        buffer = buffer.concat(jlWord[j]);
                    }
                    case ' ' -> {
                        jlWord[j] = " ";
                        buffer = buffer.concat(jlWord[j]);
                    }
                }
            }
            if ((j+1) < (word.length())) {
                if (word.charAt(j+1) == 'a') {
                    jlWord[j] = String.valueOf(word.charAt(j));
                    buffer = buffer.concat(jlWord[j]);
                } else {
                    switch (word.charAt(j+1)) {
                        case '1' -> {
                            jlWord[j+1] = "a";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                        case '2' -> {
                            jlWord[j+1] = "e";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                        case '3' -> {
                            jlWord[j+1] = "i";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                        case '4' -> {
                            jlWord[j+1] = "o";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                        case '5' -> {
                            jlWord[j+1] = "u";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                        case ' ' -> {
                            jlWord[j+1] = " ";
                            buffer = buffer.concat(jlWord[j+1]);
                        }
                    }
                }
            }
        }
        jl = !buffer.isEmpty();

        rWord = buffer;

        if (jl) {
            System.out.println(word + " | " + rWord);
            tryAgain();
        } else {
            tWord = "";
            for (int i = 0; i < word.length(); i++) {
                letter = word.charAt(i);
                translate(letter);
                tWord = tWord.concat(rWord);
            }

            System.out.println(word + " | " + tWord);

            tryAgain();
        }
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