import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//CF_1351_A
public class CF_1351_A {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		String[] parts = line.split(" ");
		Integer a = Integer.parseInt(parts[0]);
		Integer b = Integer.parseInt(parts[1]);
		Integer c = a+b;
		bw.write(""+c);
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
