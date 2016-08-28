public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n<=1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int last=2,lastlast=1,tmp;
        n=n-2;
        while(n-->0){
            tmp=last;
            last=last+lastlast;
            lastlast=tmp;
        }
        return last;
    }
}