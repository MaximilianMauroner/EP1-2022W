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
     * radius 128 = 1365    +1024
     * radius 64 = 341  +256
     * radius 32 = 85   +64
     * radius 16 = 21   +16
     * radius 8 = 5     +4
     * radius 4 = 1     +1
     * radius 2 = 0;
     *
     * @param myDrawObj
     * @param maxRadius
     */
    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {

        int r = 4;
//        calculate the amount of radius duplications
        int increments = (int) (Math.log(maxRadius) / Math.log(2)) - 2;
        int width = myDrawObj.getWidth();
        int height = myDrawObj.getHeight();

        int countCirclesSingleBorder = (int) Math.sqrt(Math.pow(4, increments));
//        startpunkt durch Probieren gefunden
        int boxStart = countCirclesSingleBorder * r * 2 - (2 * r);
        int x = (width / 2) - boxStart;
        int y = (height / 2) - boxStart;

        int counter = 0;

        for (int i = 1; 0 <= increments; i++) {
            myDrawObj.setColor(Color.orange);
            myDrawObj.fillCircle(x, y, r);
            myDrawObj.setColor(Color.red);
            myDrawObj.drawCircle(x, y, r);
//            from increments count down so that for each power of 4 the radius changes, keeping track of the sum
            if (i - counter == Math.pow(4, increments)) {
                counter += Math.pow(4, increments);
                increments--;
                r *= 2;
                countCirclesSingleBorder = (int) Math.sqrt(Math.pow(4, increments));
                boxStart = boxStart - r;
                x = (width / 2) - boxStart;
                y = (height / 2) - boxStart;
                continue;
            }
//            get the amount of rows and then start with a new row
            if (i != 0 && i % Math.sqrt(Math.pow(4, increments)) == 0) {
                x = (width / 2) - boxStart;
                y += r * 4;
            } else {
                x += r * 4;
            }
        }
    }

    public static void main(String[] args) {
        int radius = 64;
        int width = 512;
        int height = 512;
        CodeDraw recursiveCodeDraw = new CodeDraw(width, height);
        CodeDraw iterativeCodeDraw = new CodeDraw(width, height);
        drawCirclePatternRecursively(recursiveCodeDraw, width / 2, height / 2, radius);
        drawCirclePatternIteratively(iterativeCodeDraw, radius);
        recursiveCodeDraw.setTitle("recursive");
        recursiveCodeDraw.show();
        iterativeCodeDraw.setTitle("iterartive");
        iterativeCodeDraw.show();
    }
}


