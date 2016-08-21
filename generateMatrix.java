public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int result[][]=new int[n][n];
        int rowStart=0,rowEnd=n-1;
        int columnStart=0,columnEnd=n-1;
        int i=0,j=0,count=1,total=n*n;;
        while(true){
            while(j<=columnEnd){
                result[i][j++]=count++;
            }
            if(count>total){
                break;
            }
            j--;
            rowStart++;
            i++;
            while(i<=rowEnd){
                result[i++][j]=count++;
            }
            if(count>total){
                break;
            }
            i--;
            columnEnd--;
            j--;
            while(j>=columnStart){
                result[i][j--]=count++;
            }
            if(count>total){
                break;
            }
            j++;
            rowEnd--;
            i--;
            while(i>=rowStart){
                result[i--][j]=count++;
            }
            if(count>total){
                break;
            }
            i++;
            columnStart++;
            j++;
        }
        return result;
    }
}