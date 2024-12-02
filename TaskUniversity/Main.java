/*  
 Write a java program to sort a 2D array(Filled with prime number) by merge sort(ascending)

 CREATE BY:
 1.Akar Hassan
 2.Muhammad Jalal
 3.Muslim Mahmood
 4.Sana Latif
 */

 

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{99, -2}, {17, -3}, {7, 31}, {2, 5}, {11, 13}, {13, 91}};
        // print original 2Darray
        System.out.println("original 2Darray");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            
        }
        int n = arr.length;
        int m = arr[0].length;
        int[] arr1d = new int[n * m];
        int count = 0;

        //convert  2D array into a 1D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr1d[count++] = arr[i][j];
            }
        }

        // print 1D array
        System.out.println("\n1D array: ");
        for (int i = 0; i < arr1d.length; i++) {
            System.out.print(arr1d[i] + " ");
        }

        // Sort the 1D array in descending order
        mergeSort(arr1d);

        // Convert the sorted 1D array back into a 2D array
        System.out.println();
        int[][] arr2d = new int[n][m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2d[i][j] = arr1d[index++];
            }
        }
System.out.println("");
        // Print the sorted 2D array
        System.out.println("Print the sorted 2D array: ");

        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }
    // merge sort function only divde
    private static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        int mid = n / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];

        System.arraycopy(arr, 0, leftArray, 0, mid);
        System.arraycopy(arr, mid, rightArray, 0, n - mid);

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] arr) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;

        // Merge arrays in descending order
        while (j < leftSize && k < rightSize) {
            if (leftArray[j] > rightArray[k]) {
                arr[i] = leftArray[j];
                j++;
            } else {
                arr[i] = rightArray[k];
                k++;
            }
            i++;
        }
        while (j < leftSize) {
            arr[i] = leftArray[j];
            j++;
            i++;
        }
        while (k < rightSize) {
            arr[i] = rightArray[k];
            k++;
            i++;
        }
    }
}
