import java.util.Arrays;

/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int[] a_aufgabe_arr = new int[]{6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
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
        int[] b_aufgabe_arr = new int[12];
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
        System.out.println();
//

        int[] c_aufgabe_arr = new int[]{7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        int counter = 0;
        for (int i = 0; i < c_aufgabe_arr.length; i++) {
            if (c_aufgabe_arr[i] == 7) {
                counter++;
            }
        }
        int[] c_two_aufgabe_arr = new int[c_aufgabe_arr.length + counter];
        int index = 0;
        for (int i = 0; i < c_aufgabe_arr.length; i++) {
            c_two_aufgabe_arr[index] = c_aufgabe_arr[i];
            index++;
            if (c_aufgabe_arr[i] == 7) {
                c_two_aufgabe_arr[index] = -1;
                index++;
            }
        }
        System.out.println(Arrays.toString(c_two_aufgabe_arr));
//
        System.out.println();
//
        int[] d_aufgabe_arr = new int[11];
        for (int i = 0; i < d_aufgabe_arr.length; i++) {
            d_aufgabe_arr[i] = i + 1;
        }
        System.out.print("for-Schleife: ");
        for (int i = d_aufgabe_arr.length - 1; i >= 0; i--) {
            System.out.print(d_aufgabe_arr[i]);
            if (i != 0) {
                System.out.print(",");
            } else {
                System.out.println();
            }
        }
        System.out.print("while-Schleife: ");
        int j = d_aufgabe_arr.length -1;
        while(j >= 0){
            System.out.print(d_aufgabe_arr[j]);
            if (j != 0) {
                System.out.print(",");
            } else {
                System.out.println();
            }
            j--;
        }
    }
}

