import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CF_721_B {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static class PasswordComparator implements Comparator<String>{
		private String correctPassword;
		private boolean priority;//true = min, false = max
		public PasswordComparator(String cp, boolean p) {
			correctPassword = cp;
			priority = p;
		}
		
		@Override
		public int compare(String s1, String s2) {
			int comp = s1.length()-s2.length();
			if(comp==0) {
				if(s1.equals(correctPassword)) {
					if(priority) {
						comp = -1;
					}else {
						comp = 1;
					}
				}
				if(s2.equals(correctPassword)) {
					if(priority) {
						comp = 1;
					}else {
						comp = -1;
					}
				}
			}
			return comp;
		}		
	}
	
	public static void solve() throws IOException{
		String line = br.readLine();
		String[] parts = line.split(" ");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		
		List<String> passwords = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
			passwords.add(br.readLine());
		}
		
		String correctP = br.readLine();
		
		PasswordComparator sc = new PasswordComparator(correctP,true);
		Collections.sort(passwords,sc);
		int min = passwords.indexOf(correctP);
		min += (min/k)*5 + 1;
		
		sc = new PasswordComparator(correctP,false);
		Collections.sort(passwords,sc);
		int max = passwords.indexOf(correctP);
		max += (max/k)*5 + 1;
		
		bw.write(min+" "+max);
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		solve();
		
		bw.close();
		br.close();
	}

}
