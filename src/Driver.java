import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {
    public static final int MIN = 0;
    public static final int MAX = 10;
    private Scanner sc;
    private int selection;

    public Driver(Scanner sc) {
        this.sc = sc.useDelimiter("\n");
    }

    public void run() {
        do {
            System.out.println("PHAN CONG HUY - FX16513");
            System.out.println("Binary Search: ");
            System.out.println("Enter the number of elements in array (1 to 10): ");
            selection = sc.nextInt();
            if (!isValid(selection)) {
                System.out.println("Only type number from 1 to 10. Try again.");
            }
        } while (!isValid(selection));

        System.out.println("Enter search value: ");
        int value = sc.nextInt();


        int[] arr = new int[selection];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(MIN, MAX);

        }

        System.out.println("Unsorted array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int index = binarySearch(arr, value);
        if (index != -1) {
            System.out.println("Found " + value + " at index: " + index);
        } else {
            System.out.println("Cannot found " + value + " .");
        }
    }

    public int binarySearch(int[] arr, int a) {

        int low = 1;
        int high = arr.length - 1;

        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == a) {
                return mid;
            } else if (arr[mid] > a) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (arr[low] == a) {
            return low;
        }
        return -1;
    }

    public boolean isValid(int selection) {
        for (int i = 1; i < 11; i++) {
            if (selection == i) {
                return true;
            }
        }
        return false;
    }

    public void swap(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // Tim vi tri co gia tri nho nhat tinh tu i den a.length - 1
            int tem = i;
            for (int j = i; j < a.length; j++) {
                if (a[tem] > a[j]) {
                    tem = j;
                }
            }
            // doi cho gia tri tai i va gia tri tai vi tri tem
            swap(a, i, tem);
        }
    }
}
