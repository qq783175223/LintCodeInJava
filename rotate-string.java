public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str==null||str.length==0)
            return;
        int len=str.length;
        offset=offset%len;
        char tmp;
        while(offset>0){
            for(int i=len-1;i>0;i--){
                tmp=str[i];
                str[i]=str[i-1];
                str[i-1]=tmp;
            }
            offset--;
        }
    }
}