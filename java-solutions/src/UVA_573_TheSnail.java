import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UVA_573_TheSnail {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] parts = br.readLine().split(" ");
		while(!parts[0].equals("0")){
			int H = Integer.parseInt(parts[0]);
			double U = Integer.parseInt(parts[1]);
			int D = Integer.parseInt(parts[2]);
			int F = Integer.parseInt(parts[3]);
			
			double distance = 0;
			int day = 0;
			double fatigue = (U*F)/100.0;
			//bw.write("fatigue "+fatigue+"\n");
			
			do{
				day++;
				if(U>0) {
					distance += U;
				}
				//bw.write("day "+day+" climb "+distance+"\n");
				if(distance<=H) {
					U -= fatigue;
					distance -= D;
					//bw.write("day "+day+" slides down to "+distance+"\n");
				}
			}while(distance<=H && distance>=0);
			
			if(distance>H) {
				bw.write("success on day "+day+"\n");
			}else {
				bw.write("failure on day "+day+"\n");
			}
			
			parts = br.readLine().split(" ");
		}
		
		bw.close();
		br.close();
	}

}
