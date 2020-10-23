import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Iterator;

public class CodeJam2020R1ASolutionB_PascalWalkTry2Solved {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		BitSet bs = BitSet.valueOf(new long[]{N});
		int R = bs.length();
		N = N - R;
		bs = BitSet.valueOf(new long[]{N});
		int r=1,k=1;
		Iterator<Integer> indexes = bs.stream().iterator();
		int inc = 0;
		while(indexes.hasNext()){
			int nr = indexes.next();
			while(r<=nr){
				bw.write(r+" "+k+"\n");
				r++;
				k+=inc;
				R--;
			}
			if(k==1){
				for (;k <= r; k++) {
					bw.write(r+" "+k+"\n");
				}
				k = r;
			}else{
				for (;k >= 1; k--) {
					bw.write(r+" "+k+"\n");
				}
				k = 1;
			}
			inc = 0;
			if(r==k) inc = 1;
			k+=inc;
			r++;
		}
		while(R>0){
			bw.write(r+" "+k+"\n");
			k+=inc;
			r++;
			R--;
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		int caseNumber = 1;
		while(T>0){
			
			bw.write("Case #"+caseNumber+":\n");
			
			solve();
			
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
