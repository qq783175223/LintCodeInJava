public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    //数据部分有序，两个指针分别指向数组的前后，时间效率是二分的
    public int findMin(int[] nums) {
        // write your code here
        int index1=0,index2=nums.length-1;
        int indexMid=index1;//一旦发现数组的第一个元素小于最后一个元素，则说明该数组是排序的，直接返回第一个元素
        while(nums[index1]>nums[index2]){
            if(index2-index1==1){
                indexMid=index2;
                break;
            }
            indexMid=(index1+index2)/2;
            if(nums[indexMid]>nums[index2]){
                index1=indexMid;
            }else{
                index2=indexMid;
            }
        }
        return nums[indexMid];
    }
}