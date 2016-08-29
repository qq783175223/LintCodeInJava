public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num==null||num.length<1){
            return -1;
        }
        int index1=0,index2=num.length-1;
        int indexMid=index1;
        while(num[index1]>=num[index2]){
            if(index2-index1==1){
                indexMid=index2;
                break;
            }
            indexMid=(index1+index2)/2;
            //如果下标index1、index2、indexMid三者指向的三个数相等，则只能顺序查找
            if(num[indexMid]==num[index1]&&num[index2]==num[indexMid]){
                return minInOrder(num);
            }
            if(num[indexMid]>=num[index1]){
                index1=indexMid;
            }else if(num[indexMid]<=num[index2]){
                index2=indexMid;
            }
        }
        return num[indexMid];
    }
    private int minInOrder(int[] num){
        int min=num[0];
        for(int i=1;i<num.length;i++){
            if(min>num[i]){
                min=num[i];
            }
        }
        return min;
    }
}