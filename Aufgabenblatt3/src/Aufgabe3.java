/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        if (start % 2 == 0) {
            System.out.println(start);
        }
        if (start <= end) {
            printEvenNumbersAscending(start + 1, end);
        }
    }

    private static void printOddNumbersDescending(int start, int end) {
        if (end % 2 != 0){
            System.out.println(end);
        }
        if (start <= end) {
            printOddNumbersDescending(start, end - 1);
        }
    }

    private static int sumSquaredDigits(int number) {
        if (Integer.toString(number).length() == 1) {
            int t = Integer.parseInt(Integer.toString(number).charAt(0) + "");
            return t * t;
        }
        String nr = Integer.toString(number);
        int half = nr.length() / 2;
        int left = Integer.parseInt(nr.substring(0, half));
        int right = Integer.parseInt(nr.substring(half));
        return sumSquaredDigits(left) + sumSquaredDigits(right);
    }

    private static String removeSpaces(String text) {
        if (text.length() == 1 && text.charAt(0) != ' ') {
            return text;
        } else if (text.length() > 1) {
            int half = text.length() / 2;
            String left = text.substring(0, half);
            String right = text.substring(half);
            return removeSpaces(left) + removeSpaces(right);
        }
        return "";
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

