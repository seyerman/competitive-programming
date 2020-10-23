import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class CF_988_B {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static class SubstringComparator implements Comparator<String>{
		private boolean substring;
		public SubstringComparator() {
			substring = true;
		}
		
		public boolean getSubString() {
			return substring;
		}
		
		@Override
		public int compare(String s1, String s2) {
			int comp = 0;
			//System.out.println("s1:"+s1+",s2:"+s2);
			if(s1.length()<s2.length()) {
				if(s2.indexOf(s1)!=-1) {
					comp = -1;
				}else {
					substring = false;
				}
			}else if(s2.length()<s1.length()) {
				if(s1.indexOf(s2)!=-1) {
					comp = 1;
				}else {
					substring = false;
				}
			}else {
				if(s1.compareTo(s2)==0) {
					comp = 0;
				}else {
					substring = false;
				}
			}
			return comp;
		}		
	}
	
	public static void solve() throws IOException{
		String line = br.readLine();
		int n = Integer.parseInt(line);
		
		String[] ss = new String[n];
		
		for (int i = 0; i < ss.length; i++) {
			ss[i] = br.readLine();
		}
		
		SubstringComparator sc = new SubstringComparator();
		Arrays.sort(ss,sc);
		
		if(sc.getSubString()) {
			bw.write("YES\n");
			for(String s:ss) {
				bw.write(s+"\n");
			}
		}else {
			bw.write("NO\n");
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		solve();
		
		bw.close();
		br.close();
	}

}
