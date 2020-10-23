import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

//CF_1351_C
public class CF_1351_C {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void solve() throws IOException{
		String line = br.readLine();
		TreeSet<String> visited = new TreeSet<>();
		int time = 0;
		int x = 0;
		int y = 0;
		String prev = "(0,0)";
		//System.out.println("==");
		for (int i = 0; i < line.length(); i++) {
			char dir = line.charAt(i);
			switch(dir) {
				case 'N': y++; break;
				case 'S': y--; break;
				case 'E': x++; break;
				case 'W': x--; break;
			}
			String current = "("+x+","+y+")";
			//System.out.println(current);
			String lastPath = prev+"-"+current;
			String lastPathR = current+"-"+prev;
			if(visited.contains(lastPath)) {
				time += 1;
			}else {
				time += 5;
				visited.add(lastPath);
				visited.add(lastPathR);
			}
			prev = current;
			//System.out.println(visited);
		}
		bw.write(time+"");
		
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int T = Integer.parseInt(line);
		
		while(T>0){
			
			solve();
			
			bw.write("\n");
			T--;
		}
		
		bw.close();
		br.close();
	}

}
