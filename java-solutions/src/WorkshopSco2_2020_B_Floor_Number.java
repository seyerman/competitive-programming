import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CodeForces - 1426A
public class WorkshopSco2_2020_B_Floor_Number {
	public static BufferedReader br;
	public static BufferedWriter bw;

	public static void solve() throws IOException{
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int x = Integer.parseInt(parts[1]);
		if(n<=2) {
			bw.write("1\n");
		}else {
			int floor = (int)Math.ceil((n-2)/(double)x)+1;
			bw.write(floor+"\n");
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
