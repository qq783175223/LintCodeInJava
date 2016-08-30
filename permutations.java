class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    //递归
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> oneOfAns=new ArrayList<Integer>();
        if(nums!=null){
            permuteByRecursively(rst,nums,oneOfAns);
        }
        return rst;
    }
    
    private void permuteByRecursively(ArrayList<ArrayList<Integer>> rst,ArrayList<Integer> nums,ArrayList<Integer> oneOfAns){
        if(oneOfAns.size()==nums.size()){
            rst.add(oneOfAns);
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(!oneOfAns.contains(nums.get(i))){
                ArrayList<Integer> fatherList=new ArrayList<Integer>();
                fatherList.addAll(oneOfAns);
                fatherList.add(nums.get(i));
                permuteByRecursively(rst,nums,fatherList);
            }
        }
    }
}
