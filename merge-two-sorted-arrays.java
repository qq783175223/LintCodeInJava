class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    //从前往后遍历，时间复杂度O(N)
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int indexA=A.length-1;
        int indexB=B.length-1;
        int indexAns=indexA+indexB+1;
        int ans[]=new int[indexAns+1];
        while(indexA>=0&&indexB>=0){
            if(A[indexA]>B[indexB]){
                ans[indexAns--]=A[indexA--];
            }else{
                ans[indexAns--]=B[indexB--];
            }
        }
        while(indexA>=0){
            ans[indexAns--]=A[indexA--];
        }
        while(indexB>=0){
            ans[indexAns--]=B[indexB--];
        }
        return ans;
    }
}