import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CF_1351_B
public class CF_1351_B {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		String[] parts = line.split(" ");
		byte d1 = Byte.parseByte(parts[0]);
		byte d2 = Byte.parseByte(parts[1]);
		line = br.readLine();
		parts = line.split(" ");
		byte d3 = Byte.parseByte(parts[0]);
		byte d4 = Byte.parseByte(parts[1]);
		
		boolean possible = false;
		if(d1==d4 && d2+d3==d1) {
			possible = true;
		}
		if(d2==d3 && d1+d4==d2) {
			possible = true;
		}
		if(d1==d3 && d2+d4==d1) {
			possible = true;
		}
		if(d2==d4 && d1+d3==d2) {
			possible = true;
		}
		
		if(possible) {
			bw.write("YES");
		}else {
			bw.write("NO");
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int T = Integer.parseInt(line);
		
		while(T>0){
			
			solve();
			
			bw.write("\n");
			T--;
		}
		
		bw.close();
		br.close();
	}

}
