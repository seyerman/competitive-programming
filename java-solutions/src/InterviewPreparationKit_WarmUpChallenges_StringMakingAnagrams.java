import java.io.*;
import java.util.*;

public class InterviewPreparationKit_WarmUpChallenges_StringMakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        
        Arrays.sort(aCharArray);
        Arrays.sort(bCharArray);
        
        int i = 0;
        int j = 0;
        int charsToDelete = 0;
        while(i<aCharArray.length && j<bCharArray.length){
            if(aCharArray[i]==bCharArray[j]){
                i++;
                j++;
            }else if(aCharArray[i]<bCharArray[j]){
                i++;
                charsToDelete++;
            }else{ //if(aCharArray[i]<bCharArray[j])
                j++;
                charsToDelete++;
            }
        }
        charsToDelete += aCharArray.length-i;
        charsToDelete += bCharArray.length-j;
        return charsToDelete;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
