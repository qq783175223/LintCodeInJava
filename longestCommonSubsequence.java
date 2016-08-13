public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     * 网址：http://blog.csdn.net/yysdsyl/article/details/4226630/
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        char[] x=A.toCharArray();
        char[] y=B.toCharArray();
        int m=x.length;
        int n=y.length;
        int c[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x[i-1]==y[j-1]){
                    c[i][j]=c[i-1][j-1]+1;//c[i][j]记录两序列分别长为i和j时的最长子序列
                }else{
                    c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
                }
            }
        }
        return c[m][n];
    }
    
    
    
    
    
    //暴力递归会超时
    public int serach(char[] a,char[] b,int indexA,int indexB){
        
        if(indexA<0||indexB<0){
            return 0;
        }
        
        if(a[indexA]==b[indexB]){
            return serach(a,b,indexA-1,indexB-1)+1;
        }else{
            return Math.max(serach(a,b,indexA-1,indexB),serach(a,b,indexA,indexB-1));
        }
    }
}
