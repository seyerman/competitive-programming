import java.io.*;
import java.util.*;

public class InterviewPreparationKit_Arrays_MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        boolean[] checked = new boolean[arr.length];
        int swaps = 0;
        for(int i=0;i<arr.length;i++){
            if(!checked[i]){
                if(arr[i]==i+1){
                    checked[i] = true;
                }else{
                    int current = arr[i];
                    checked[current-1] = true;
                    while(current!=i+1){
                        current = arr[current-1];
                        checked[current-1] = true;
                        swaps++;
                    }
                }
            }
        }
        return swaps;
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

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
