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
        double[][] newWA = new double[workArray.length][];
        for (int i = 0; i < workArray.length; i++) {
            newWA[i] = new double[workArray[i].length];
            for (int j = 0; j < workArray[i].length; j++) {
                if (filterable(workArray, filterArray, i, j)) {
                    newWA[i][j] = sumPartials(workArray, filterArray, i, j);
                } else {
                    newWA[i][j] = 0;
                }
            }
        }
        return newWA;
    }

//    helper methods

    public static double sumPartials(double[][] workArray, double[][] filterArray, int row, int col) {
        double sum = 0;
        int workRow = row - filterArray.length / 2;
        for (int i = 0; i < filterArray.length; i++) {
            int workCol = col - filterArray.length / 2;
            for (int j = 0; j < filterArray[i].length; j++) {
                sum += workArray[workRow][workCol] * filterArray[i][j];
                workCol++;
            }
            workRow++;
        }
        return sum;
    }

    public static boolean filterable(double[][] workArray, double[][] filterArray, int row, int col) {
        int filterLen = filterArray.length;
        int filterHalf = filterLen / 2;
        int workLen = workArray.length;
        int workColLen = workArray[row].length;
        if (row >= filterHalf && filterHalf + row < workLen) {
            if (col >= filterHalf && filterHalf + col < workColLen) {
                return true;
            }
        }
        return false;
    }

    //    end helper methods
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

//        double[][] myFilter1 = genCircleFilter(3, 1.2);
//        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
//        print(myFilter1);
//
//        double[][] myFilter2 = genCircleFilter(7, 2.5);
//        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
//        print(myFilter2);
//
//        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
//        System.out.println("Output -> myArray1:");
//        print(myArray1);
//
//        myResultArray = applyFilter(myArray1, myFilter1);
//        System.out.println("Output -> myFilter1 applied to myArray1:");
//        print(myResultArray);
//
//        myResultArray = applyFilter(myArray1, myFilter2);
//        System.out.println("Output -> myFilter2 applied to myArray1:");
//        print(myResultArray);

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
        double[][] myFilter4 = {{0, 0, 0}, {0, 0, 0}, {0, 0.5, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        System.out.println("Output -> myFilter4:");
        print(myFilter4);
        myResultArray = applyFilter(myArray4, myFilter4);
        System.out.println("Output -> myFilter4 applied to myArray4:");
        print(myResultArray);
    }


}
