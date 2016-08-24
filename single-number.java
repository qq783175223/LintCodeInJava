public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    //算法详情见《剑指offer》p211
    public int singleNumber(int[] A) {
        // Write your code here
        if(A==null||A.length==0){
            return 0;
        }
        int result=A[0];
        for(int i=1;i<A.length;i++){
            result=result^A[i];
        }
        return result;
    }
}