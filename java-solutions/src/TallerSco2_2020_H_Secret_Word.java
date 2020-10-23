import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//UVA - 12467
public class TallerSco2_2020_H_Secret_Word {
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
		String S = br.readLine();
		StringBuilder Ssb = new StringBuilder(S);
		StringBuilder Srev = new StringBuilder(S); 
		Srev.reverse();
		Ssb.append("#");
		Ssb.append(Srev);
		//bw.write(Ssb.toString()+"\n");
		int[] pi = prefixFunction(Ssb.toString());
		int maxPref = 0;
		for (int i = S.length()+1; i < S.length()*2+1; i++) {
			if(pi[i]>pi[maxPref]) {
				maxPref = i;
			}
		}
		//bw.write(Arrays.toString(pi)+"\n");
		int large = pi[maxPref];
		//bw.write(maxPref+", "+large+"\n");
		maxPref = maxPref - S.length()-1;
		//bw.write(maxPref+"\n");
		maxPref = S.length() - maxPref-1;
		//bw.write(maxPref+"\n");
		//bw.flush();
		bw.write(S.substring(maxPref, maxPref+large));
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T>0) {
			solve();
			bw.write("\n");
			T--;
		}
		
		bw.close();
		br.close();
	}

}
