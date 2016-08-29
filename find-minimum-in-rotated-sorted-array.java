public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    //数据部分有序，两个指针分别指向数组的前后，时间效率是二分的
    public int findMin(int[] nums) {
        // write your code here
        int index1=0,index2=nums.length-1;
        int indexMid=0;
        if(nums[index1]<nums[index2]){
            return nums[index1];
        }
        while(true){
            if(index2-index1==1){
                break;
            }
            indexMid=(index1+index2)/2;
            if(nums[indexMid]>nums[index2]){
                index1=indexMid;
            }else{
                index2=indexMid;
            }
        }
        return nums[index2];
    }
}