import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Task 1
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
//        while( n != 0){
//            n--;
//            int d = input.nextInt();
//            ArrayList<Integer> numbers = new ArrayList<>();
//            for (int i = 0 ; i < d ; i++){
//                int number = input.nextInt();
//                numbers.add(number);
//            }
//            allLists.add(numbers);
//        }
//        int q = input.nextInt();
//        while (q != 0){
//            q--;
//            int x = input.nextInt();
//            int y = input.nextInt();
//            try {
//                System.out.println(allLists.get(x - 1).get(y-1));
//            } catch (IndexOutOfBoundsException e){
//                System.out.println("ERROR!");
//
//            }
//        }

        //Task 2
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i = 0 ; i < n ; i++){
//            int num = input.nextInt();
//            numbers.add(num);
//        }
//        int q = input.nextInt();
//
//        while (q != 0){
//            q--;
//            String operation = input.next();
//            if (operation.equals("Insert")){
//                int index = input.nextInt();
//                int number = input.nextInt();
//                numbers.add(index,number);
//            }
//            else if (operation.equals("Delete")){
//                int index = input.nextInt();
//                numbers.remove(index);
//            }
//            else{
//                System.out.println("Unknown command");
//            }
//        }
//        for (int to : numbers){
//            System.out.print(to + " ");
//        }

        //Task 3
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        ArrayList<Integer> LeftEdge = new ArrayList<>();
//        ArrayList<Integer> RightEdge = new ArrayList<>();
//
//        while(n != 0){
//            n--;
//            int operation = input.nextInt();
//            switch(operation){
//                case 1:
//                    int numberLeft = input.nextInt();
//                    LeftEdge.add(numberLeft);
//                    break;
//                case 2:
//                    int numberRight = input.nextInt();
//                    RightEdge.add(numberRight);
//                    break;
//                case 3:
//                    System.out.println(LeftEdge.get(LeftEdge.size() - 1));
//                    LeftEdge.remove(LeftEdge.size() - 1);
//                    break;
//                case 4:
//                    System.out.println(RightEdge.get(RightEdge.size() - 1));
//                    RightEdge.remove(RightEdge.size() - 1);
//                    break;
//            }
//        }

//        //Task 4
//        Scanner input = new Scanner(System.in);
//        Stack<Integer> numbers = new Stack<>();
//        fillStack(input , numbers,5);
//        printReverse(numbers);

        //Task 5
//        Scanner input = new Scanner(System.in);
//        System.out.print("The number of Students:");
//        int n = input.nextInt();
//        Queue<Integer> students = new LinkedList<>();
//        Stack<Integer> samsas = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            students.offer(input.nextInt());
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = input.nextInt();
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            samsas.push(arr[i]);
//        }
//
//        int failedAttempts = 0;
//
//        while (!students.isEmpty() && failedAttempts < students.size()) {
//            if (students.peek().equals(samsas.peek())) {
//                students.poll();
//                samsas.pop();
//                failedAttempts = 0;
//            } else {
//                students.offer(students.poll());
//                failedAttempts++;
//            }
//        }
//
//        System.out.println("Unable to eat: " + students.size());

        // Task 6
        int[] arr = {7, 3, 10, 1, 5, 2};

        System.out.println("Before heapify: " + Arrays.toString(arr));
        buildMinHeap(arr);
        System.out.println("Min heap:       " + Arrays.toString(arr));

    }

    //Task 4
//    public static void printReverse (Stack<Integer> stack){
//        if (stack.isEmpty()){
//            return;
//        }
//        int top = stack.pop();
//        System.out.print(top + " ");
//        printReverse(stack);
//    }
//    public static void fillStack(Scanner input , Stack<Integer> stack , int n ){
//        if (n == 0){
//            return;
//        }
//        int number = input.nextInt();
//        stack.push(number);
//        fillStack(input, stack , n - 1);
//    }

    //Task 6
    public static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, n, smallest);
        }
    }

    public static void buildMinHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
}
