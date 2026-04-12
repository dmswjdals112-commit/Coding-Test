import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] cards;
    static int maxSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        n = sc.nextInt();
        m = sc.nextInt();
        
        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        sumCard(0, 0, 0);
        
        System.out.println(maxSum);
    }

    static void sumCard(int index, int count, int sum) {
        if (count == 3) {
            if (sum <= m) {
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }
        if (index >= n || sum > m) {
            return;
        }

        sumCard(index + 1, count + 1, sum + cards[index]);
        sumCard(index + 1, count, sum);
    }
}
