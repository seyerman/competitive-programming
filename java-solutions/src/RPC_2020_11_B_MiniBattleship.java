import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//North America Championship 2020 (NAC 2020)
public class RPC_2020_11_B_MiniBattleship {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		
		char[][] grid = new char[n][n];
		
		int poss = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				grid[i][j] = line.charAt(j);
				if(grid[i][j]=='O'||grid[i][j]=='.') {
					poss++;
				}
			}
		}
		
		int[] shipSizes = new int[k];
		int posShips = 0;
		for (int i = 0; i < k; i++) {
			shipSizes[i] = Integer.parseInt(br.readLine());
			posShips+=shipSizes[i];
		}
		
		//bw.write(Arrays.deepToString(grid)+"\n");
		if(poss<posShips) {
			bw.write("0\n");
		}else {
			bw.write(countPossibilities(grid,shipSizes,0)+"\n");
		}
		
		
		bw.close();
		br.close();
	}

	private static long countPossibilities(char[][] grid, int[] shipSizes, int i) throws IOException {
		long possib = 0;
		if(i<shipSizes.length) {
			for (int j = 0; j < grid.length-shipSizes[i]+1; j++) {
				for (int m = 0; m < grid[0].length; m++) {
					char[][] grid1 = copy(grid);
					boolean possible1 = true;
					for (int k = 0; k < shipSizes[i] && possible1; k++) {
						int row = j+k;
						if(grid1[row][m]=='O' || grid1[row][m]=='.') {
							//grid1[row][m] = 'X';
							grid1[row][m] = (i+"").charAt(0);
						}else {
							possible1 = false;
						}
					}
					if(possible1) {
						//bw.write(i+" vertical possible "+shipSizes[i]+"\n");
						//bw.write(Arrays.deepToString(grid)+"\n");
						//bw.write(Arrays.deepToString(grid1)+"\n");
						possib += countPossibilities(grid1, shipSizes, i+1);
					}
				}
			}
			
			if(shipSizes[i]>1) {
				for (int j = 0; j < grid.length; j++) {
					for (int m = 0; m < grid[0].length-shipSizes[i]+1; m++) {
						char[][] grid2 = copy(grid);
						boolean possible2 = true;
						for (int k = 0; k < shipSizes[i] && possible2; k++) {
							int col = m+k;
							if(grid2[j][col]=='O' || grid2[j][col]=='.') {
								//grid2[j][col] = 'X';
								grid2[j][col] = (i+"").charAt(0);
							}else {
								possible2 = false;
							}
						}
						if(possible2) {
							//bw.write(i+" horizontal possible "+shipSizes[i]+"\n");
							//bw.write(Arrays.deepToString(grid)+"\n");
							//bw.write(Arrays.deepToString(grid2)+"\n");
							possib += countPossibilities(grid2, shipSizes, i+1);
						}
					}
				}
			}
		}else {
			boolean remainingO = false;
			for (int j = 0; j < grid.length; j++) {
				for (int m = 0; m < grid[0].length; m++) {
					if(grid[j][m]=='O') {
						remainingO = true;
					}
				}
			}
			if(!remainingO) {
				possib = 1;
			}
		}
		return possib;
	}

	private static char[][] copy(char[][] grid) {
		char[][] newGrid = new char[grid.length][grid[0].length];
		
		for (int i = 0; i < newGrid.length; i++) {
			for (int j = 0; j < newGrid[0].length; j++) {
				newGrid[i][j] = grid[i][j];
			}
		}
		
		return newGrid;
	}

}
