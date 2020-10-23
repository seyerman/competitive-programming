import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CodeForces20200408BKindAnton_Solved {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		short T = Short.parseShort(line);
		
		while(T>0){
			line = br.readLine();
			int n = Integer.parseInt(line);
			line = br.readLine();
			String[] parts1 = line.split(" ");
			line = br.readLine();
			String[] parts2 = line.split(" ");
			
			int[] a = new int[n];
			int[] b = new int[n];
			boolean possible = true;
			boolean[] vals = new boolean[3];
			for (int i = 0; i < n && possible; i++) {
				a[i] = Integer.parseInt(parts1[i]);
				b[i] = Integer.parseInt(parts2[i]);
				
				if(a[i]>b[i] && !vals[0]){
					possible = false;
				}else if(a[i]<b[i] && !vals[2]){
					possible = false;
				}
				vals[a[i]+1] = true;
			}
			
			if(possible){
				bw.write("YES\n");
			}else{
				bw.write("NO\n");
			}
			
			T--;
		}
		bw.close();
		br.close();
	}

}
