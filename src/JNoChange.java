import java.util.Scanner;

public class JNoChange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int t = 0; t < tests; t++) {
            int toPay = sc.nextInt();
            int coinCount = sc.nextInt();
            int[] coinVals = new int[coinCount];
            for (int x = 0; x < coinCount; x++) coinVals[x] = sc.nextInt();
            if (canMake(toPay, 0, Integer.MAX_VALUE, coinVals)) System.out.println("YES");
            else System.out.println("NO");
            if (t != tests - 1) System.out.println();
        }
        sc.close();
    }
    
    static boolean canMake(int toPay, int coinIndex, int maxCoinCount, int[] coinVals) {
        if (toPay == 0) return true;
        if (coinIndex >= coinVals.length) return false;
        for (int coinCount = 0; coinCount <= maxCoinCount && coinCount * coinVals[coinIndex] <= toPay; coinCount++) {
            if (canMake(toPay - coinCount * coinVals[coinIndex], coinIndex + 1, coinCount, coinVals)) return true;
        }
        return false;
    }
}