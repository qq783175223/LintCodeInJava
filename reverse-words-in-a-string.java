public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public static String reverseWords(String s) {
        // write your code
        String result="",tmp;
        String[] array=s.trim().split(" ");
        //交换位置
        for(int i=0,j=array.length-1;i<j;i++,j--){
            while(array[i].equals("")){
                i++;
            }
            while(array[j].equals("")){
                j--;
            }
            tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }
        //重新组合
        for(int i=0;i<array.length;i++){
            if(!array[i].equals("")){
                result +=array[i]+" ";
            }
        }
        return result.trim();
    }

}
