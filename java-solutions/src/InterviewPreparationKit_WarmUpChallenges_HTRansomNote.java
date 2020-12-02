import java.util.*;

public class InterviewPreparationKit_WarmUpChallenges_HTRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> mg = new HashMap<>();
        for(int i=0;i<magazine.length;i++){
            if(mg.containsKey(magazine[i])){
                mg.put(magazine[i],mg.get(magazine[i])+1);
            }else{
                mg.put(magazine[i],+1);
            }
        }
        boolean possible = true;
        for(int i=0;i<note.length && possible;i++){
            if(mg.containsKey(note[i]) && mg.get(note[i])>0){
                mg.put(note[i],mg.get(note[i])-1);
            }else{
                possible = false;
            }
        }
        if(possible){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
