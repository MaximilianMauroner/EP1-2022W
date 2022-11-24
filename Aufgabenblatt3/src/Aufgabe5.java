/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;

import java.awt.*;

public class Aufgabe5 {
    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        if (r > 2) {
            drawCirclePatternRecursively(myDrawObj, x - r, y - r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x - r, y + r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x + r, y - r, r / 2); // this line needs to be removed for picture b
            drawCirclePatternRecursively(myDrawObj, x + r, y + r, r / 2);
            myDrawObj.setColor(Color.orange);
            myDrawObj.fillCircle(x, y, r);
            myDrawObj.setColor(Color.red);
            myDrawObj.drawCircle(x, y, r);
        }
    }

    /**
     * Increasing amounts
     * rad 128 = 1365    +1024
     * rad 64 = 341  +256
     * rad 32 = 85   +64
     * rad 16 = 21   +16
     * rad 8 = 5     +4
     * rad 4 = 1     +1
     * rad 2 = 0;
     *
     * @param myDrawObj
     * @param maxRadius
     */
    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {

        int r = 4;
//        calculate the amount of radius duplications
        int increments = (int) (Math.log(maxRadius) / Math.log(2)) - 2;

        int x = r * 2;
        int y = r * 2;
        int counter = 0;

        for (int i = 0; increments >= 0; i++) {
            myDrawObj.setColor(Color.orange);
            myDrawObj.fillCircle(x, y, r);
            myDrawObj.setColor(Color.red);
            myDrawObj.drawCircle(x, y, r);
//            from increments count down so that for each power of 4 the radius changes, keeping track of the sum
            if (i - counter == Math.pow(4, increments)) {
                counter += Math.pow(4, increments);
                increments--;
                r *= 2;
                x = r * 2;
                y = r * 2;
                continue;
            }
            if (x + r * 4 >= myDrawObj.getWidth()) {
                x = r * 2;
                y += r * 4;
            } else {
                x += r * 4;
            }
        }
    }

    public static void main(String[] args) {
        int rad = 128;
        int width = 512;
        int height = 512;
        CodeDraw recursiveCodeDraw = new CodeDraw(width, height);
        CodeDraw iterativeCodeDraw = new CodeDraw(width, height);
        drawCirclePatternRecursively(recursiveCodeDraw, width / 2, height / 2, rad);
        drawCirclePatternIteratively(iterativeCodeDraw, rad);
        recursiveCodeDraw.show();
        iterativeCodeDraw.show();
    }
}


