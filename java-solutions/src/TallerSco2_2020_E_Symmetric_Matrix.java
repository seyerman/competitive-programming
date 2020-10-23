import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CodeForces - 1426B
public class TallerSco2_2020_E_Symmetric_Matrix {
	public static BufferedReader br;
	public static BufferedWriter bw;

	public static void solve() throws IOException{
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		if(m%2==1) {
			bw.write("NO\n");
			for (int i = 0; i < n*2; i++) {
				br.readLine();
			}
		}else {
			String answer = "NO\n";
			for (int i = 0; i < n; i++) {
				parts = br.readLine().split(" ");
				int ur = Integer.parseInt(parts[1]);
				parts = br.readLine().split(" ");
				int bl = Integer.parseInt(parts[0]);
				if(ur==bl) {
					answer = "YES\n";
				}
			}
			bw.write(answer);			
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int t = Integer.parseInt(line);
		
		while(t>0){
			
			solve();
			
			t--;
		}
		
		bw.close();
		br.close();
	}

}
