/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int[] a_aufgabe_arr = new int[]{6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        int[] b_aufgabe_arr = new int[12];
        for (int i = 0; i < a_aufgabe_arr.length; i++) {
            if (a_aufgabe_arr.length == i + 1) {
                System.out.print(a_aufgabe_arr[i]);
            } else {
                System.out.print(a_aufgabe_arr[i] + "#");
            }
        }
//
        System.out.println();
//
        for (int i = 0; i < b_aufgabe_arr.length; i++) {
            b_aufgabe_arr[i] = (i + 1) * 6;
            if (b_aufgabe_arr[i] % 9 == 0) {
                b_aufgabe_arr[i] = 0;
            }
            if (b_aufgabe_arr.length == i + 1) {
                System.out.print(b_aufgabe_arr[i]);
            } else {
                System.out.print(b_aufgabe_arr[i] + " ");
            }
        }
//
    }
}

