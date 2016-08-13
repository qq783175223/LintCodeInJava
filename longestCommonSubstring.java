public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * 
     * 
     * 2、最长公共子串

其实这是一个序贯决策问题，可以用动态规划来求解。我们采用一个二维矩阵来记录中间的结果。这个二维矩阵怎么构造呢？直接举个例子吧："bab"和"caba"(当然我们现在一眼就可以看出来最长公共子串是"ba"或"ab")

　　 b　　a　　b

c　　0　　0　　0

a　　0　　1　　0

b　　1　　0　　1

a　　0　　1　　0

我们看矩阵的斜对角线最长的那个就能找出最长公共子串。

不过在二维矩阵上找最长的由1组成的斜对角线也是件麻烦费时的事，下面改进：当要在矩阵是填1时让它等于其左上角元素加1。

　　 b　　a　　b

c　　0　　0　　0

a　　0　　1　　0

b　　1　　0　　2

a　　0　　2　　0

这样矩阵中的最大元素就是 最长公共子串的长度。

在构造这个二维矩阵的过程中由于得出矩阵的某一行后其上一行就没用了，所以实际上在程序中可以用一维数组来代替这个矩阵。
     * 
     * 
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int m=a.length,n=b.length;
        int c[][]=new int[m+1][n+1];
        int max=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a[i-1]==b[j-1]){
                	c[i][j]=c[i-1][j-1]+1;//c[i][j]表示字符串A长度为i,字符串B长度为j时的LCS
                	if(c[i][j]>max){
                		max=c[i][j];
                	}
                }
            }
        }
        return max;
    }
}