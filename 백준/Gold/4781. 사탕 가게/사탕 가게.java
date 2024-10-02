import java.util.*;
import java.io.*;

public class Main {
    public static int[] visited;
    public static int[] idx;
    public static int max =0;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            double m = sc.nextDouble();
            if (n == 0 && m == 0.0) break;

            int im = (int) Math.round(m * 100);
            int[] dp = new int[im + 1];
            for (int i = 1; i <= n; i++) {
                int nowCal = sc.nextInt();
                double mm = sc.nextDouble();
                int nowM = (int) Math.round(mm * 100);

                for (int j = nowM; j <= im; j++) {
                    dp[j] = Math.max(dp[j], dp[j - nowM] + nowCal);
                }
            }
            System.out.println(dp[im]);
        }
    }
}
