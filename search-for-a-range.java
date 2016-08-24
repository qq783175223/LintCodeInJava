public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int result[]={-1,-1};
        searchRange2(A,target,0,A.length-1,result);
        return result;
    }
    
    public void searchRange2(int[] A, int target,int start,int end,int[] result) {
        int mid=(start+end)/2;
        if(start<=end){
            if(A[mid]>target){
                searchRange2(A,target,start,mid-1,result);
            }else if(A[mid]<target){
                searchRange2(A,target,mid+1,end,result);
            }else{
                //如果找到A[mid]==target,并且是第一次找到
                if(result[0]==-1&&result[1]==-1){
                    result[0]=mid;
                    result[1]=mid;
                }else if(mid<result[0]){//不是第一次找到
                    result[0]=mid;
                }else if(mid>result[1]){//不是第一次找到
                    result[1]=mid;
                }
                //找到一个A[mid]==target,但是有可能前后还有值=target,所以递归前后
                searchRange2(A,target,start,mid-1,result);
                searchRange2(A,target,mid+1,end,result);
            }
        }
    }
}
