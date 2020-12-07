import java.util.*;

public class InterviewPreparationKit_SQ_QueuesATaleOfTwoStacks {
    public static class MyQueue<T>{
        private Stack<T> s1;
        private Stack<T> s2;
        
        public MyQueue(){
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void enqueue(T x){
            s1.push(x);
        }
        public void dequeue(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            s2.pop();
        }
        public T peek(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();            
        }
        
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}