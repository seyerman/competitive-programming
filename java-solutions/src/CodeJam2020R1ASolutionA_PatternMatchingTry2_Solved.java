import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class CodeJam2020R1ASolutionA_PatternMatchingTry2_Solved {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void solve() throws IOException{
		String line = br.readLine();
		byte N = Byte.parseByte(line);
		ArrayList<String> prefix = new ArrayList<>();
		ArrayList<String> suffix = new ArrayList<>();
		String largePr = "";
		String largeSu = "";
		
		String solution = "";
		
		for (byte i = 0; i < N; i++) {
			line = br.readLine();
			
			int firstAst = line.indexOf('*');
			int lastAst = line.lastIndexOf('*');
			
			String pr = line.substring(0,firstAst);
			String su = line.substring(lastAst+1,line.length());
			
			if(!pr.equals("")){
				prefix.add(pr);
				if(pr.length()>largePr.length()){
					largePr = pr;
				}
			}
			
			if(!su.equals("")){
				suffix.add(su);
				if(su.length()>largeSu.length()){
					largeSu = su;
				}
			}
			
			String strAdd = line.substring(firstAst,lastAst);
			strAdd = strAdd.replaceAll("\\*", "");
			solution += strAdd;
		}
		
		boolean possible = true;
		for (byte i = 0; i < prefix.size() && possible; i++) {
			String st1 = prefix.get(i);
			String st2 = largePr.substring(0, st1.length());
			possible = st1.equals(st2);
		}

		for (byte i = 0; i < suffix.size() && possible; i++) {
			String st1 = suffix.get(i);
			String st2 = largeSu.substring(largeSu.length()-st1.length(), largeSu.length());
			possible = st1.equals(st2);
		}
		
		solution = largePr+solution+largeSu;
		
		if(possible && solution.length()<=10000){
			bw.write(solution);
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
