public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    //时间复杂度O(m),m是1的个数
    public int countOnes(int num) {
        // write your code here
        int cnt=0;
        while(num!=0){
            num=num&(num-1);
            cnt++;
        }
        return cnt;
    }
};