import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CodeForces - 1029A
public class WorkshopSco2_2020_A_Many_Equal_Substrings {
	public static BufferedReader br;
	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		
		String t = br.readLine();
		
		int[] pi = new int[n];
		for (int i = 1; i < n; i++) {
			int j = pi[i-1];
			while(j>0 && t.charAt(i)!=t.charAt(j)) {
				j = pi[j-1];
			}
			if(t.charAt(i)==t.charAt(j)) {
				j++;
			}
			pi[i] = j;
		}
		
		String period = t.substring(0, n-pi[n-1]);
		
		for (int i = 0; i < k-1; i++) {
			bw.write(period);
		}
		bw.write(t);
		
		bw.close();
		br.close();
	}

}
