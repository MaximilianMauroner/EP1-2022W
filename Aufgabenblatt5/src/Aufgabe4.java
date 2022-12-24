import java.util.Arrays;

/*
    Aufgabe 4) Zweidimensionale Arrays und Rekursion - Labyrinth
*/
public class Aufgabe4 {

    public static void main(String[] args) {
        int mazeType = 1;
        int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //EAST,NORTH,WEST,SOUTH
//        int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //NORTH,WEST,SOUTH,EAST
//        int[][] direction = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//WEST,SOUTH,EAST,NORTH
//        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//SOUTH,EAST,NORTH,WEST

        char[][] myMaze = null;
        if (mazeType == 0) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * *********".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 1) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 2) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   *".toCharArray(),
                    "***** *   * * *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* *********   *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "E   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* *************".toCharArray(),
                    "* *      *    *".toCharArray(),
                    "*    *       S*".toCharArray(),
                    "***************".toCharArray()
            };
        }

        // Dieser Teil darf (muss aber nicht) verändert werden!!****************
        printMaze(myMaze);
        int[] startPoint = getStartPoint(myMaze);
        if (startPoint[0] == 0 && startPoint[1] == 0) {
            System.out.println("STARTPOINT MISSING!");
        } else {
            if (existsPathToExit(myMaze, startPoint[0], startPoint[1], direction)) {
                System.out.println("EXIT FOUND!");
            } else {
                System.out.println("EXIT NOT FOUND!");
            }
        }
        myMaze[startPoint[0]][startPoint[1]] = 'S';
        printMaze(myMaze);
        //**********************************************************************
    }

    private static int[] getStartPoint(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private static boolean existsPathToExit(char[][] maze, int row, int col, int[][] direction) {
        int tr = row;
        int tc = col;
        for (int i = 0; i < direction.length; i++) {
            row += direction[i][0];
            col += direction[i][1];
            if (row < maze.length && row >= 0 && col < maze[row].length && col >= 0) {
                if (maze[row][col] == ' ') {
                    maze[row][col] = 'V';
                    if (existsPathToExit(maze, row, col, direction)) {
                        maze[row][col] = 'U';
                        return true;
                    }
                } else if (maze[row][col] == 'E') {
                    return true;
                }
            }
            row = tr;
            col = tc;
        }
        return false;
    }

    private static void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

}


