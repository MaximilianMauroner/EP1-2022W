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
            drawCirclePatternRecursively(myDrawObj, x + r, y - r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x + r, y + r, r / 2);
            myDrawObj.setColor(Color.orange);
            myDrawObj.fillCircle(x, y, r);
            myDrawObj.setColor(Color.red);
            myDrawObj.drawCircle(x, y, r);
        }
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
//        rad 128 = 1365    +1024
//        rad 64 = 341  +256
//        rad 32 = 85   +64
//        rad 16 = 21   +16
//        rad 8 = 5     +4
//        rad 4 = 1     +1
//        rad 2 = 0;

        int r = 4;
        int counter = (int) (Math.log(maxRadius) / Math.log(2)) - 2;

        int x = r * 2;
        int y = r * 2;
        int temp = 0;

        for (int i = 0; counter >= 0; i++) {
            myDrawObj.setColor(Color.orange);
            myDrawObj.fillCircle(x, y, r);
            myDrawObj.setColor(Color.red);
            myDrawObj.drawCircle(x, y, r);
            if (i - temp == Math.pow(4, counter)) {
                temp += Math.pow(4, counter);
                counter--;
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
        CodeDraw myDrawObjR = new CodeDraw(width, height);
        CodeDraw myDrawObj = new CodeDraw(width, height);
        drawCirclePatternRecursively(myDrawObjR, width / 2, height / 2, rad);
        drawCirclePatternIteratively(myDrawObj, rad);
        myDrawObjR.show();
        myDrawObj.show();
    }
}


