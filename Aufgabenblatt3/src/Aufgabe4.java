/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countNOrderedPairs(String text, int index) {
        if (index > -1) {
            text = text.substring(index);
            index = -1;
        }
        if (text.length() <= 1) {
            return Math.abs(index + 1);
        }
        if (text.charAt(0) <= text.charAt(1)) {
            index--;
        }
        return countNOrderedPairs(text.substring(1), index);
    }

    private static String shiftAllSignsRight(String text, char sign) {
        if (text.length() <= 1) {
            return text;
        }
        if (text.charAt(0) == sign) {
            text = text.substring(1) + sign + "";
        }
        return text.charAt(0) + shiftAllSignsRight(text.substring(1), sign);
    }

    public static void main(String[] args) {
        String text = "bhhebegcmoqast";
        System.out.println(countNOrderedPairs(text, 0));
        System.out.println(countNOrderedPairs(text, 2));
        System.out.println(countNOrderedPairs(text, 5));
        System.out.println(countNOrderedPairs(text, 6));
        System.out.println(countNOrderedPairs(text, 8));
        System.out.println();

        System.out.println(shiftAllSignsRight("az3kj", 'z'));
        System.out.println(shiftAllSignsRight("kjdn{nd8xngs+d#k", 'n'));
        System.out.println(shiftAllSignsRight("", 'e'));
        System.out.println(shiftAllSignsRight("4", '4'));
        System.out.println(shiftAllSignsRight("ji)o3ie6pk(2i", 'i'));
        System.out.println(shiftAllSignsRight("nothing", 'x'));

        assert (countNOrderedPairs(text, 0) == 9);
        assert (countNOrderedPairs(text, 2) == 7);
        assert (countNOrderedPairs(text, 5) == 6);
        assert (countNOrderedPairs(text, 6) == 5);
        assert (countNOrderedPairs(text, 8) == 4);

        assert (shiftAllSignsRight("az3kj", 'z').equals("a3kjz"));
        assert (shiftAllSignsRight("kjdn{nd8xngs+d#k", 'n').equals("kjd{d8xgs+d#knnn"));
        assert (shiftAllSignsRight("", 'e').equals(""));
        assert (shiftAllSignsRight("4", '4').equals("4"));
        assert (shiftAllSignsRight("ji)o3ie6pk(2i", 'i').equals("j)o3e6pk(2iii"));
        assert (shiftAllSignsRight("nothing", 'x').equals("nothing"));
    }
}
