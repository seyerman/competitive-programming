import java.io.*;
import java.util.*;

public class InterviewPreparationKit_Greedy_LuckBalance {
    
    public static class Contest implements Comparable<Contest>{
        public int l;
        public int t;
        public Contest(int l1, int t1){
            l = l1;
            t = t1;
        }
        public int compareTo(Contest c){
            return l-c.l;
        }
    }

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        ArrayList<Contest> cts = new ArrayList<>(contests.length);
        for(int i=0;i<contests.length;i++){
            cts.add(new Contest(contests[i][0],contests[i][1]));
        }
        Collections.sort(cts,Collections.reverseOrder());
        
        for(Contest c: cts){
            //System.out.println(c.l+" "+c.t+" "+k);
            if(c.t>0){
                if(k>0){
                    luck += c.l;
                    k--;
                }else{
                    luck -= c.l;
                }
            }else{
                luck += c.l;                
            }
        }
        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
