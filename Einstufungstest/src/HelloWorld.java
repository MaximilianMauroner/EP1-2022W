import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;

public class HelloWorld {
    public static int counter;

    public static void main(String[] args) {
        int t = 15;
        for (int i = 1; i <= t; i++) {
            prepareHanoi(i);
            counter = 0;
        }

    }

    public static void solveHanoi(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        counter++;
        if (n > 0) {
            solveHanoi(n - 1, a, c, b);
//            a to c
            c.push(a.pop());
            solveHanoi(n - 1, b, a, c);
        }
    }

    public static void prepareHanoi(int n) {
        LinkedList<Integer> a = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            a.push(i);
        }
        LinkedList<Integer> b = new LinkedList<Integer>();
        LinkedList<Integer> c = new LinkedList<Integer>();
//        System.out.println("A: " + a.toString());
//        System.out.println("B: " + b.toString());
//        System.out.println("C: " + c.toString());
        solveHanoi(n, a, b, c);
//        System.out.println("\n\n\nResult:");
//        System.out.println("A: " + a.toString());
//        System.out.println("B: " + b.toString());
//        System.out.println("C: " + c.toString());
        System.out.println("Counter for n: " + n + " -> " + counter);
    }


    public static boolean isPrime(BigInteger bigInteger) {
        for (BigInteger i = new BigInteger("2"); i.compareTo(bigInteger) < 0; i = i.add(new BigInteger("1"))) {
            if (bigInteger.mod(i).compareTo(new BigInteger("0")) == 0) {
                return false;
            }
        }
        return true;
    }
}
