import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

//Expogo
public class Solution {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		String[] parts = line.split(" ");
		int X = Integer.parseInt(parts[0]);
		int Y = Integer.parseInt(parts[1]);
		
		//byte signX = (byte)(X/Math.abs(X));
		//byte signY = (byte)(Y/Math.abs(Y));
		
		X = Math.abs(X);
		Y = Math.abs(X);
		
		BitSet bsx = BitSet.valueOf(new long[] {X});
		BitSet bsy = BitSet.valueOf(new long[] {Y});
		
		byte cbx = (byte)bsx.nextSetBit(0);
		byte cby = (byte)bsy.nextSetBit(0);
		
		boolean changedX = false;
		boolean changedY = false;
		
		if(cbx==cby) {
			bw.write("IMPOSSIBLE");
		}else {
			if(bsy.get(cbx)) {
				bsy.flip(cby+1,bsy.length());
				changedY = true;
			}
			if(bsx.get(cby)) {
				bsx.flip(cbx+1,bsx.length());
				changedX = true;
			}
			BitSet bsxT = (BitSet)bsx.clone();
			bsxT.and(bsy);
			while (!bsxT.isEmpty() && !(changedX && changedY)){
				if(!changedX) {
					bsx.flip(cbx+1,bsx.length());
					changedX = true;					
				}else if(!changedY) {
					bsy.flip(cby+1,bsx.length());
					changedY = true;					
				}
				bsxT = (BitSet)bsx.clone();
				bsxT.and(bsy);
			}
			if(!bsxT.isEmpty()) {
				bw.write("IMPOSSIBLE");
			}else {
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		byte caseNumber = 1;
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
