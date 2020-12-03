import java.io.*;
import java.util.*;

public class InterviewPreparationKit_Graphs_RoadsAndLibraries {
    public static class DisjointSet{
        private int[] parent;
        private int[] rank;
        private int sets;
        public DisjointSet(int n){
            sets = n;
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        
        public int find(int i){
            if(parent[i]!=i){
                parent[i] = find(parent[i]);        
            }
            return parent[i];
        }
        
        public void union(int i, int j){
            int irep = find(i);
            int jrep = find(j);
            
            if(irep!=jrep){
                sets--;
                int irank = rank[i];
                int jrank = rank[j];
                
                if(irank<jrank){
                    parent[irep] = jrep;
                }else if(jrank<irank){
                    parent[jrep] = irep;
                }else{
                    parent[irep] = jrep;
                    rank[jrep]++;
                }
            }
        }
        
        public int getSets(){
            return sets;
        }        
    }
    
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_lib<=c_road){
            return (long)c_lib*n;
        }else{
            DisjointSet ds = new DisjointSet(n);
            for(int i=0;i<cities.length;i++){
                int u = cities[i][0]-1;
                int v = cities[i][1]-1;
                ds.union(u,v);
            }
            int sets = ds.getSets();
            return (long)sets*c_lib+(long)(n-sets)*c_road;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
