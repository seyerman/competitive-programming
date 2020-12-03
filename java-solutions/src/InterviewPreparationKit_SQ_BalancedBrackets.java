import java.io.*;
import java.util.*;

public class InterviewPreparationKit_SQ_BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        boolean match = true;
        for(int i=0;i<s.length() && match;i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                case '[':
                case '{':
                    st.push(c);
                break;
                case ')':
                    if(!st.isEmpty() && st.peek()=='('){
                        st.pop();
                    }else{
                        match = false;
                    }
                break;
                case ']':
                    if(!st.isEmpty() && st.peek()=='['){
                        st.pop();
                    }else{
                        match = false;
                    }
                break;
                case '}':
                    if(!st.isEmpty() && st.peek()=='{'){
                        st.pop();
                    }else{
                        match = false;
                    }
                break;
            }
        }
        if(match){
            if(!st.isEmpty()){
                match = false;
            }
        }
        if(match){
            return "YES";
        }else{
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
