import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UVA_10071_BackToHighSchoolPhysics {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(" ");
			int v = Integer.parseInt(parts[0]);
			int t = Integer.parseInt(parts[1]);
			
			bw.write((v*t*2)+"\n");
			
			line = br.readLine();
		}
		
		bw.close();
		br.close();
	}

}
