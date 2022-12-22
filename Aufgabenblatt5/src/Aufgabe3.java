/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.attribute.UserPrincipalLookupService;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        int imgHeight = img.getHeight();
        int imgWidth = img.getWidth();
        int waldoHeight = template.getHeight();
        int waldoWidth = template.getWidth();

        int row = 0;
        int col = 0;
        long max = Long.MAX_VALUE;
        myDrawObj.setColor(Palette.DEEP_PINK);
        myDrawObj.setLineWidth(6);
        for (int i = 0; i < imgHeight; i++) {
            for (int j = 0; j < imgWidth; j++) {
                if (j + waldoWidth < imgWidth && i + waldoHeight < imgHeight) {
                    long temp = containsWaldo(img, template, i, j, max);
                    if (temp < max) {
                        row = i;
                        col = j;
                        max = temp;
                        myDrawObj.drawRectangle(col, row, waldoWidth, waldoHeight);
                        myDrawObj.show(300);
                    }
                }
            }
        }
        System.out.println(row + " " + col + " " + max);
    }

    private static long containsWaldo(Image img, Image waldo, int imgRow, int imgCol, long high) {
        long sum = 0;
        for (int i = 0; i < waldo.getHeight(); i++) {
            for (int j = 0; j < waldo.getWidth(); j++) {
                int temp = img.getPixel(j + imgCol, i + imgRow).getRGB() - waldo.getPixel(j, i).getRGB();
                sum += Math.abs(temp);
                 if (sum > high) {
                    return sum;
                }
            }
        }
        if (sum < 0) {
            System.out.println(sum);
        }
        return sum;
    }

    public static void main(String[] args) {

        //waldo1
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}





