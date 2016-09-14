class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        Integer[] columnIndex=new Integer[n];
        for(int i=0;i<columnIndex.length;i++){
            columnIndex[i]=i;
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
        ArrayList<Integer[]> allPermu= new ArrayList<Integer[]>();
        permutation(columnIndex,0,allPermu);
        
        for(int i=0;i<allPermu.size();i++){
            ans.add(changePermutationToQueen(allPermu.get(i)));
        }
        return ans;
    }
    //将满足条件的排列转换成要求输出的格式
    private ArrayList<String> changePermutationToQueen(Integer[] array){
        ArrayList<String> oneOfAns=new ArrayList<String>();
        for(int row=0;row<array.length;row++){
            String str="";
            for(int col=0;col<array.length;col++){
                if(array[row]==col){
                    str +="Q";
                }else{
                    str +=".";
                }
            }
            oneOfAns.add(str);
        }
        return oneOfAns;
    }
    //求出所有满足i-j=columnIndex[i]-columnIndex[j]或者j-i=columnIndex[i]-columnIndex[j]的排列
    private void permutation(Integer[] fatherArray,int start,ArrayList<Integer[]> ans){
        if(start==fatherArray.length-1&&!isCommonLine(fatherArray)){
            ans.add(fatherArray);
            return;
        }
        for(int i=start;i<fatherArray.length;i++){
            Integer[] oneOfAns=swap(fatherArray,start,i);
            permutation(oneOfAns,start+1,ans);
        }
    }
    //判断皇后是否在同一斜线
    private boolean isCommonLine(Integer[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(i-j==arr[i]-arr[j]||j-i==arr[i]-arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //交换并返回一个新的数组
    private Integer[] swap(Integer[] arr,int a,int b){
        Integer[] result=Arrays.copyOf(arr,arr.length);
        Integer tmp=result[a];
        result[a]=result[b];
        result[b]=tmp;
        return result;
    }
};