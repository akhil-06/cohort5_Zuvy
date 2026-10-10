public class Sorting {

    public static void bubbleSort(int[] arr) {
        // this loop is for iterating through the array and comparing adjacent elements
        for (int i = 0; i < arr.length - 1; i++) {
            // this loop is for comparing adjacent elements and swapping them if they are in
            // the wrong order
            // why j-i-1? because after each iteration of the outer loop, the largest
            // element is placed at the end of the array, so we don't need to compare it
            // again
            for (int j = 0; j < arr.length - i - 1; j++) {
                // if the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        // for loop is for iterating through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // key is the current element to be compared with the previous elements
            int key = arr[i];
            // j is the index of the previous element
            int j = i - 1;
            // while loop is for comparing the key with the previous elements and shifting
            // them to the right if they are greater than the key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // inserting the key in its correct position
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        // this loop is for iterating through the array and finding the minimum element
        // in the unsorted part of the array
        for (int i = 0; i < arr.length - 1; i++) {
            // minIndex is the index of the minimum element in the unsorted part of the
            // array
            int minIndex = i;
            // thisloop is for finding the minimum element in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // updating the minIndex if a smaller element is found
                    minIndex = j;
                }
            }
            // swapping the minimum element with the first element of the unsorted array
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        // this is the temporary array that will hold the merged sorted elements from
        // the two subarrays
        int[] t = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        // this loop is for merging the two sorted subarrays into the temporary array t
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                t[k] = arr[i];
                k++;
                i++;
            } else {
                t[k] = arr[j];
                k++;
                j++;
            }
        }
        // thisloop is for copying the remaining elements of the left subarray (if any)
        // to the temporary array t
        while (i <= mid) {
            t[k] = arr[i];
            k++;
            i++;
        }
        // this loop is for copying the remaining elements of the right subarray (if
        // any) to the temporary array t
        while (j <= r) {
            t[k] = arr[j];
            k++;
            j++;
        }
        // 1,3
        // 2,4,6,8
        // we can use System.arraycopy to copy the elements from the temporary array t
        // to the original array arr, starting from index l. This is more efficient than
        // using a for loop to copy the elements one by one.
        // System.arraycopy(t, 0, arr, l, t.length);
        // for(int p=0;p<t.length;p++){
        // arr[l+p]=t[p];
        // }

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // find the middle point
            int mid = (left + right) / 2;
            // sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    public static int partition(int[]arr, int low, int high){
        int pivot = arr[high];
        //  why I is low-1, because we want to keep track of the index of the smaller element, and we start with the assumption that there are no smaller elements yet, so we set it to low-1. As we iterate through the array, we will increment i whenever we find an element smaller than or equal to the pivot, and swap it with the element at index i. This way, all elements smaller than or equal to the pivot will be on the left side of the pivot, and all elements greater than the pivot will be on the right side.
        int i = low-1;
        // thisloop is for iterating through the array and comparing each element with the pivot
        for(int j=low;j<high;j++){
            if(arr[j] < pivot){
// this i++ is for incrementing the index of the smaller element, so that we can swap it with the current element arr[j] which is smaller than the pivot. 
                i++;
                // swapping the current element arr[j] with the element at index i, so that all elements smaller than or equal to the pivot are on the left side of the pivot.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swapping the pivot element with the element at index i+1, so that the pivot is in its correct position in the sorted array.
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        // insertionSort(arr);
        // bubbleSort(arr);
        // selectionSort(arr);
        // quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
