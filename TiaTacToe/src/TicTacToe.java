import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    static int m, n;
    static int[][] a = new int[4][4];
    static String[] board = new String[10];
    static Scanner obj = new Scanner(System.in);
    static int count = 1;
    static String human;
    static String ai;
    static int numHuman;
    static int numai;
    static int turn;
    static int r;
    static boolean flag = true;
    static int p;
    static String playerName;
    static int t;

    static int o_checkTotal() {
        if (human.equals(String.valueOf('x')))
            return 18;
        else if (human.equals(String.valueOf('o')))
            return 50;
        return 0;
    }

    static int checkTotal() {
        if (ai.equals(String.valueOf('x')))
            return 18;
        else if (ai.equals(String.valueOf('o')))
            return 50;
        return 0;

    }

    static String pickAlpha() {
        System.out.println("Select the number -->");
        System.out.println("1. X");
        System.out.println("2. o");
        int n = obj.nextInt();
        obj.nextLine();
        if (n == 1) {
            System.out.println("\nHuman -> x");
            System.out.println("AI -> o\n");
            human = String.valueOf('x');
            numHuman = 3;

            ai = String.valueOf('o');
            numai = 5;

        } else {
            System.out.println("\nAI -> x");
            System.out.println("Human -> o\n");
            human = String.valueOf('o');
            ai = String.valueOf('x');
            numHuman = 5;
            numai = 3;
        }
        return null;
    }

    static void breakloop() {

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (a[i][j] == 2) {
                    ai_Go(i, j, numai);
                    printBoard();
                    return;
                }
            }
        }

    }

    static int posswin(int n) {
        int[] ans1 = new int[7];
        ans1[0] = 1;
        ans1[1] = 1;
        ans1[2] = 1;
        ans1[3] = 1;
        ans1[4] = 1;
        ans1[5] = 1;
        ans1[6] = 1;
        switch (n) {

            case 1:

            case 4:

            case 7: {
                for (int i = 1; i <= 3; i++) {

                    ans1[0] = ans1[0] * a[i][1];//vertical
                }
                return ans1[0];
            }

            case 2:
            case 3: {
                for (int i = 1; i <= 3; i++) {

                    ans1[1] = ans1[1] * a[1][i];//horizontal
                }
                return ans1[1];
            }

            case 5:
            case 9: {
                for (int i = 1; i < 3; i++) {

                    for (int j = 1; j < 3; j++) {//diagonal
                        if (i == j)
                            ans1[2] = ans1[2] * a[i][j];
                    }
                }
                return ans1[2];
            }

            case 6: {
                for (int i = 1; i <= 3; i++) {

                    ans1[3] = ans1[3] * a[2][i];//horizontal
                }
                return ans1[3];
            }


            case 8: {
                for (int i = 1; i <= 3; i++) {

                    ans1[4] = ans1[4] * a[i][2];//vertical
                }
                return ans1[4];
            }

            case 10: {
                for (int i = 1; i <= 3; i++) {

                    ans1[5] = ans1[5] * a[i][3];//vertical
                }
                return ans1[5];
            }
            case 11: {
                for (int i = 1; i <= 3; i++) {

                    ans1[6] = ans1[6] * a[3][i];//horizontal
                }
                return ans1[6];
            }
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }

    }

    static void boardPos() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                a[i][j] = 2;
            }
        }
    }

    static void firstMove() {
        Random ran = new Random();
        r = ran.nextInt(2) + 1;

        if (r == 1) {
            System.out.print("\n------->First move will be made by you<-------\n");
        } else {
            if (r == 2) {
                System.out.print("\n------->First move will be done by AI<-------\n");
            }

        }
    }

    static void printBoard() {
        int i, j, x, y;
        System.out.println();
        for (i = 1; i <= 3; i++) {
            System.out.println("    --------------------");
            for (j = 1; j <= 3; j++) {


            }
            System.out.print("\t");
            t = i;
            if (t > 0) {
                for (x = 1; x <= 3; x++) {
                    if (a[t][x] == 2) System.out.print("null" + " | ");
                    if (a[t][x] == 3) System.out.print("   x" + " | ");
                    if (a[t][x] == 5) System.out.print("   o" + " | ");
                }
                System.out.println();
            }

        }

        System.out.println();
    }

    static void humanMove() {
        int i, j;
        boolean inputisValid = true;
        List<Integer> ele = new ArrayList<>();

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                if (a[i][j] == 2) {
                    int c = getposVal(i, j);
                    ele.add(c);
                }

            }
        }
        System.out.println("Available positions ->" + ele);
        System.out.println("Enter one of the position from above numbers");
        int elepos;
        while (inputisValid) {
            elepos = obj.nextInt();
            if (ele.contains(elepos)) {
                if (elepos == 1) {

                    ai_Go(1, 1, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 2) {
                    ai_Go(1, 2, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 3) {
                    ai_Go(1, 3, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 4) {
                    ai_Go(2, 1, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 5) {
                    ai_Go(2, 2, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 6) {
                    ai_Go(2, 3, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 7) {
                    ai_Go(3, 1, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 8) {
                    ai_Go(3, 2, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                } else if (elepos == 9) {
                    ai_Go(3, 3, boardNum(human));
                    printBoard();
                    checkwin();
                    inputisValid = false;
                }

            } else System.out.println("Invalid input...Enter it again");
        }


    }

    static void oddMove() {
        switch (count) {
            case 1:
                if (a[1][1] == 2) {
                    ai_Go(1, 1, numai);
                    printBoard();
                }
                break;
            case 3:
                if (a[3][3] == 2) {
                    ai_Go(3, 3, numai);
                    printBoard();
                } else if (a[1][3] == 2) {
                    ai_Go(1, 3, numai);
                    printBoard();
                }
                break;

            case 5:
                if (a[1][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);
                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }


                }

                if (a[1][2] == numai) {

                    int h = posswin(2);
                    int v = posswin(8);
                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][3] == numai) {

                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal13(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][1] == numai) {

                    int v = posswin(7);
                    int h = posswin(6);
                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(6);
                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(6);
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal31();
                        checkwin();
                        return;
                    }
                }

                if (a[3][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(11);
                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                }
                if (a[3][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][1] == numHuman) {

                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);
                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }

                if (a[1][2] == numHuman) {

                    int h = posswin(2);
                    int v = posswin(8);


                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                }

                if (a[1][3] == numHuman) {

                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }

                if (a[2][1] == numHuman) {

                    int v = posswin(7);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }

                if (a[2][2] == numHuman) {

                    int v = posswin(8);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    } else if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }

                if (a[2][3] == numHuman) {

                    int v = posswin(10);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }

                if (a[3][1] == numHuman) {

                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }

                if (a[3][2] == numHuman) {

                    int v = posswin(8);
                    int h = posswin(11);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                }

                if (a[3][3] == numHuman) {

                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                } else if (a[3][1] == 2) {
                    ai_Go(3, 1, numai);
                    printBoard();
                } else if (a[1][3] == 2) {
                    ai_Go(1, 3, numai);
                    printBoard();
                }
                break;
            case 7:
            case 9:
                if (a[1][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);
                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }


                }

                if (a[1][2] == numai) {

                    int h = posswin(2);
                    int v = posswin(8);
                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][3] == numai) {

                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal13(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][1] == numai) {

                    int v = posswin(7);
                    int h = posswin(6);
                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(6);
                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(6);
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal31();
                        checkwin();
                        return;
                    }
                }

                if (a[3][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(11);
                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                }
                if (a[3][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][1] == numHuman) {

                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);
                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }

                if (a[1][2] == numHuman) {

                    int h = posswin(2);
                    int v = posswin(8);


                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                }

                if (a[1][3] == numHuman) {

                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }

                if (a[2][1] == numHuman) {

                    int v = posswin(7);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }

                if (a[2][2] == numHuman) {

                    int v = posswin(8);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    } else if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }

                if (a[2][3] == numHuman) {

                    int v = posswin(10);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }

                if (a[3][1] == numHuman) {

                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }

                if (a[3][2] == numHuman) {

                    int v = posswin(8);
                    int h = posswin(11);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                }

                if (a[3][3] == numHuman) {

                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                } else {
                    breakloop();
                }
        }
    }

    static void checkVertical(int j, int insert, int check) {
        for (int i = 1; i <= 3; i++) {
            if (a[i][j] != check) {
                m = i;
                n = j;
            }
        }
        ai_Go(m, n, insert);
        printBoard();
    }

    static void checkHorizontal(int j, int insert, int check) {
        for (int i = 1; i <= 3; i++) {
            if (a[j][i] != check) {
                m = j;
                n = i;
            }
        }
        ai_Go(m, n, insert);
        printBoard();
    }

    static void e_checkDiagonal11(int insert, int check) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (a[i] == a[j] & a[i][j] != check) {
                    m = i;
                    n = j;
                }
            }
        }
        ai_Go(m, n, insert);
        printBoard();
    }

    static void e_checkDiagonal13(int insert, int check) {
        if (a[1][3] != check) {
            ai_Go(1, 3, insert);
            printBoard();
        }
        if (a[2][2] != check) {
            ai_Go(2, 2, insert);
            printBoard();
        }
        if (a[3][1] != check) {
            ai_Go(3, 1, insert);
            printBoard();
        }
    }

    static void e_checkDiagonal31() {
        if (a[3][1] != numHuman) {
            ai_Go(3, 1, numai);
        }
        if (a[2][2] != numHuman) {
            ai_Go(2, 2, numai);
        }
        if (a[1][3] != numHuman) {
            ai_Go(1, 3, numai);
        }
        printBoard();
    }

    static void evenMove() {

        switch (count) {
            case 2:
                if (a[2][2] == 2) {

                    ai_Go(2, 2, numai);
                    printBoard();
                } else if (a[1][1] == 2) {

                    ai_Go(1, 1, numai);
                    printBoard();
                }
                break;
            case 4:
                if (a[1][1] == numHuman) {
                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);
                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }
                if (a[1][2] == numHuman) {
                    int h = posswin(2);
                    int v = posswin(8);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                }
                if (a[1][3] == numHuman) {
                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }
                if (a[2][1] == numHuman) {
                    int v = posswin(7);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[2][2] == numHuman) {
                    int v = posswin(8);
                    int h = posswin(6);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[2][3] == numHuman) {
                    int v = posswin(10);

                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[3][1] == numHuman) {
                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal31();
                        return;
                    }
                }
                if (a[3][2] == numHuman) {
                    int v = posswin(8);
                    int h = posswin(11);
                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                }
                if (a[3][3] == numHuman) {
                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                } else {
                    make2(numai);
                    printBoard();
                }
                break;


            case 6:
                if (a[1][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][2] == numai) {

                    int h = posswin(2);
                    int v = posswin(8);


                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][3] == numai) {


                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];


                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal13(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][1] == numai) {

                    int v = posswin(7);
                    int h = posswin(6);


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(6);


                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    } else if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(6);


                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(11);

                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal13(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(11);


                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);


                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }
                } else if (a[1][1] == numHuman) {
                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);

                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }
                if (a[1][2] == numHuman) {
                    int h = posswin(2);
                    int v = posswin(8);

                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                }
                if (a[1][3] == numHuman) {
                    int h = posswin(2);
                    int v = posswin(10);

                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }
                if (a[2][1] == numHuman) {
                    int v = posswin(7);
                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[2][2] == numHuman) {
                    int v = posswin(8);
                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[2][3] == numHuman) {
                    int v = posswin(10);
                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[3][1] == numHuman) {
                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal31();
                        return;
                    }
                }
                if (a[3][2] == numHuman) {
                    int v = posswin(8);
                    int h = posswin(11);

                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                }
                if (a[3][3] == numHuman) {
                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);

                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }

                make2(numai);
                printBoard();


            case 8:
                if (a[1][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][2] == numai) {

                    int h = posswin(2);
                    int v = posswin(8);


                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[1][3] == numai) {


                    int h = posswin(2);
                    int v = posswin(10);
                    int d = a[1][3] * a[2][2] * a[3][1];


                    if (h == checkTotal()) {
                        checkHorizontal(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal13(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][1] == numai) {

                    int v = posswin(7);
                    int h = posswin(6);


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(6);


                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    } else if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[2][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(6);


                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(2, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][1] == numai) {

                    int v = posswin(1);
                    int h = posswin(11);

                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == checkTotal()) {
                        checkVertical(1, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal13(numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][2] == numai) {

                    int v = posswin(8);
                    int h = posswin(11);


                    if (v == checkTotal()) {
                        checkVertical(2, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                }

                if (a[3][3] == numai) {

                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);


                    if (v == checkTotal()) {
                        checkVertical(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (h == checkTotal()) {
                        checkHorizontal(3, numai, numai);
                        checkwin();
                        return;
                    }
                    if (d == checkTotal()) {
                        e_checkDiagonal11(numai, numai);
                        checkwin();
                        return;
                    }
                } else if (a[1][1] == numHuman) {
                    int v = posswin(1);
                    int h = posswin(2);
                    int d = posswin(5);

                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }
                if (a[1][2] == numHuman) {
                    int h = posswin(2);
                    int v = posswin(8);

                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                }
                if (a[1][3] == numHuman) {
                    int h = posswin(2);
                    int v = posswin(10);

                    int d = a[1][3] * a[2][2] * a[3][1];
                    if (h == o_checkTotal()) {
                        checkHorizontal(1, numai, numHuman);
                        return;
                    }
                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal13(numai, numHuman);
                        return;
                    }
                }
                if (a[2][1] == numHuman) {
                    int v = posswin(7);
                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[2][2] == numHuman) {
                    int v = posswin(8);
                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[2][3] == numHuman) {
                    int v = posswin(10);
                    int h = posswin(6);

                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(2, numai, numHuman);
                        return;
                    }
                }
                if (a[3][1] == numHuman) {
                    int v = posswin(1);
                    int h = posswin(11);
                    int d = a[3][1] * a[2][2] * a[1][3];


                    if (v == o_checkTotal()) {
                        checkVertical(1, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal31();
                        return;
                    }
                }
                if (a[3][2] == numHuman) {
                    int v = posswin(8);
                    int h = posswin(11);

                    if (v == o_checkTotal()) {
                        checkVertical(2, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                }
                if (a[3][3] == numHuman) {
                    int v = posswin(10);
                    int h = posswin(11);
                    int d = posswin(5);

                    if (v == o_checkTotal()) {
                        checkVertical(3, numai, numHuman);
                        return;
                    }
                    if (h == o_checkTotal()) {
                        checkHorizontal(3, numai, numHuman);
                        return;
                    }
                    if (d == o_checkTotal()) {
                        e_checkDiagonal11(numai, numHuman);
                        return;
                    }
                }
                breakloop();

        }

    }

    static void ai_Go(int x, int y, int n) {
        a[x][y] = n;
    }


    static void turnoVal() {
        if (count % 2 != 0) {


            if (r == 1 & human.equals(String.valueOf('x'))) {


                humanMove();
                ++count;
            }
            if (r == 1 & human.equals(String.valueOf('o'))) {


                humanMove();
                ++count;
            }
            if (r == 2 & ai.equals(String.valueOf('x'))) {

                System.out.println("\n Move is done by AI...");
                oddMove();
                ++count;
            }
            if (r == 2 & ai.equals(String.valueOf('o'))) {

                System.out.println("\n Move is done by AI...");
                oddMove();
                ++count;
            }

        }
    }

    static void turneVal() {
        if (count % 2 == 0) {


            if (r == 2 & human.equals(String.valueOf('x'))) {

                System.out.println("Its your turn ,select the number -> ");
                humanMove();
                ++count;
            }
            if (r == 2 & human.equals(String.valueOf('o'))) {


                humanMove();
                ++count;
            }
            if (r == 1 & ai.equals(String.valueOf('x'))) {

                System.out.println("\n Move is done by AI...");
                evenMove();
                ++count;
            }
            if (r == 1 & ai.equals(String.valueOf('o'))) {

                System.out.println("\n Move is done by AI...");
                evenMove();
                ++count;
            }

        }
    }

    static int boardNum(String n) {
        if (n.equals(String.valueOf('x'))) {
            return 3;
        }
        if (n.equals(String.valueOf('o'))) {
            return 5;
        }

        return 0;
    }

    static int getposVal(int a, int b) {
        if (a == 1 & b == 1) return 1;
        else if (a == 1 & b == 2) return 2;
        else if (a == 1 & b == 3) return 3;
        else if (a == 2 & b == 1) return 4;
        else if (a == 2 & b == 2) return 5;
        else if (a == 2 & b == 3) return 6;
        else if (a == 3 & b == 1) return 7;
        else if (a == 3 & b == 2) return 8;
        else if (a == 3 & b == 3) return 9;

        return a;
    }

    static void checkwin() {

        List<Integer> items = new ArrayList<Integer>();
        Integer obj1 = 27;
        Integer obj2 = 125;
        items.add(7);//0
        items.add(5);//1
        items.add(2);//2
        items.add(6);//3
        items.add(10);//4
        items.add(11);//5
        items.add(8);//6
        for (int i = 0; i < 7; i++) {
            int getEle = items.get(i);
            int num = posswin(getEle);
            int num1 = a[1][3] * a[2][2] * a[3][1];

            if (num == 27 | num1 == 27) {
                System.out.println("in 27");
                if (ai.equals(String.valueOf('x')))
                    System.out.println("AI won the Game");
                else if (human.equals(String.valueOf('x')))
                    System.out.println(playerName + " has won the Game");
                System.exit(0);
            } else if (num == 125 | num1 == 125) {
                System.out.println("in 125");
                if (ai.equals(String.valueOf('o')))
                    System.out.println("AI won the Game");
                else if (human.equals(String.valueOf('o')))
                    System.out.println(playerName + " has won the Game");
                System.exit(0);
            }

        }


    }

    static void make2(int sym) {
        if (a[1][1] == 2) {
            a[1][1] = sym;
            return;
        } else {
            if (a[0][1] == 2) {
                a[0][1] = sym;
                return;
            } else if (a[1][2] == 2) {
                a[1][2] = sym;
                return;
            } else if (a[2][1] == 2) {
                a[2][1] = sym;
                return;
            } else if (a[1][0] == 2) {
                a[1][0] = sym;
                return;
            }
        }

    }

    public static void main(String arg[]) {
        System.out.println("Enter your name -->");
        playerName = obj.nextLine();
        int rep = 1;
        pickAlpha();
        boardPos();
        printBoard();
        firstMove();
        while (rep <= 8) {
            if (count % 2 != 0) {
                turnoVal();
                rep++;

            }
            if (count % 2 == 0) {
                turneVal();
                rep++;

            }

        }
        if (rep == 9) {
            turnoVal();
        }
        if (rep == 9) {
            System.out.println("Draw...");
            System.exit(0);
        }
    }

}

