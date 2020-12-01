import java.io.*;
import java.util.*;

public class InterviewPreparationKit_WarmUpChallenges_RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int[] partialSum = new int[s.length()];
        if(s.charAt(0)=='a'){
            partialSum[0] = 1;
        }
        for(int i=1;i<s.length();i++){
            partialSum[i] = partialSum[i-1];
            if(s.charAt(i)=='a'){
                partialSum[i]++;
            }
        }
        long div = n/s.length();
        int rest = (int)(n%s.length());
        
        long howMany = div*partialSum[s.length()-1];
        
        if(rest>0){
            howMany += partialSum[rest-1];
        }
        return howMany;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
