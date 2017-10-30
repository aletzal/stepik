import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Двоичный поиск в массиве с половинным делением
 */

class BSort {
    int binsearch (int[] in, int target, int length) {
        int l = 0;
        int r = length - 1;
        while (l <= r) {
            int m =(l + r) / 2;
            if (in[m] == target) return m + 1;
            else if (in[m] > target) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    void run() throws FileNotFoundException {
//        Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);
        int[] in = new int[sc.nextInt()];
        for (int i = 0; i < in.length; i++) {
            in[i] = sc.nextInt();
        }
        int[] test = new int[sc.nextInt()];
        for (int i = 0; i < test.length; i++) {
            test[i] = sc.nextInt();
        }
        for (int i = 0; i < test.length; i++) {
            System.out.print(binsearch(in, test[i], in.length) + " ");
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
//        long startTime = System.currentTimeMillis();
        new BSort().run();
//        System.out.println();
//        System.out.println("====================================================");
//        System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
