class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    //算法详情见：《剑指offer》p237
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int sum,carry;
        do{
            sum=a^b;
            carry=(a&b)<<1;
            a=sum;
            b=carry;
        }while(b!=0);
        return a;
    }
};