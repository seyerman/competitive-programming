
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//JMR Template
public class FacebookHC2020R1SolutionA1_PerimetricChapter1v2 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		int modulo = 1000000007;
		//line 1
		String line = br.readLine();
		String[] parts = line.split(" ");
		int N = Integer.parseInt(parts[0]);
		int K = Integer.parseInt(parts[1]);
		byte W = Byte.parseByte(parts[2]);
		
		//line 2
		line = br.readLine();
		String[] partsL = line.split(" ");
		long[] L = new long[N];
		
		//line 3
		line = br.readLine();
		parts = line.split(" ");
		long AL = Integer.parseInt(parts[0]);
		long BL = Integer.parseInt(parts[1]);
		long CL = Integer.parseInt(parts[2]);
		long DL = Integer.parseInt(parts[3]);
		
		AL = AL%DL;
		
		//line 4
		line = br.readLine();
		String[] partsH = line.split(" ");
		long[] H = new long[N];
				
		//line 5
		line = br.readLine();
		parts = line.split(" ");
		long AH = Integer.parseInt(parts[0]);
		long BH = Integer.parseInt(parts[1]);
		long CH = Integer.parseInt(parts[2]);
		long DH = Integer.parseInt(parts[3]);
		
		AH = AH%DH;
		
		for (int i = 0; i < K; i++) {
			L[i] = Integer.parseInt(partsL[i]);
			H[i] = Integer.parseInt(partsH[i]);
		}
		
		for (int i = K; i < N; i++) {
			L[i] = ((((AL*L[i-2])%DL + (BL*L[i-1])%DL)%DL + CL) % DL) + 1;
			H[i] = ((((AH*H[i-2])%DH + (BH*H[i-1])%DH)%DH + CH) % DH) + 1;
		}
		
		long[] P = new long[N];
		P[0] = (H[0]+W)*2;
		
		long product = P[0];
		//bw.write("W:"+W+", H[0]:"+H[0]+", P[0]:"+P[0]+"\n");
		//bw.write("P = {[0]"+P[0]);
		long maxH = H[0];
		long perimAcum = 0;
		int lastInitialI = 0;
		for (int i = 1; i < N; i++) {

			if(L[i-1]+W<L[i]) {
				maxH = H[i];
				perimAcum = P[i-1];
				lastInitialI = i;
			}
			long widthCurrentP = L[i]+W-L[lastInitialI];
			
			if(H[i]>maxH) {
				maxH = H[i];
			}
			
			P[i] = perimAcum + 2*(widthCurrentP+maxH);
			
			P[i] = P[i] % modulo;
			
			//bw.write("Prem:"+Premove+", H["+i+"]:"+H[i]+", P["+i+"]:"+P[i]+"\n");
			//bw.write("P["+i+"]:"+P[i]+"\n");
			//bw.write(",["+i+"]"+P[i]);
			
			product = (product*P[i])%modulo;
		}
		//bw.write("}\n"+product+"");
		bw.write(product+"");
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new FileReader("data/travel_restrictions_validation_input.txt"));
		//br = new BufferedReader(new FileReader("data/travel_restrictions_input.txt"));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//bw = new BufferedWriter(new FileWriter("data/travel_restrictions_validation_output.txt"));
		//bw = new BufferedWriter(new FileWriter("data/travel_restrictions_output.txt"));
		
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
