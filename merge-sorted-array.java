class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    //从后往前遍历，时间复杂度O(N)
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int indexA=m-1;
        int indexB=n-1;
        int indexAB=indexA+indexB+1;
        while(indexA>=0&&indexB>=0){
            if(A[indexA]<B[indexB]){
                A[indexAB--]=B[indexB--];
            }else{
                A[indexAB--]=A[indexA--];
            }
        }
        while(indexA>=0){
            A[indexAB--]=A[indexA--];
        }
        while(indexB>=0){
            A[indexAB--]=B[indexB--];
        }
    }
}