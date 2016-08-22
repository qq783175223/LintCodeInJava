public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public static String minNumber(int[] nums) {
        // Write your code here
        
        //为了后面能使用Arrays.sort(T[],Comparetor)必须将int数组转成Integer数组
        //但是这样就多开了一段空间,空间复杂度变成了O(N)
        Integer[] NUMs=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            NUMs[i]=nums[i];
        }
        Arrays.sort(NUMs,new myComparetor());
        String result="";
        for(int i=0;i<NUMs.length;i++){
            result +=NUMs[i];
        }
        //删除首字符是‘0’
        while(result.charAt(0)=='0'){
            //如果只剩一个‘0’了,则要返回结果
            if(result.length()>1){
                result=result.substring(1);
            }else{
                break;
            }
        }
        return result;
    }
}
class myComparetor implements Comparator<Integer>{

	@Override
	public int compare(Integer a, Integer b) {
		// TODO Auto-generated method stub
        char[] charA=(a+"").toCharArray();
        char[] charB=(b+"").toCharArray();
        int lenA=charA.length;
        int lenB=charB.length;
        int i=0,j=0;
        while(true){
            if(charA[i]>charB[j]){
                return 1;
            }else if(charA[i]<charB[j]){
                return -1;
            }else{
                i++;j++;
                if(i==lenA&&j==lenB){
                    return 0;
                }
                if(i==lenA){
                    i--;
                }
                if(j==lenB){
                    j--;
                }
            }
        }
	}
}