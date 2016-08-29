public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    //从后往前替换，时间复杂度O(N) 
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int reallen = length;
        for(int i = 0;i<length;i++){
            if(string[i] == ' ')
                reallen += 2;
        }
        int index = reallen;
        for(int i = length - 1;i>= 0 ;i-- ){
            if(string[i] == ' '){
                string[--index] = '0';
                string[--index] = '2';
                string[--index] = '%';
            }else{
                string[--index] = string[i];
            }
        }
        
        return reallen;
    }
}