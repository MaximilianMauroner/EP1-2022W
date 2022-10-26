import java.math.BigDecimal;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;

public class Testaufgabe {
    public static void main(String[] args) {
//        short result;
//        String test = "Teststring_Einstufungstest";
//        System.out.println(myMulti(21, 4));
//        System.out.println(myMulti(2, 3500));
//        result = (short) myMulti(3, 7);
//        System.out.println(getThird("toss", "a", "coin"));
//        System.out.println(getThird("Teststring", "bleibt", test.substring(0, 10)));
//        System.out.println(getThird("EP1", "EP1", "EP1"));
//
//        System.out.println(replaceNthChar(test, 1, '0'));
//        System.out.println(replaceNthChar(test, 3, '#'));
//        System.out.println(replaceNthChar(test, 10, '-'));
//        System.out.println(replaceNthChar(test, 30, 'X'));
//        System.out.println(replaceNthChar("A", 1, '#'));
//        printPattern(3, '*');
//        printPattern(5, '+');
//
//        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
//        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
//        int[] target1 = {0, 0, 0};
//        int[] target2 = {9, 9, 9, 9};
//
//        toStringify2D(labelPath(3, new int[][]{}));
//        toStringify2D(labelPath(4, data0));
//        findMatches(data0, data0[1], target1);
//        findMatches(data1, data0[1], target1);
//        findMatches(data1, data0[2], target2);


//        System.out.println(insertMiddle("XY", "abc")); //0-12/34-56.7-89/01-23
//        System.out.println(insertMiddle("01234", "abc")); //0-12/34-56.7-89/01-23
//        System.out.println(insertMiddle("01234567890123", "./-")); //0-12/34-56.7-89/01-23
        int a = Integer.MAX_VALUE;
        long b = 0L;
        long c = ++a + b;
        System.out.println(c);
    }

    public static void toStringify2D(int[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            toStringify(temp[i]);
        }
    }

    public static void toStringify(int[] t) {
        for (int j = 0; j < t.length; j++) {
            System.out.print(t[j]);
        }
        System.out.print("\n");
    }

    public static int myMulti(int x, int y) {
        int ret = 0;
        for (int i = 0; i < y; i++) {
            ret += x;
        }
        return ret;
    }

    public static String getThird(String a, String b, String c) {
        if (a.equals(b) && b.equals(c)) {
            return "alle gleich";
        } else if (!a.equals(b) && !b.equals(c) && !a.equals(c)) {
            return "alle unterschiedlich";
        } else if (a.equals(b)) {
            return c;
        } else if (a.equals(c)) {
            return b;
        } else {
            return a;
        }
    }

    public static String replaceNthChar(String text, int n, char replaceChar) {
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            if (i % n == 0 && !(i == 0 && n > 0)) {
                res += replaceChar;
            } else {
                res += text.charAt(i);
            }
        }
        return res;
    }

    public static void printPattern(int n, char character) {
        for (int i = 0; i < n; i++) {
            printRow(i, ' ');
            printRow(n + i, character);
            System.out.print("\n");
        }
    }

    public static void printRow(int n, char character) {
        if (n != 0) {
            System.out.print(character);
            printRow(n - 1, character);
        }
    }

    public static int[][] labelPath(int n, int[][] points) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j] = n;
            }
        }
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (ret[x] != null && ret[x] != null) {
                ret[x][y] = -1;
            }
        }

        return ret;
    }

    public static void findMatches(int[][] data, int[] pattern, int[] target) {
        for (int i = 0; i < data.length; i++) {
            target[i] = patternInArray(data[i], pattern);
        }
        System.out.println(Arrays.toString(target));
    }

    public static int patternInArray(int[] data, int[] pattern) {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            boolean patternActive = true;
            for (int j = 0; j < pattern.length; j++) {
                if (!(data.length > i + j && data[i + j] == pattern[j])) {
                    patternActive = false;
                    break;
                }
            }
            if (patternActive) {
                counter++;
            }
        }
        return counter;
    }

    public static String insertMiddle(String input, String seps) {
        if (input.length() <= 1 || seps.length() == 0) {
            return input;
        }
        int half = input.length() / 2;
        String leftHalf = input.substring(0, half);
        String rightHalf = input.substring(half);
        String remaining;
        if (seps.length() == 1) {
            remaining = "";
        } else {
            remaining = seps.substring(1);
        }
        return insertMiddle(leftHalf, remaining) + seps.charAt(0) + insertMiddle(rightHalf, remaining);
    }

    public static int fibo(int a) {
        if (a == 1) {
            return 1;
        } else if (a < 1) {
            return 0;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}