/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //
    // Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! 
    //
    //Frage 1:
    // der Fehler ist das [-1] in keinem array existiert also kann man nicht darauf zugreifen
    //Frage 2:
    // Da Arrays als Referenz übergeben wird und nicht als Wert (call by reference, call by value)
    //Frage 3:
    // hier wird nicht eine Kopie erstellt, sondern nur die Referenz "übergeben", dies sieht man, auch wenn man ein sout der beiden Arrays macht
    //Frage 4:
    // Denn hier wird nur der Variable in der Funktion die Referenz des Arrays zugewiesen und nicht, aber filledArray hat immer noch die gleiche Referenz auf das originale array

//      Zusatzfrage(n): Gehen Sie hier von eindimensionalen Arrays aus!
//
//      1. Welchen Datentyp muss der Indexausdruck haben, mit dem die Position in einem Array bestimmt wird?
//          Integer
//
//      2. Mussen Sie ein Array initialisieren?
//          Ja
//
//      3. Wie kann die Länge eines Arrays verändert werden?
//          Gar nicht, es muss eine neues array erstellt werden
//
//      4. Wie gehen Sie vor, wenn Sie ein int-Array kopieren mussen?
//          Entweder in einem for loop alle werte einzeln kopieren und in einem neuen array speichern oder funktionen der Arrays Klasse benutzten
//
//      5. Beginnt die Indexzählung eines Arrays immer bei 0?
//          Ja
//
//      6. Ist es sinnvoll, zwei Arrays mit "==" zu vergleichen? Was passiert im Detail, bei einem Vergleich mit "=="?
//          Ja, wenn man vergleichen will, ob beide Variablen die gleiche Referenz haben.
}
