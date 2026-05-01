import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Task 1
//        String firstWord = input.nextLine();
//        String secondWord = input.nextLine();
//
//        char[] firstArray = firstWord.toCharArray();
//        char[] secondArray = secondWord.toCharArray();
//
//        for (int i = 0 ; i < firstArray.length ; i++){
//            for (int j = 0 ; j < firstArray.length - i - 1 ; j++){
//                if (firstArray[j] > firstArray[j+1]){
//                    char temp = firstArray[j+1];
//                    firstArray[j+1] = firstArray[j];
//                    firstArray[j] = temp;
//                }
//            }
//        }
//        for (int i = 0 ; i < secondArray.length ; i++){
//            for (int j = 0 ; j < secondArray.length - i - 1 ; j++){
//                if (secondArray[j] > secondArray[j+1]){
//                    char temp = secondArray[j+1];
//                    secondArray[j+1] = secondArray[j];
//                    secondArray[j] = temp;
//                }
//            }
//        }
//       if(Arrays.equals(firstArray, secondArray)){
//           System.out.println("YES");
//       }
//       else{
//           System.out.println("NO");
//       }

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
//        int n = input.nextInt();
//        ArrayList<Integer> arr = new ArrayList<>(n);
//        for (int i = 0 ; i < n ; i++){
//            int number = input.nextInt();
//            arr.add(number);
//        }
//        for (int i = 0 ; i < arr.size() ; i++){
//            for (int j = 0 ; j < arr.size() - i - 1 ; j++){
//                if (arr.get(j) > arr.get(j+1)){
//                    int temp = arr.get(j + 1);
//                    arr.set(j + 1, arr.get(j));
//                    arr.set(j, temp);
//                }
//            }
//        }
//        if (n % 2 == 1){
//            System.out.println((arr.get(n/2)));
//        }
//        else{
//            System.out.println((arr.get(n/2) + arr.get(n/2 - 1)) / 2.0);
//        }

        //Task 4
        System.out.println("The size of an ArrayList:");
        int size = input.nextInt();
        System.out.println("Input elements of the ArrayList");
        ArrayList<Integer> weights = new ArrayList<>(size);
        for ( int i = 0 ; i < size; i++){
            int element = input.nextInt();
            weights.add(element);
        }
        System.out.println("Days:");
        int days = input.nextInt();
        int max_element = weights.get(0); // lower bound of capacity
        int sum = 0; // upper bound of capacity
        for(int to : weights){
            sum += to;
            if (max_element < to){
                max_element = to;
            }
        }
        int left_capacity = max_element;
        int right_capacity = sum;
        int answer = 0;
        while (left_capacity <= right_capacity){
            int mid_capacity = (left_capacity + right_capacity) / 2;
            int used_days = 1;
            int number_packets = 0;
            for (int i = 0 ; i < size ; i++){
                if(weights.get(i) + number_packets <= mid_capacity){
                    number_packets += weights.get(i);
                }
                else{
                    used_days++;
                    number_packets = weights.get(i);
                }
            }
            if (used_days <= days){
                right_capacity = mid_capacity - 1;
                answer = mid_capacity;
            }
            else{
                left_capacity = mid_capacity + 1;
            }
        }
        System.out.println(answer);
    }
}