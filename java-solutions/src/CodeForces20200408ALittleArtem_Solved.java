import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CodeForces20200408ALittleArtem_Solved {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		while(T>0){
			line = br.readLine();
			String[] parts = line.split(" ");
			byte n = Byte.parseByte(parts[0]);
			byte m = Byte.parseByte(parts[1]);
			
			bw.write("W");
			for (byte i = 1; i < m; i++) {
				bw.write("B");
			}
			bw.write("\n");
			for (byte i = 1; i < n; i++) {
				for (int j = 0; j < m; j++) {
					bw.write("B");					
				}
				bw.write("\n");					
			}
			
			T--;
		}
		bw.close();
		br.close();
	}

}
