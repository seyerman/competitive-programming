import java.util.*;

public class InterviewPreparationKit_Search_HTIceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer,ArrayList<Integer>> c = new HashMap<>();
        for(int i=0;i<cost.length;i++){
            int currCost = cost[i];
            if(c.containsKey(currCost)){
                c.get(currCost).add(i);
            }else{
                ArrayList<Integer> a = new ArrayList<>();
                a.add(i);
                c.put(currCost,a);
            }
        }
        int sunny = 0;
        int johnny = 0;
        boolean found = false;
        for(int i=0;i<cost.length && !found;i++){
            int cost1 = cost[i];
            int cost2 = money - cost1;
            if(cost1==cost2){
                if(c.get(cost1).size()>1){
                    sunny  = c.get(cost1).get(0);
                    johnny = c.get(cost1).get(1);
                    found = true;
                }
            }else if(c.containsKey(cost2)){
                    sunny  = i;
                    johnny = c.get(cost2).get(0);
                    found = true;                
            }
        }
        sunny++;
        johnny++;
        System.out.println(Math.min(sunny,johnny)+" "+Math.max(sunny,johnny));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
