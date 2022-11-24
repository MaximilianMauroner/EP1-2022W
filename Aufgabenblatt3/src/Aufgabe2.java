/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSign(String text, char sign) {
        int charCounter = 1;
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i) + "");
            if (i < text.length() - 1) {
                for (int j = 0; j < charCounter; j++) {
                    System.out.print(sign);
                }
                charCounter++;
            }
        }
        System.out.println();
    }

    private static void addSign(int number, char sign) {
        addSign(Integer.toString(number), sign);
    }

    private static void addSign(String text, String signs) {
        for (int i = 0; i < signs.length(); i++) {
            addSign(text, signs.charAt(i));
        }
    }

    private static void addSign(String text) {
        addSign(text, '=');
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "IT";
        String text2 = "Hello!";
        String text3 = "+EP1+";
        String text4 = "INT";

        addSign(text0, '+');
        addSign(text1, '-');
        addSign(text2, '#');
        addSign(text3, '&');
        addSign(text4, '*');
        System.out.println();

        addSign(1, '$');
        addSign(42, '%');
        addSign(183, '.');
        addSign(4096, ':');
        addSign(65536, ']');
        System.out.println();

        addSign(text1, "/X/");
        addSign(text2, "(#?§");
        System.out.println();

        addSign(text0);
        addSign(text1);
        addSign(text2);
    }
}
