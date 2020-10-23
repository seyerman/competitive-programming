import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HE_NodesInASubtree {
	
	public static class Node{
		private char c;
		private int i;
		private List<Node> children;
		public Node(char ch,int idx) {
			c = ch;
			i = idx;
			children = new ArrayList<>();
		}
		public char getChar() {
			return c;
		}
		public List<Node> getChildren(){
			return children;
		}
		
		public int howManyChars(char ch) {
			int count = 0;
			if(c==ch) {
				count++;
			}
			for (int i = 0; i < children.size(); i++) {
				Node currentChild = children.get(i);
				count += currentChild.howManyChars(ch);
			}
			return count;
		}
		
		public String toString() {
			return "("+i+","+c+")";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] parts = br.readLine().split(" ");
		int N = Integer.parseInt(parts[0]);
		int Q = Integer.parseInt(parts[1]);
		
		String s = br.readLine();
		
		Node[] nodes = new Node[N]; //direct access to all nodes
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 1; i < N; i++) {
			parts = br.readLine().split(" ");
			int u = Integer.parseInt(parts[0])-1;
			int v = Integer.parseInt(parts[1])-1;			
			q.offer(new int[] {u,v});
		}
		
		while(!q.isEmpty()) {
			int[] vertexes = q.poll();
			int u = vertexes[0];
			int v = vertexes[1];
			//bw.write((u+1)+","+(v+1)+"\n");
			int min = Math.min(u, v);
			if(nodes[0]==null && min==0) {
				//bw.write("adding the root\n");
				nodes[min] = new Node(s.charAt(min),min+1);				
			}
			
			if(nodes[u]!=null) { //u was added previously
				//bw.write("adding "+(v+1)+"\n");
				nodes[v] = new Node(s.charAt(v),v+1); //v is the new node
				nodes[u].getChildren().add(nodes[v]);
				//bw.write("children of "+(u+1)+":"+nodes[u].getChildren()+"\n");
			}else if(nodes[v]!=null) { //v was added previously
				//bw.write("adding "+(u+1)+"\n");
				nodes[u] = new Node(s.charAt(u),u+1); //u is the new node
				nodes[v].getChildren().add(nodes[u]);
				//bw.write("children of "+(v+1)+":"+nodes[v].getChildren()+"\n");
			}else {
				q.offer(new int[] {u,v});
			}			
		}
		
		//for (int i = 0; i < nodes.length; i++) {
		//	System.out.println((i+1)+"["+s.charAt(i)+"]:"+nodes[i].getChildren());
		//}
		
		for (int i = 0; i < Q; i++) {
			parts = br.readLine().split(" ");
			int u = Integer.parseInt(parts[0])-1;
			char c = parts[1].charAt(0);
			
			bw.write(nodes[u].howManyChars(c)+"\n");
		}
		
		
		br.close();
		bw.close();
	}

}
