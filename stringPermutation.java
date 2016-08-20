public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        byte a[]=A.getBytes();
        byte b[]=B.getBytes();
        int help[]=new int[256];
        for(int i=0;i<a.length;i++){
                help[a[i]] +=1;
        }
        for(int i=0;i<b.length;i++){
            help[b[i]] -=1;
        }
        for(int i=0;i<256;i++){
            if(help[i]!=0){
                return false;
            }
        }
        return true;
    }
}