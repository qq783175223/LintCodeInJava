public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums==null||nums.size()<2){
            return 0;
        }
        //1,数组R保存从任意个位置i到最后一个元素组成的数组时的最大子数组值
        int R[]=new int[nums.size()];
        int maxSubArraysSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=nums.size()-1;i>=0;i--){
            sum +=nums.get(i);
            if(sum>maxSubArraysSum){
                maxSubArraysSum=sum;
            }
            if(sum<0){
                sum=0;
            }
            R[i]=maxSubArraysSum;
        }
        //2,计算0到当前位置i构成的数组最大子数组值,计算i+1到最后一个元素构成的数组最大子数组值
        //两者相加的最大值为所求
        int result=Integer.MIN_VALUE;
        maxSubArraysSum=Integer.MIN_VALUE;
        sum=0;
        for(int i=0;i<nums.size()-1;i++){
            sum +=nums.get(i);
            if(sum>maxSubArraysSum){
                maxSubArraysSum=sum;
            }
            if(sum<0){
                sum=0;
            }
            //
            if(result<maxSubArraysSum+R[i+1]){
                result=maxSubArraysSum+R[i+1];
            }
        }
        return result;
    }
}

