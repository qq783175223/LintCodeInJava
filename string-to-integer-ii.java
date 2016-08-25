public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        //StringBuilder利于存放经常变动的字符串
        StringBuilder sb=new StringBuilder("");
        //返回一个有效开始头的字符串
        String myStr=validBegin(str);
        int len=myStr.length();
        boolean flag=true;
        //去除字符串内无效字符
        for(int i=0;i<len;i++){
            if('0'<=myStr.charAt(i)&&myStr.charAt(i)<='9'){
                sb.append(myStr.charAt(i));
                flag=false;
            }else{
                if(flag&&myStr.charAt(i)=='-'){
                    sb.append("-");
                    flag=false;
                }else{
                    break;
                }
            }
        }
        //如果没有有效字符则返回0
        if(sb.length()<1)
            return 0;
        //转换成整形返回
        if(sb.charAt(0)=='-'){
            try {
    			return Integer.parseInt(sb.toString());
    		} catch (Exception e) {
    			// TODO: handle exception
    			return Integer.MIN_VALUE;
    		}
        }else{
            try {
    			return Integer.parseInt(sb.toString());
    		} catch (Exception e) {
    			// TODO: handle exception
    			return Integer.MAX_VALUE;
    		}
        }
    }
    
    public String validBegin(String str){
        String myStr=str.trim();
        if((myStr.length()>1)&&(myStr.charAt(0)=='-')&&('0'<=myStr.charAt(1)&&myStr.charAt(1)<='9')){
            return myStr;
        }else if((myStr.length()>1)&&(myStr.charAt(0)=='+')&&('0'<=myStr.charAt(1)&&myStr.charAt(1)<='9')){
            return myStr.substring(1);
        }else if((myStr.length()>0)&&('0'<=myStr.charAt(0)&&myStr.charAt(0)<='9')){
            return myStr;
        }else{
            return "0";
        }
    }
}