import java.io.*;
import java.util.*;

public class InterviewPreparationKit_Search_SwapNodesAlgo {
    
    static int position;
    static void inOrderTraversal(int[][] indexes, int i, int[] traversal){
        i = i - 1;
        if(indexes[i][0]!=-1){
            inOrderTraversal(indexes,indexes[i][0],traversal);
        }
        traversal[position++] = i+1;
        if(indexes[i][1]!=-1){
            inOrderTraversal(indexes,indexes[i][1],traversal);
        }
    }
    
    static void swaping(int[][] indexes,int q,int i, int currentDeep){
        //System.out.println("q:"+q+", i:"+i+", cd:"+currentDeep);
        if(currentDeep%q==0){
            int temp = indexes[i-1][0];
            indexes[i-1][0] = indexes[i-1][1];
            indexes[i-1][1] = temp;            
        }
        if(indexes[i-1][0]!=-1){
            swaping(indexes,q,indexes[i-1][0],currentDeep+1);            
        }
        if(indexes[i-1][1]!=-1){
            swaping(indexes,q,indexes[i-1][1],currentDeep+1);
        }
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] output = new int[queries.length][indexes.length];
        int row = 0;
        //System.out.println(Arrays.deepToString(indexes));
        for(int q:queries){
            swaping(indexes,q,1,1);
            //System.out.println(Arrays.deepToString(indexes));
            position = 0;
            inOrderTraversal(indexes,1,output[row]);
            row++;
        }
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
