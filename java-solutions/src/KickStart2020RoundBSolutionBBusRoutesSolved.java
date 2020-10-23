import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Bus Routes
public class KickStart2020RoundBSolutionBBusRoutesSolved {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		String[] parts = line.split(" ");
		short N = Short.parseShort(parts[0]);
		long D = Long.parseLong(parts[1]);
		
		line = br.readLine();
		parts = line.split(" ");
		
		long[] daysBuses = new long[N];
		for (int i = 0; i < N; i++) {
			daysBuses[i] = Long.parseLong(parts[i]);
		}
		
		for (int i = N-1; i >= 0; i--) {
			long X = daysBuses[i];
			long remainder = D%X;
			D = D - remainder;
		}
		bw.write(D+"");
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		byte caseNumber = 1;
		while(T>0){
			
			bw.write("Case #"+caseNumber+": ");
			
			solve();
			
			bw.write("\n");
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
