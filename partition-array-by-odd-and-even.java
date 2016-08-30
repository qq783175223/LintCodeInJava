public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int tmp;
        for(int i=0,j=nums.length-1;i<j;){
          if(nums[i]%2==1&&nums[j]%2==0){
              i++;j--;
          }else if(nums[i]%2==0&&nums[j]%2==0){
              j--;
          }else if(nums[i]%2==1&&nums[j]%2==1){
              i++;
          }else{
              tmp=nums[i];
              nums[i]=nums[j];
              nums[j]=tmp;
          }
        }
    }
}