/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;

import java.awt.*;

public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        return new int[row][col];
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        myDrawObj.setColor(Color.BLUE);
        myDrawObj.fillRectangle(0, 0, myDrawObj.getWidth(), myDrawObj.getHeight());
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (currentGameBoard[i][j] == 0) {
                    myDrawObj.setColor(Color.gray);
                } else if (currentGameBoard[i][j] == 1) {
                    myDrawObj.setColor(Color.red);
                } else {
                    myDrawObj.setColor(Color.yellow);
                }
                myDrawObj.fillCircle(j * oneSquareSize + oneSquareSize / 2, i * oneSquareSize + oneSquareSize / 2, oneSquareSize / 3);
            }
        }
        myDrawObj.show();
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (currentGameBoard[i][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        for (int i = currentGameBoard.length - 1; i >= 0; i--) {
            if (currentGameBoard[i][col] == 0) {
                currentGameBoard[i][col] = player;
                return;
            }
        }
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        if (existsStraightWinner(currentGameBoard, player)) {
            return true;
        }
        if (existsDiagonalWinner(currentGameBoard, player)) {
            return true;
        }
        return false;
    }

    private static boolean existsStraightWinner(int[][] currentGameBoard, int player) {
        for (int i = 0; i < currentGameBoard.length; i++) {
            int wins = 0;
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (currentGameBoard[i][j] == player) {
                    wins++;
                } else {
                    wins = 0;
                }
                if (wins == 4) {
                    return true;
                }
            }
        }
        for (int j = 0; j < currentGameBoard[0].length; j++) {
            int wins = 0;
            for (int i = 0; i < currentGameBoard.length; i++) {
                if (currentGameBoard[i][j] == player) {
                    wins++;
                } else {
                    wins = 0;
                }
                if (wins == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existsDiagonalWinner(int[][] currentGameBoard, int player) {
        //++
        for (int i = 0; i < currentGameBoard.length - 4; i++) {
            for (int j = 0; j < currentGameBoard[i].length - 4; j++) {
                if (player == currentGameBoard[i][j] && player == currentGameBoard[i + 1][j + 1]) {
                    System.out.println("+2");
                    if (player == currentGameBoard[i + 2][j + 2]) {
                        System.out.println("+3");
                        if (player == currentGameBoard[i + 3][j + 3]) {
                            System.out.println("+4");
                            return true;
                        }
                    }
                }
            }
        }
        //--
        for (int i = currentGameBoard.length - 1; i >= 4; i--) {
            for (int j = currentGameBoard[i].length - 1; j >= 4; j--) {
                if (player == currentGameBoard[i][j] && player == currentGameBoard[i - 1][j - 1]) {
                    if (player == currentGameBoard[i - 2][j - 2]) {
                        if (player == currentGameBoard[i - 3][j - 3]) {
                            return true;
                        }
                    }
                }
            }
        }
        //+-
        for (int i = 0; i < currentGameBoard.length - 4; i++) {
            for (int j = currentGameBoard[i].length - 1; j >= 4; j--) {
                if (player == currentGameBoard[i][j] && player == currentGameBoard[i + 1][j - 1]) {
                    if (player == currentGameBoard[i + 2][j - 2]) {
                        if (player == currentGameBoard[i + 3][j - 3]) {
                            return true;
                        }
                    }
                }
            }
        }
        //-+
        for (int i = currentGameBoard.length - 1; i >= 4; i--) {
            for (int j = 0; j < currentGameBoard[i].length - 4; j++) {
                if (player == currentGameBoard[i][j] && player == currentGameBoard[i - 1][j + 1]) {
                    if (player == currentGameBoard[i - 2][j + 2]) {
                        if (player == currentGameBoard[i - 3][j + 3]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void clearRow(int[][] myGameBoard, int colsGameBoard, int index) {
        for (int i = myGameBoard.length - 1; i > index; i--) {
            myGameBoard[i] = myGameBoard[i - 1];
        }
        myGameBoard[index] = new int[colsGameBoard];
    }

    public static void drawText(CodeDraw myDrawObj, String text, boolean isGreen) {
        Color tempCol = myDrawObj.getColor();
        TextFormat tf = new TextFormat();
        tf.setFontName("Arial");
        tf.setFontSize(28);
        tf.setTextOrigin(TextOrigin.CENTER);
        tf.setBold(true);
        myDrawObj.setTextFormat(tf);
        if (isGreen) {
            myDrawObj.setColor(Palette.GREEN);
        } else {
            myDrawObj.setColor(Palette.ORANGE);
        }
        myDrawObj.drawText(myDrawObj.getWidth() / 2, myDrawObj.getHeight() / 2, text);
        myDrawObj.show(1000);
    }


    public static void main(String[] args) {

        // canvas settings
        int rowsGameBoard = 6;
        int colsGameBoard = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

        // game play starts
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
        while (!myDrawObj.isClosed() && gameActive) {
            if (myEventSC.hasKeyPressEvent()) {
                if (myEventSC.nextKeyPressEvent().getChar() == 'q') {
                    gameActive = false;
                }
            } else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();
                int col = mouseX / oneSquareSize;
                if (isMovePossible(myGameBoard, col)) {
                    fieldsUsed++;
                    makeMove(myGameBoard, player, col);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    if (existsWinner(myGameBoard, player)) {
                        drawText(myDrawObj, "Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " won!", true);
                        myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                        drawText(myDrawObj, "Next Round", false);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    } else if (fieldsUsed == rowsGameBoard * colsGameBoard) {
                        drawText(myDrawObj, "Board Full", false);
                        for (int i = 0; i < rowsGameBoard; i++) {
                            clearRow(myGameBoard, colsGameBoard, i);
                            drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                            myDrawObj.show(500);
                        }
                        drawText(myDrawObj, "Try Again", false);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                        fieldsUsed = 0;
                    }
                    player = player == 1 ? 2 : 1;
                    System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
                } else {
                    drawText(myDrawObj, "Column already full!", false);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                }
            } else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }
}


