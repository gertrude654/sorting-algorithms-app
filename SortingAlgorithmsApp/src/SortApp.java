import java.util.Scanner;

public class SortApp {

    public static void main(String[] args) {

        //try and catch block for catching exceptions
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter integers on one line");

            //reads whole line include spaces and split it into array based on spaces
            String[] num = sc.nextLine().split(" ");

            int[] originalArr = new int[num.length];

            //assign num values to originalArr index
            for (int i = 0; i < originalArr.length; i++) {
                originalArr[i] = Integer.parseInt(num[i]);
            }
            int choice;
            do {
                int[] arr = copyArray(originalArr); // Copy the original array for having different sort on it
                System.out.println("Before sorting: ");
                printArr(arr);
                System.out.println("1. Bubble sort");
                System.out.println("2. Selection sort");
                System.out.println("0. Exit");
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        bubble(arr);
                        break;
                    case 2:
                        selection(arr);
                        break;
                    case 0:
                        System.out.println("Exit program");
                        break;
                    default:
                        System.out.println("Enter between 0 - 2!");
                }
            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to copy the original array from user
    private static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }


    //method implements selection sort
    private static void selection(int[] arr) {
        int minNum, temp, steps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minNum = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minNum] > arr[j])
                    minNum = j;
            }
            temp = arr[minNum];
            arr[minNum] = arr[i];
            arr[i] = temp;

            System.out.println();
            for (int n : arr) {
                System.out.print(n + " ");
            }
            steps++;
        }
        System.out.println("Steps taken: " + steps);
        System.out.println();
        System.out.println("After selection: ");
        printArr(arr);
    }

    //method implements bubble sort
    private static void bubble(int[] arr) {
        int temp, steps = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                System.out.println();
                for (int n : arr) {
                    System.out.print(n + " ");
                }
                steps++;
            }
        }
        System.out.println("Steps taken: " + steps);
        System.out.println();
        System.out.println("After Bubble sort: ");
        printArr(arr);
    }

    //method that print original array
    private static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
