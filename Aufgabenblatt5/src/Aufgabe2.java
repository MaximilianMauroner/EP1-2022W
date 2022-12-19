import java.util.Arrays;

/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genCircleFilter(int n, double radius) {
        if (n % 2 == 0 || n < 1) {
            return null;
        }
        int middle = (n - 1) / 2;
        double[][] nsq = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = Math.abs(i - middle);
                int y = Math.abs(j - middle);
                if (Math.sqrt(x * x + y * y) < radius) {
                    nsq[i][j] = 1;
                }
            }
        }
        return nsq;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        System.out.println(Arrays.deepToString(workArray));
        double[][] newWA = new double[workArray.length][];
        for (int i = 0; i < workArray.length; i++) {
            double[] t = new double[workArray[i].length];
            for (int j = 0; j < workArray[i].length; j++) {
                int sum = 0;
                int center = filterArray.length;
                if (center + i < workArray.length && center - i < 0 && center + j < workArray[i].length && center - j < 0) {
                    System.out.println(i + " " + j);
                    for (int k = 0; k < filterArray.length; k++) {
                        for (int l = 0; l < filterArray[k].length; l++) {
                            sum += workArray[i + k][j + l] * filterArray[k][l];
                        }
                    }
                }
                t[j] = sum;
            }
            newWA[i] = t;
        }
        return null;
    }

    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);

        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

        //Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 2, 3, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        //TODO: Erstellen Sie den Filter aus dem Aufgabenblatt, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
    }


}
