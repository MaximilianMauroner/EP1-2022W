/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Er Generiert ein muster von 2 X die untereinander sind. Dabei ist auf der außen immer das '+' und innen das '*' zeichen
    // Vor und nache den X ist jeweils eine Zeile die aus 2 '#', die Zeile ist gleich breit wie das X muster und wird mit '|' aufgefüllt
    //

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    // Die Formatierung soll immer gleich sein
    // Versuchen die Schleifen auf das Minimum reduzieren
    // Funktionen nutzten


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung

    public static void printBorder(int width) {
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                System.out.print('#');
            } else {
                System.out.print('|');
            }
        }
        System.out.println();
    }

    public static void printX(int width) {
        for (int i = 0; i < width - 2; i++) {
            boolean drawStar = false;
            for (int j = 0; j < width; j++) {
                if (i + 1 == j) {
                    System.out.print("\\");
                    drawStar = !drawStar;
                } else if (i == width - j - 2) {
                    System.out.print("/");
                    drawStar = !drawStar;
                } else {
                    if (drawStar) {
                        System.out.print("*");
                    } else {
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void printPattern(int width) {
        printBorder(width);
        printX(width);
        printX(width);
        printBorder(width);
    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");
        printPattern(10 + 2);

        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }
}


