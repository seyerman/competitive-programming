import java.io.*;
import java.util.*;

public class InterviewPreparationKit_HashTables_TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int letters = (int)'z' - (int)'a' + 1;
        boolean[] charsInS1 = new boolean[letters];
        for(char c:s1.toCharArray()){
            charsInS1[(int)c-(int)'a'] = true;
        }
        String response = "NO";
        for(char c:s2.toCharArray()){
            if(charsInS1[(int)c-(int)'a']){
                response = "YES";
                break;
            }
        }
        return response;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

