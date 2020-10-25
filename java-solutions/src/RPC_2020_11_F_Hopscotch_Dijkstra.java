import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

//basename: hopscotch
public class RPC_2020_11_F_Hopscotch_Dijkstra {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static class Point{
		private int row;
		private int column;
		public Point(int r, int c) {
			row = r;
			column = c;
		}
		public int getRow() {
			return row;
		}
		public int getColumn() {
			return column;
		}
		public int manDist(Point oPoint) {
			return Math.abs(oPoint.row - row)
					 + Math.abs(oPoint.column - column);			
		}
		public String toString() {
			return "("+row+","+column+")";
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		private int vertexNumber;
		private int distance;
		private Point vertexInfo;
		public Edge(int v, Point vi, int d) {
			vertexNumber = v;
			vertexInfo = vi;
			distance = d;
		}
		public int getVertexNumber() {
			return vertexNumber;
		}
		public int getDistance() {
			return distance;
		}
		public Point getVertexInfo() {
			return vertexInfo;
		}
		@Override
		public int compareTo(Edge anEd) {
			return distance-anEd.distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		
		@SuppressWarnings("unchecked")
		ArrayList<Point>[] tiles = new ArrayList[k];
		for (int i = 0; i < k; i++) {
			tiles[i] = new ArrayList<>();
		}
		
		HashMap<Integer, Boolean> possible = new HashMap<>();
		for (int i = 0; i < n; i++) {
			parts = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(parts[j])-1;
				tiles[x].add(new Point(i,j));
				possible.put(x, true);
			}
		}
		
		if(possible.size()<k) {
			bw.write("-1\n");
		}else {
			PriorityQueue<Edge> edges = new PriorityQueue<>();
			for (Point vertexInfo:tiles[0]) {
				edges.offer(new Edge(0,vertexInfo,0));
			}
			int[][][] dist = new int[k][n][n];
			//String[] path = new String[k];
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < n; j++) {
					for (int m = 0; m < n; m++) {
						dist[i][j][m] = Integer.MAX_VALUE;
						if(i==0) {
							dist[i][j][m] = 0;							
						}
					}
				}
			}
			//path[0] = "";
			//bw.write(Arrays.toString(dist)+"\n");
			int answer = 0;
			while(!edges.isEmpty()) {
				Edge ed = edges.poll();
				int u = ed.getVertexNumber();
				int d = ed.getDistance();
				if(u==k-1) {
					answer = d;
					break;
				}
				int rowU = ed.getVertexInfo().getRow();
				int columnU = ed.getVertexInfo().getColumn();
				if(d>dist[u][rowU][columnU]) continue;
				int v = u+1;
				if(v<k) {
					for (Point vertexV:tiles[v]) {
						int distUV = vertexV.manDist(ed.getVertexInfo());
						int rowV = vertexV.getRow();
						int columnV = vertexV.getColumn();
						if(dist[u][rowU][columnU] + distUV < dist[v][rowV][columnV]) {
							dist[v][rowV][columnV] = dist[u][rowU][columnU] + distUV;
							//path[u] = ed.getVertexInfo().toString();
							//path[v] = path[u]+vertexV.toString();
							//bw.write("("+(u+1)+","+(v+1)+"):"+Arrays.toString(dist)+":"+Arrays.toString(path)+"\n");
							edges.offer(new Edge(v, vertexV, dist[v][rowV][columnV]));
						}
					}
				}
			}
			bw.write(answer+"\n");
		}
		
		bw.close();
		br.close();
	}

}
