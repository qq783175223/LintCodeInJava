public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if(nums==null){
            return;
        }
        int i=nums.length-1;
        for(;i>0;i--){
            if(nums[i]>nums[i-1]){
                break;
            }
        }
        if(i<=0){
            Arrays.sort(nums);
        }else{
            int minVal=nums[i],minValIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i-1]&&nums[j]<minVal){
                    minVal=nums[j];
                    minValIndex=j;
                }
            }
            int tmp=nums[i-1];
            nums[i-1]=nums[minValIndex];
            nums[minValIndex]=tmp;
            Arrays.sort(nums,i,nums.length);
        }
        
    }
}