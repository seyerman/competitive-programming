import java.io.*;
import java.util.*;

public class InterviewPreparationKit_DP_MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] mss = new int[arr.length];
        mss[0] = Math.max(arr[0],0);
        mss[1] = Math.max(mss[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            mss[i] = Math.max(mss[i-1],mss[i-2]+arr[i]);
        }
        return mss[arr.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
