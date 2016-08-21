public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        //记录每个元素出现的次数
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(Integer num:nums){
            if(map.get(num)!=null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        //找出出现次数最多的元素
        int frequently=0;
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            if(frequently<(Integer)entry.getValue()){
                frequently=(Integer)entry.getValue();
                result=(Integer)entry.getKey();
            }
        }
        return result;
    }
}