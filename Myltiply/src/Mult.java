import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Умножение двух больших чисел
 */
class Mult {
    long multiply (long a, long b){
        if (b == 0) return 0;
        long z = multiply(a, b >>> 1);
        if ((b & 1) == 0) {
            return z << 1;
        } else return a + (z << 1);
    }

    void run() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println(multiply(sc.nextLong(),sc.nextLong()));
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("===================== Start =====================");
        long startTime = System.currentTimeMillis();
        new Mult().run();
        System.out.println("===================== Stop =====================");
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
