import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;


public class CodeForces20200408CEugeneAndAnArrayTry2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		String[] parts = line.split(" ");
		
		long[] sum = new long[n+1];

		for (int i = 1; i < n+1; i++) {
			int curr = Integer.parseInt(parts[i-1]);
			sum[i] = sum[i-1] + curr;
		}
		
		long goods = 0;
		for (int i = 0; i < n+1; i++) {
			Set<Long> prefixSums = new HashSet<>();
			int j = i;
			for (; j < n+1 && !prefixSums.contains(sum[j]); j++) {
				prefixSums.add(sum[j]);
			}
			goods += j-1-i;
		}
		
		bw.write(goods+"\n");

		bw.close();
		br.close();
	}

}
