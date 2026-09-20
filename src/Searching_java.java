public class Searching_java {
    public static int serahcInfiniteArray(int arr[], int target) {
        int lo=0;
        int hi = 1;
        while (target > arr[hi]) {
            lo = hi;
            hi = hi * 2;
        }

        while(lo<=hi){
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int findIndexes(int arr[], int target, boolean wantFirst) {
        int lo = 0, hi = arr.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                res = mid;
                if (wantFirst) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static int[] searchrange(int arr[], int target) {
        int first = findIndexes(arr, target, true);
        int last = findIndexes(arr, target, false);
        return new int[] { first, last };
    }

    public static int firstOccurence(int arr[], int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                res = mid;
                hi = mid - 1;
            } else {
                if (arr[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 22, 3, 4, 5, 6, 7, 8, 9 };
        int target = 2;
        int[] range = searchrange(arr, target);
        System.out.println("First: " + range[0] + ", Last: " + range[1]);
        System.out.println("Count of Occurrences: " + (range[1] - range[0] + 1));
        // int ans = firstOccurence(arr, target);
        // System.out.println("First Occurrence: " + ans);
    }
}
