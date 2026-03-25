
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] x = { 3 , 2 , 3 , 4 , 5};
        System.out.print(recursion2(n , x));
    }

    //Task 1
    public static int recursion(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return n;
        }
        return n * n  + recursion(n - 1 ); // Time complexity: BigO(1)
    }

    // Task 4
    public static void recursion4(int n ){
        Scanner input = new Scanner(System.in);
        if(n == 0){
            return ;
        }
        int seq = input.nextInt();
        recursion4(n - 1);
        System.out.print(seq + " ");
    }

    // Task 3
    public static int recursion3(int b, int n ){
        if(n == 0){
            return 1;
        }
         return (int) (Math.pow(b , n) + recursion3(b , n - 1));
    }

    // Task 2
    public static int recursion2(int n  , int[] x){
        if(n == 0){
            return 0;
        }
        return x[n - 1] + recursion2(n - 1, x);
    }
}
// { 3 , 2 , 3 , 4 , 5 }
// input: 3
// output: 1 + 2 + 3 = 6