import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//Template
public class KickStart2020RoundBSolutionCRobotPathDecodingSolved {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static byte isDigit(char x) {
		byte dig = -1;
		switch (x) {
			case '0':
				dig = 0;
				break;
			case '1':
				dig = 1;
				break;
			case '2':
				dig = 2;
				break;
			case '3':
				dig = 3;
				break;
			case '4':
				dig = 4;
				break;
			case '5':
				dig = 5;
				break;
			case '6':
				dig = 6;
				break;
			case '7':
				dig = 7;
				break;
			case '8':
				dig = 8;
				break;
			case '9':
				dig = 9;
			break;
		}
		return dig;
	}
	
	public static void solve() throws IOException{
		String line = br.readLine();
		int x=1,y=1;
		Stack<Integer> special = new Stack<>();
		special.push(1);
		for (int i = 0; i < line.length(); i++) {
			char curr = line.charAt(i);
			//bw.write("\n");
			//bw.write(curr+" ");
			byte digit = isDigit(curr);
			if(curr==')') {
				special.pop();
			}else if(digit!=-1) {
				i++;
				int rep = (int)((special.peek()*(long)digit)%1000000000);
				//bw.write(" ["+rep+"] ");
				special.push(rep);
			}else {
				switch (curr) {
					case 'N':
						y -= special.peek();
						if(y<=0) {
							y = 1000000000+y;
						}
					break;
					case 'S':
						y = (special.peek()+y)%1000000000;
					break;
					case 'E':
						x = (special.peek()+x)%1000000000;
					break;
					case 'W':
						x -= special.peek();
						if(x<=0) {
							x = 1000000000+x;
						}
					break;
				}
			}
			//bw.write(x+" "+y);
		}
		bw.write(x+" "+y);
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
