import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Wandering Robot
public class KickStart2020RoundBSolutionDTry1 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		String[] parts = line.split(" ");
		int W = Integer.parseInt(parts[0]);
		int H = Integer.parseInt(parts[1]);
		int L = Integer.parseInt(parts[2])-1;
		int U = Integer.parseInt(parts[3])-1;
		int R = Integer.parseInt(parts[4])-1;
		int D = Integer.parseInt(parts[5])-1;
		
		if(L==0&&U==0) {
			bw.write("0.0");
		}else {
			double[] arena = new double[H];
			arena[0] = 1;
			
			for (int i = 1; i < H; i++) {
				if(!(0>=L && 0<=R && i>=U && i<=D)) {
					arena[i] = arena[i-1]/2;
				}
			}
			
			for (int j = 1; j < W; j++) {
				for (int i = 0; i < H; i++) {
					if(j>=L && j<=R && i>=U && i<=D) {
						arena[i] = 0;
					}else {
						double newValue = 0;
						if(i>0) {
							if(j<W-1) {
								newValue += arena[i-1]/2;
							}else {
								newValue += arena[i-1];
							}
						}
						if(j>0) {
							if(i<H-1) {
								newValue += arena[i]/2;
							}else {
								newValue += arena[i];
							}
						}
						arena[i] = newValue;
					}
				}				
			}
			
			bw.write(arena[H-1]+"");
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
