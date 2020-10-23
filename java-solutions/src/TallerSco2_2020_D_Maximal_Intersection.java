import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CodeForces - 1029C
public class TallerSco2_2020_D_Maximal_Intersection {
	public static BufferedReader br;
	public static BufferedWriter bw;
		
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		int[] l = new int[n];
		int[] r = new int[n];
		
		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			l[i] = Integer.parseInt(parts[0]);
			r[i] = Integer.parseInt(parts[1]);
		}
		
		int[][] prefix = new int[n][2];
		prefix[0][0] = l[0];
		prefix[0][1] = r[0];		
		for (int i = 1; i < n; i++) {
			int maxL = Math.max(l[i],prefix[i-1][0]);
			int minR = Math.min(r[i],prefix[i-1][1]);
			prefix[i][0] = maxL;
			prefix[i][1] = minR;
		}
		
		//bw.write(Arrays.deepToString(prefix)+"\n");
		
		int[][] suffix = new int[n][2];
		suffix[n-1][0] = l[n-1];
		suffix[n-1][1] = r[n-1];
		for (int i = n-2; i >= 0; i--) {
			int maxL = Math.max(l[i],suffix[i+1][0]);
			int minR = Math.min(r[i],suffix[i+1][1]);
			suffix[i][0] = maxL;
			suffix[i][1] = minR;
		}
		
		//bw.write(Arrays.deepToString(suffix)+"\n");
		
		int max = suffix[1][1]-suffix[1][0];
		//bw.write("0:"+max+"\n");
		for (int i = 1; i < n-1; i++) {
			int lcurr = Math.max(prefix[i-1][0], suffix[i+1][0]);
			int rcurr = Math.min(prefix[i-1][1], suffix[i+1][1]);
			int maxCurr = rcurr - lcurr;
			if(maxCurr>max) {
				max = maxCurr;
			}
			//bw.write(i+":"+maxCurr+","+max+"\n");
		}
		
		int lastMax = prefix[n-2][1]-prefix[n-2][0];
		if(lastMax>max) {
			max = lastMax;
		}
		//bw.write((n-1)+":"+lastMax+","+max+"\n");
		
		if(max<0) max = 0;
		
		bw.write(max+"\n");
		
		bw.close();
		br.close();
	}

}
