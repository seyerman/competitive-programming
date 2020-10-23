
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//JMR Template
public class FacebookHC2020QRSolutionB_Alchemy {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		int N = Integer.parseInt(line);
		String C = br.readLine();
		
		int A = 0;
		for (int i = 0; i < C.length(); i++) {
			if(C.charAt(i)=='A') {
				A++;
			}
		}
		if(A+A-1==N || A+A+1==N) {
			bw.write("Y");
		}else {
			bw.write("N");
		}
	}

	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new FileReader("data/alchemy_validation_input.txt"));
		br = new BufferedReader(new FileReader("data/alchemy_input.txt"));
		//bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//bw = new BufferedWriter(new FileWriter("data/alchemy_validation_output.txt"));
		bw = new BufferedWriter(new FileWriter("data/alchemy_output.txt"));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		int caseNumber = 1;
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
