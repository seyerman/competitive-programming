import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CodeForces20200408CEugeneAndAnArrayTry1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		line = br.readLine();
		String[] parts = line.split(" ");
		
		long[] sum = new long[parts.length+1];
		sum[1] = Integer.parseInt(parts[0]);
		long good = 0;
		int min = 0;
		if(sum[1]==0){
			min++;
		}else{
			good++;
		}
		//System.out.println("min:"+min+", good:"+good);
		for (int i = 1; i < parts.length; i++) {
			int curr = Integer.parseInt(parts[i]);
			sum[i+1] = sum[i] + curr;
			if(curr==0){
				min = i+1;
			}else{
				int goodtemp = 0;
				for (int j = min; j < i+1; j++) {
					if(sum[i+1]-sum[j]!=0){
						goodtemp++;
					}else{
						min = j+1;
						goodtemp = 0;
					}
				}
				good+=goodtemp;
			}
			//System.out.println("min:"+min+", good:"+good);
		}
		
		bw.write(good+"\n");

		bw.close();
		br.close();
	}

}
