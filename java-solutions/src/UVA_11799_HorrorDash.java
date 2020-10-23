import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UVA_11799_HorrorDash {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String[] speeds = br.readLine().split(" ");
		
		int max = 0;
		for (int i = 1; i < speeds.length; i++) {
			int spd = Integer.parseInt(speeds[i]);
			if(spd>max) {
				max = spd;
			}
		}
		bw.write(max+"\n");	
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int T = Integer.parseInt(line);
		
		int caseNumber = 1;
		while(T>0){
			
			bw.write("Case "+caseNumber+": ");
			
			solve();
			
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
