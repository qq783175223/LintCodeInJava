class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        char[] array;
        int result=0;
        for(int i=0;i<=n;i++){
            array=(i+"").toCharArray();
            for(int j=0;j<array.length;j++){
                if(Integer.parseInt(""+array[j])==k){
                    result++;
                }
            }
        }
        return result;
    }
};
