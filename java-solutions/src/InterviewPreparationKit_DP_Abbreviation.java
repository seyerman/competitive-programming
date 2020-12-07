import java.io.*;
import java.util.*;

public class InterviewPreparationKit_DP_Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int[][] abb = new int[a.length()+1][b.length()+1];
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                char aa = a.charAt(i-1);
                char bb = b.charAt(j-1);
                char aU = Character.toUpperCase(aa);
                if(aa==bb){
                    //System.out.println("comparing basic a:"+aa+" vs b:"+bb);
                    abb[i][j] = abb[i-1][j-1]+1;
                }else if(aU==bb){
                    //System.out.println("comparing uppercase a:"+aa+" vs b:"+bb);
                    abb[i][j] = Math.max(abb[i-1][j-1]+1,abb[i-1][j]);
                }else if(aU==aa){
                    abb[i][j] = -1;
                    //System.out.println("penalizing ... a:"+aa+", b:"+bb);
                }else{
                    //System.out.println("passsing ... a:"+aa+", b:"+bb);
                    abb[i][j] = abb[i-1][j];
                }
            }
        }
        /*
        for(int i=0;i<a.length()+1;i++){
            for(int j=0;j<b.length()+1;j++){
                System.out.print(abb[i][j]+" ");
            }
            System.out.println();
        }*/
        //System.out.println(a+" "+b+" "+abb[a.length()][b.length()]);
        if(abb[a.length()][b.length()]==b.length()){
            return "YES";
        }else{
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
