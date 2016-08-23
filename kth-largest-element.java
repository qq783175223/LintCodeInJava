class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSort(k,nums,0,nums.length-1);
    }
    
    public int quickSort(int k, int[] nums,int start,int end){
        int i=start,j=end,tmp;
        int benchMark=nums[i];
        //数组的前后元素依次和benchMark比较(注意首先从后面开始比较)
        while(i<j){
            //数组的后面元素与benchMark比较
            while(i<j){
                if(benchMark>=nums[j]){
                    j--;
                }else{
                    tmp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=tmp;
                    i++;
                    break;
                }
            }
            //数组的前面元素与benchMark比较
            while(i<j){
                if(nums[i]>=benchMark){
                    i++;
                }else{
                    tmp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=tmp;
                    j--;
                    break; 
                }
            }
        }
        //剪枝法：因为每次排除了一半，所以时间复杂度=n+n/2+n/4+...+1=O(N)
        //此时的i等于j
        if(i+1>k){
            return quickSort(k,nums,start,i);
        }else if(i+1<k){
            return quickSort(k,nums,i+1,end);
        }else{
            return nums[i];
        }
    }
};