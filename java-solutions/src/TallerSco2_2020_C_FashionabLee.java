import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CodeForces - 1369A
public class TallerSco2_2020_C_FashionabLee {
	public static BufferedReader br;
	public static BufferedWriter bw;

	public static void solve() throws IOException{
		int n = Integer.parseInt(br.readLine());
		if(n%4==0) {
			bw.write("YES\n");
		}else {
			bw.write("NO\n");			
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
