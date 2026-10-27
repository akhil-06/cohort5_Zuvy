import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
    public static int maxSum(int a[], int k) {
        int window = 0;
        for (int i = 0; i < k; i++) {
            window += a[i];
        }
        int best = window;
        for (int i = k; i < a.length; i++) {
            window += a[i] - a[i - k];
            best = Math.max(best, window);
        }
        return best;
    }

    public static double[] averages(int[] a, int k) {
        double[] res = new double[a.length - k + 1];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (i >= k)
                sum -= a[i - k];
            if (i >= k - 1)
                res[i - k + 1] = (double) sum / k;
        }
        return res;
    }

    public static double findMaxAverage(double[] a) {
        double best = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > best) {
                best = a[i];
            }
        }
        return best;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++)
            if (isVowel(s.charAt(i)))
                count++;
        int best = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                count++;
            if (isVowel(s.charAt(i - k)))
                count--;
            best = Math.max(best, count);
            if (best == k)
                return k;
        }
        return best;
    }

    public static int[] subArraySum(int[] a, int s) {
        int l = 0, sum = 0;
        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > s && l < r) {
                sum -= a[l];
                l++;
            }
            if (sum == s)
                return new int[] { l, r };
        }
        return new int[] { -1 };
    }

    public static int lengthoflongestsubstringwithatmostkdistict(String s, int k) {
        // create a hashmap
        Map<Character, Integer> mp = new HashMap<>();
        int best=0,l=0;
        for(int r=0;r<s.length();r++){
            // add in map
            mp.merge(s.charAt(r), l, Integer::sum);
            while(mp.size() > k){ //invalid
                char c = s.charAt(l);
                if(mp.merge(c, -1, Integer::sum)==0);//decrement
                    mp.remove(c);
                l++;
            }
            best = Math.max(best, r-l+1);
        }
        return best;
    }


    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> mp = new HashMap<>(); //char-last index
        int l=0, best=0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(mp.containsKey(c) && mp.get(c) >= 1){
                l = mp.get(c) + 1;
            }
            mp.put(c, r);
            best = Math.max(best, r-l+1);
        }
        return best;
    }

    public static int[] maxSlidingWindow(int[] a, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        int []res = new int[a.length-k+1];
        for(int i=0;i<a.length;i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){ 
                dq.pollFirst(); //1. expire the old front
            }
            while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                dq.pollLast();  //remove the weaker
            }
            dq.offerLast(i);
            if(i>=k-1){
                res[i-k+1] = a[dq.peekFirst()]; //front=max
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // String str = "abciiidef";
        // System.out.println(lengthOfLongestSubstring(str));
        int[] arr = { 1, 3, 2, 1, 4, 1, 8, 2 };
        int ans[] = maxSlidingWindow(arr, 3);
        // System.out.println(subArraySum(arr));

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }
}
