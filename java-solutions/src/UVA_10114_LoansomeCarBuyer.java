import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UVA_10114_LoansomeCarBuyer {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(line.charAt(0)!='-'){
			//bw.write("line:"+line+"\n");
			bw.flush();
			String[] parts = line.split(" ");
			int duration = Integer.parseInt(parts[0]);
			double downP = Double.parseDouble(parts[1]);
			double loan = Double.parseDouble(parts[2]);
			int depRec = Integer.parseInt(parts[3]);
			
			double[] dep = new double[duration+1];
			double currDep = 0;
			int i = 0;
			for (int j = 0; i <= duration && j<depRec; i++,j++) {
				parts = br.readLine().split(" ");
				int month = Integer.parseInt(parts[0]);
				while(i<month) {
					dep[i] = currDep;
					i++;
				}
				currDep = Double.parseDouble(parts[1]);
				dep[i] = currDep;
			}
			
			while(i<=duration) {
				dep[i] = currDep;
				i++;
			}
			
			//bw.write(Arrays.toString(dep)+"\n");
			
			double currentCost = (downP + loan)*(1-dep[0]);
			double monthPayment = loan/duration;
			
			//bw.write(currentCost+", "+loan+"\n");
			
			int currentMonth;
			for (currentMonth = 0; currentMonth < duration && currentCost<loan; currentMonth++) {
				loan -= monthPayment;
				currentCost = currentCost*(1-dep[currentMonth+1]);
				//bw.write(currentCost+", "+loan+"\n");
			}
			//bw.flush();
			
			String plural = "s";
			if(currentMonth==1) plural = "";
			
			bw.write(currentMonth+" month"+plural+"\n");
			line = br.readLine();
		}
		
		bw.close();
		br.close();
	}

}
