import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

class Items implements Comparable<Items>{
// Стоимость 0 <= ci <= 2*10^6
    double ci;
// Обьем 0 < wi <= 2*10^6
    double wi;
// Отношение c/w
    double cw;

    Items(double a, double b){
        this.ci = a;
        this.wi = b;
        this.cw = a/b;
    }

    @Override
    public int compareTo(Items o) {
        if (o.cw < this.cw) return -1;
        if (o.cw > this.cw) return 1;
        return 0;
    }

    @Override
    public String toString() {
        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        DecimalFormat df = new DecimalFormat("##0.000");
        df.setRoundingMode(RoundingMode.CEILING);
        return "Items{" +
                "ci=" + df.format(ci) +
                ", wi=" + df.format(wi) +
                ", cw=" + df.format(cw) +
                '}';
    }
}

public class Main {

    private static Items[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Количество предметов 1 <= n <= 10^3
        int number = sc.nextInt();
//        Вместимость 0 <= w <= 2*10^6
        double w = sc.nextDouble();
        cache = new Items[number];
        for (int i = 0; i < number; i++) {
            Items it = new Items(sc.nextDouble(),sc.nextDouble());
            cache[i] = it;
        }
        System.out.println("----------------------- Unsorted --------------------------");
        for (int i = 0; i < number; i++) {
            System.out.println(cache[i]);
        }

        Arrays.sort(cache);
        System.out.println("----------------------- Sorted --------------------------");
        for (int i = 0; i < number; i++) {
            System.out.println(cache[i]);
        }
        double cost = 0.000d;

            for (int i = 0; i < number; i++) {
                if (cache[i].ci !=0) {
//                    Если мешок больше товара
                    if (cache[i].wi < w) {
                        w = w - cache[i].wi;
                        cost = cost + cache[i].ci;
                    } else {
                        cost = cost + cache[i].ci * w / cache[i].wi;
                        break;
                    }
                }
            }

//        System.out.println("----------------------- Processed --------------------------");
        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        DecimalFormat df = new DecimalFormat("##0.000");
//        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(cost));
    }
}

