import java.io.*;
import java.util.*;

public class InterviewPreparationKit_WarmUpChallenges_SalesByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        boolean[] sockPile = new boolean[101];
        int pairs = 0;
        for(int i=0;i<n;i++){
            int color = ar[i];
            sockPile[color] = !sockPile[color];
            if(!sockPile[color]){
                pairs++;
            }
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
