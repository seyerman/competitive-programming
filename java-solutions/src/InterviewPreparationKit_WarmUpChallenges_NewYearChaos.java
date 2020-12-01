import java.util.*;

public class InterviewPreparationKit_WarmUpChallenges_NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        boolean possible = true;
        for(int i=0;i<q.length;i++){
            if(q[i]-i-1>2){
                possible = false;
            }
        }
        if(!possible){
            System.out.println("Too chaotic");
        }else{
            int moves = 0;
            boolean moved = true;
            while(moved){
                moved = false;
                for(int i=0;i<q.length-1;i++){
                    if(q[i]>q[i+1]){
                        int temp = q[i];
                        q[i] = q[i+1];
                        q[i+1] = temp;
                        moves++;
                        moved = true;
                    }
                }
            }
            System.out.println(moves);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
