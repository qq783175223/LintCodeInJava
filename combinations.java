public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		List<Integer> fatherList=new ArrayList<Integer>();
		if(n>=1&&n>=k){
		    String[] strArray=new String[n];
		    for(int i=1;i<=n;i++){
		        strArray[i-1]=i+"";
		    }
			combineCore(strArray,k,0,fatherList,ans);
		}
		return ans;
    }
    
    private static void combineCore(String[] strArray, int k,int start,List<Integer> fatherList,List<List<Integer>> ans) {
		if(k==0){
			ans.add(fatherList);
			return;
		}
		for(int i=start;i<strArray.length;i++){
			if(!fatherList.contains(Integer.parseInt(strArray[i]))){
				List<Integer> oneOfAns=new ArrayList<Integer>();
				oneOfAns.addAll(fatherList);
				oneOfAns.add(Integer.parseInt(strArray[i]));
				combineCore(strArray,k-1,i+1,oneOfAns,ans);
			}
		}
    }
}