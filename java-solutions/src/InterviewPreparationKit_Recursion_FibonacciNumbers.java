import java.util.*;

public class InterviewPreparationKit_Recursion_FibonacciNumbers {

    public static int fibonacci(int n) {
        if(n==0 || n==1){
            return n;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}