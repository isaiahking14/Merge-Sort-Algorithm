import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort{
   static int[] arr;
    public static void main(String[] args) throws FileNotFoundException {
        load();
        sort(arr, 0, arr.length - 1);
    
    }
    
    private static void load() throws FileNotFoundException {
                                        // change for file
        File number = new File("numbers-4.txt");
        Scanner scan = new Scanner(number);
        int index_count = 0;
        while (scan.hasNextInt()){
            index_count++;
            scan.nextInt();
        }
        arr = new int[index_count];
        scan.close();
        
        Scanner scan2 = new Scanner(number);
        index_count = -1;
        while (scan2.hasNextInt()){
            index_count++;
            arr[index_count] = scan2.nextInt();
        }
        scan2.close();
    }

    static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int sub_array_1 = m - l + 1;
        int sub_array_2 = r - m;

        // Create temp arrays
        int L[] = new int [sub_array_1];
        int R[] = new int[sub_array_2];

        // Copy data to temp arrays
        for (int i = 0; i < sub_array_1; ++i){
            L[i] = arr[l + i];
        }
            

        for (int j = 0; j < sub_array_2; ++j){
            R[j] = arr[m + 1 + j];
        }
            

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < sub_array_1 && j < sub_array_2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left subarray if any
        while (i < sub_array_1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of right subarray if any
        while (j < sub_array_2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // recursive method
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}