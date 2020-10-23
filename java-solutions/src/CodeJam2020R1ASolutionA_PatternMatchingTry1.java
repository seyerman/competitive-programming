import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CodeJam2020R1ASolutionA_PatternMatchingTry1 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void solve() throws IOException{
		String line = br.readLine();
		byte N = Byte.parseByte(line);
		String[] strs = new String[N];
		String large = "";
		for (byte i = 0; i < N; i++) {
			strs[i] = br.readLine().substring(1);
			if(strs[i].length()>large.length()){
				large = strs[i];
			}
		}
		boolean possible = true;
		//bw.write("large: "+large+"\n");
		for (byte i = 0; i < strs.length && possible; i++) {
			String st1 = strs[i];
			String st2 = large.substring(large.length()-st1.length(), large.length());
			//bw.write(st1+" vs "+st2+"\n");
			if(!st1.equals(st2)){
				possible = false;
			}
		}
		
		if(possible){
			bw.write(large);
		}else{
			bw.write("*");
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
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
