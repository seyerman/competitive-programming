import java.io.*;
import java.util.*;

public class InterviewPreparationKit_Graphs_FindTheNearestClone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        int minPath = -1;
        Set<Integer> vtx = new HashSet<>();
        for(int i=0;i<ids.length;i++){
            if(val==ids[i]){
                vtx.add(i);
            }
        }
        if(vtx.size()>1){
            minPath = Integer.MAX_VALUE;
            List[] graph = new List[graphNodes];
            for(int i=0;i<graph.length;i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0;i<graphFrom.length;i++){
                int u = graphFrom[i]-1;
                int v = graphTo[i]-1;
                graph[u].add(v);
                graph[v].add(u);
            }            
            
            for(int v:vtx){
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{v,0});
                boolean findFirst = false;
                boolean[] visited = new boolean[graphNodes];
                while(!q.isEmpty() && !findFirst){
                    int[] currentVertex = q.poll();
                    int cv = currentVertex[0];
                    int w = currentVertex[1];
                    visited[cv] = true;
                    for(int i=0;i<graph[cv].size() && !findFirst;i++){
                        int u = ((List<Integer>)graph[cv]).get(i);
                        if(!visited[u]){
                            if(ids[u]==val){
                                findFirst = true;
                                if(minPath>w+1){
                                    minPath = w+1;
                                }
                            }
                            //System.out.println("adding "+u+" with weight "+(w+1));
                            q.offer(new int[]{u,w+1});
                        }
                    }
                }
            }
        }
        return minPath;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
