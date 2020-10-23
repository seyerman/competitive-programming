import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//SPOJ - TRYCOMP
public class TallerSco2_2020_F_TryToCcomplete {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static class WordMostCommon{
		private String word;
		private int frecuency;
		public WordMostCommon(String w, int f) {
			word = w;
			frecuency = f;
		}
		public String getWord() {
			return word;
		}
		public int getFrecuency() {
			return frecuency;
		}
		public String toString() {
			if(word.equals("")) {
				return "-1";
			}else {
				return word+" "+frecuency;
			}
		}
	}
	
	public static class Node{
		private Node[] children;
		private int finish;
		private int best;
		
		public Node() {
			children = new Node[26];
			finish = 0;
			best = 0;
		}
		
		public int addWord(String w, int i) {
			if(i==w.length()) {
				finish++;
				//bw.write(w+" "+finish+"\n");
				best = Math.max(best, finish);
			}else {
				char c = w.charAt(i);
				int child = c-'a';
				if(children[child]==null) {
					children[child] = new Node();
				}
				int bestDescendants = children[child].addWord(w, i+1);
				best = Math.max(best, bestDescendants);
			}
			return best;
		}

		public WordMostCommon queryMostWordPrefix(String prefix, int i) throws IOException {
			if(i==prefix.length()) {
				return mostCommonTraversal(prefix);
			}else {
				char c = prefix.charAt(i);
				int child = c-'a';
				if(children[child]==null) {
					//bw.write(prefix+"\n");
					//bw.write("x:'"+(x+c)+","+i+"'\n");
					return new WordMostCommon("", -1);
				}else {
					return children[child].queryMostWordPrefix(prefix, i+1);
				}
			}
		}
		
		public WordMostCommon mostCommonTraversal(String word) throws IOException {
			WordMostCommon wmc = new WordMostCommon(word, finish);
			int maxChild = -1;
			int valueMaxChild = 0;
			for (int i = 0; i < children.length; i++) {
				if(children[i]!=null) {
					if(children[i].best>valueMaxChild) {
						maxChild = i;
						valueMaxChild = children[i].best;
					}
				}
			}
			if(maxChild>-1) {
				WordMostCommon currentWmc = children[maxChild].mostCommonTraversal(word+(char)(maxChild+'a'));
				//bw.write("Comparando "+currentWmc.getWord()+","+currentWmc.getFrecuency()+" con "+wmc.getWord()+","+wmc.getFrecuency()+"\n");
				if(currentWmc.getFrecuency()>wmc.getFrecuency()) {
					wmc = currentWmc;
				}
			}
			return wmc;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		
		Node root = new Node();
		
		while(n>0){
			line = br.readLine();
			root.addWord(line, 0);
			n--;
		}
		
		line = br.readLine();
		int q = Integer.parseInt(line);
		
		while(q>0){
			line = br.readLine();
			WordMostCommon wmc = root.queryMostWordPrefix(line,0);
			bw.write(wmc+"\n");
			q--;
		}
		
		
		bw.close();
		br.close();
	}

}
