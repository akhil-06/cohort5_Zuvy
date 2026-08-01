public class Searching {
    public static int linearSearch(int arr[], int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int t){
        int s = 0;
        int e = arr.length - 1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == t){
                return mid;
            }else if(arr[mid] < t){
                s = mid+1;
            }else{
                e = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int target = 8;
        int result = linearSearch(arr, target);
        int result2 = binarySearch(arr, target);
        System.out.println("Target found at index: " + result);
        System.out.println("Target found at index: " + result2);
    }
}
