import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class RPC_2020_11_F_Hopscotch_BruteForce_TLE {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static class Point{
		private int row;
		private int column;
		public Point(int r, int c) {
			row = r;
			column = c;
		}
		public int manhattanDistance(Point oPoint) {
			return Math.abs(oPoint.row - row)
					 + Math.abs(oPoint.column - column);			
		}
	}
	
	public static int shortestDistance(ArrayList<Point>[] tiles, Point prev, int i) {
		int dist = 0;
		if(i<tiles.length) {
			dist = Integer.MAX_VALUE;
			for (int j = 0; j < tiles[i].size(); j++) {
				int man = 0;
				if(prev!=null) {
					man = prev.manhattanDistance(tiles[i].get(j));
				}
				int currDist = man + shortestDistance(tiles, tiles[i].get(j), i+1);
				dist = Math.min(currDist, dist);
			}
		}
		return dist;
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
			bw.write(shortestDistance(tiles, null, 0)+"\n");
		}
		
		bw.close();
		br.close();
	}

}
