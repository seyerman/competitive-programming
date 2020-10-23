import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Bike Tour
public class KickStart2020RoundBSolutionABikeTourSolved {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		byte N = Byte.parseByte(line);
		line = br.readLine();
		String[] parts = line.split(" ");
		byte[] heights = new byte[N];
		for (byte i = 0; i < N; i++) {
			heights[i] = Byte.parseByte(parts[i]);
		}
		
		byte peaks = 0;
		for(byte i=1;i<N-1;i++) {
			if(heights[i-1]<heights[i] && heights[i]>heights[i+1]) {
				peaks++;
			}
		}
		bw.write(peaks+"");
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
