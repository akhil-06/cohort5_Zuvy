// Number theory PPT is here:- https://docs.google.com/presentation/d/1dqJ0XJQ3LmD5SceVM1A-PVUa5CtIEGvaJWBU0E8iFEU/edit?slide=id.p40#slide=id.p40
import java.util.Arrays;
public class Number_theory {
    public static boolean[] sieve(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if(n>=1) isPrime[1] = false;

        for(int i=2;(long)i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        boolean ans[] = sieve(10);
        for(int i=2;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
