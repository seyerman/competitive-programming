import java.io.*;
import java.util.*;

public class InterviewPreparationKit_WarmUpChallenges_2DArraysDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHG = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-2;i++){
            for(int j=0;j<arr[i].length-2;j++){
                int currentHG = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                              +             arr[i+1][j+1]
                              + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(currentHG>maxHG){
                    maxHG = currentHG;
                }
            }
        }
        return maxHG;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
