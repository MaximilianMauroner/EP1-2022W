/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;

import java.awt.*;

public class Aufgabe5 {
    public static int c = 0;

    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        if (r > 2) {
            c++;
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
        int r = 2;
        int counter = (int) (Math.log(maxRadius) / Math.log(r));
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.pow(4, i));
        }
    }

    public static void main(String[] args) {
        int rad = 128;
        int width = 512;
        int height = 512;
        CodeDraw myDrawObjR = new CodeDraw(width, height);
        drawCirclePatternRecursively(myDrawObjR, width / 2, height / 2, rad);
//        drawCirclePatternIteratively(myDrawObjR, rad);
        myDrawObjR.show();
//        System.out.println(c);

    }
}


