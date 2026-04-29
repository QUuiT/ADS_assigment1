import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Task 1
//
//        String firstWord = input.nextLine();
//        String secondWord = input.nextLine();
//
//        char[] firstArray = firstWord.toCharArray();
//        char[] secondArray = secondWord.toCharArray();
//
//        Arrays.sort(firstArray);
//        Arrays.sort(secondArray);
//
//        String sortedFirst = new String(firstArray);
//        String sortedSecond = new String(secondArray);
//
//        if (sortedFirst.equals(sortedSecond)) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }

        //Task 2
//        int n = input.nextInt();
//        ArrayList<Integer> arr = new ArrayList<>(n);
//        for (int i = 0 ; i < n ; i++){
//            int number = input.nextInt();
//            arr.add(number);
//        }
//        int k = input.nextInt();
//        for (int i = 0 ; i < arr.size() ; i++){
//            for (int j = 0 ; j < arr.size() - i - 1 ; j++){
//                if (arr.get(j) > arr.get(j+1)){
//                    int temp = arr.get(j + 1);
//                    arr.set(j + 1, arr.get(j));
//                    arr.set(j, temp);
//                }
//            }
//        }
//        System.out.println(arr.get(k-1));

        //Task 3
        int n = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0 ; i < n ; i++){
            int number = input.nextInt();
            arr.add(number);
        }
        for (int i = 0 ; i < arr.size() ; i++){
            for (int j = 0 ; j < arr.size() - i - 1 ; j++){
                if (arr.get(j) > arr.get(j+1)){
                    int temp = arr.get(j + 1);
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        if (n % 2 == 1){
            System.out.println((arr.get(n/2)));
        }
        else{
            System.out.println((arr.get(n/2) + arr.get(n/2 - 1)) / 2.0);
        }
    }
}