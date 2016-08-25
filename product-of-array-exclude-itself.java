public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int len=A.size();
        ArrayList<Long> B=new ArrayList<Long>();
        for(int i=0;i<len;i++){
            B.add(multi(i,len,A));
        }
        return B;
    }
    
    public Long multi(int index,int len,ArrayList<Integer> A) {
        Long before=1L;
        Long behind=1L;
        for(int i=0;i<index;i++){
            before *=A.get(i);
        }
        for(int j=index+1;j<len;j++){
            behind *=A.get(j);
        }
        return before*behind;
    }
}
