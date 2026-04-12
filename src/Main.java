import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
        while( n != 0){
            n--;
            int d = input.nextInt();
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0 ; i < d ; i++){
                int number = input.nextInt();
                numbers.add(number);
            }
            allLists.add(numbers);
        }
        int q = input.nextInt();
        while (q != 0){
            q--;
            int x = input.nextInt();
            int y = input.nextInt();
            try {
                System.out.println(allLists.get(x - 1).get(y-1));
            } catch (IndexOutOfBoundsException e){
                System.out.println("ERROR!");

            }


        }

    }


}
