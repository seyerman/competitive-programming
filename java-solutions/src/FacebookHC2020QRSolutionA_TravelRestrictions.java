
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//JMR Template
public class FacebookHC2020QRSolutionA_TravelRestrictions {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		byte N = Byte.parseByte(line);
		String I = br.readLine();
		String O = br.readLine();
		
		byte[][] d = new byte[N][N];
		for (int i = 0; i < d.length-1; i++) {
			if(O.charAt(i)=='Y' && I.charAt(i+1)=='Y') {
				d[i][i+1] = 1;
			}
			if(O.charAt(i+1)=='Y' && I.charAt(i)=='Y') {
				d[i+1][i] = 1;
			}
			d[i][i] = 1;
		}
		d[d.length-1][d.length-1] = 1;
		
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				for (int k = 0; k < d.length; k++) {
					if(d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
					}
				}
			}
		}
		
		bw.write("\n");
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				char x = 'Y';
				if(d[i][j]==0) {
					x = 'N';
				}
				bw.write(x+"");
			}
			bw.write("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new FileReader("data/travel_restrictions_validation_input.txt"));
		br = new BufferedReader(new FileReader("data/travel_restrictions_input.txt"));
		//bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//bw = new BufferedWriter(new FileWriter("data/travel_restrictions_validation_output.txt"));
		bw = new BufferedWriter(new FileWriter("data/travel_restrictions_output.txt"));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		int caseNumber = 1;
		while(T>0){
			
			bw.write("Case #"+caseNumber+": ");
			
			solve();
			
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
