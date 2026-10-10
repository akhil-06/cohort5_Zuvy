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
        // this loop is for iterating through the array and finding the minimum element in the unsorted part of the array
        for (int i = 0; i < arr.length - 1; i++) {
            // minIndex is the index of the minimum element in the unsorted part of the array
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

    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        // insertionSort(arr);
        // bubbleSort(arr);
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
