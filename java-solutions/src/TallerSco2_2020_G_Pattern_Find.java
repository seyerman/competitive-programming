import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//SPOJ - NAJPF
public class TallerSco2_2020_G_Pattern_Find {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static int[] prefixFunction(String s) {
		int[] pi = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			int j = pi[i-1];
			while(j>0 && s.charAt(i)!=s.charAt(j)) {
				j = pi[j-1];
			}
			if(s.charAt(i)==s.charAt(j)) {
				j++;
			}
			pi[i] = j;
		}
		return pi;
	}
	
	public static void solve() throws IOException {
		String[] parts = br.readLine().split(" ");
		String S = parts[0];
		String pattern = parts[1];
		//bw.write(pattern+"#"+S+"\n");
		int[] pi = prefixFunction(pattern+"#"+S);
		//bw.write(Arrays.toString(pi)+"\n");

		int[] indexes = new int[S.length()];
		int sizeIndexes = 0;
		
		for (int i = pattern.length()+1; i < pattern.length()+S.length()+1; i++) {
			if(pi[i]==pattern.length()) {
				indexes[sizeIndexes] = i-pattern.length()-pi[i]+1;
				sizeIndexes++;
			}
		}
		if(sizeIndexes>0) {	
			bw.write(sizeIndexes+"\n");
			String sep = "";
			for (int i = 0; i < sizeIndexes; i++) {
				bw.write(sep+indexes[i]);
				sep = " ";
			}
		}else {
			bw.write("Not Found");
		}
		bw.write("\n");
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		String casesSep = "";
		while(T>0) {
			bw.write(casesSep);
			solve();			
			casesSep = "\n";
			T--;
		}
		
		bw.close();
		br.close();
	}

}
