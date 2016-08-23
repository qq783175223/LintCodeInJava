class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
     //算法详情见《剑指offer》p182
    public int nthUglyNumber(int n) {
        // Write your code here
        if(n<=0){
            return 0;
        }
        int uglyArray[]=new int[n];
        int uglyIndex=0;
        uglyArray[uglyIndex]=1;
        int T2=0,T3=0,T5=0;
        while(uglyIndex+1<n){
            while(uglyArray[T2]*2<=uglyArray[uglyIndex]){
                T2++;
            }
            while(uglyArray[T3]*3<=uglyArray[uglyIndex]){
                T3++;
            }
            while(uglyArray[T5]*5<=uglyArray[uglyIndex]){
                T5++;
            }
            uglyArray[++uglyIndex]=min(uglyArray[T2]*2,uglyArray[T3]*3,uglyArray[T5]*5);
        }
        return uglyArray[n-1];
    }
    public int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }
};
