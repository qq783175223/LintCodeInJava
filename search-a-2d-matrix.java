public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    //两次二分 
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int columnStart=0,columnEnd=matrix.length-1,columnMid=(columnStart+columnEnd)/2;
        if(columnEnd<0)
            return false;
        int rowStart=0,rowEnd=matrix[0].length-1,rowMid=(rowStart+rowEnd)/2;
        while(columnStart<=columnEnd){
            if(matrix[columnMid][0]>target){
                columnEnd=columnMid-1;
                columnMid=(columnStart+columnEnd)/2;
            }else{
                if(matrix[columnMid][rowEnd]>=target){
                    while(rowStart<=rowEnd){
                        if(matrix[columnMid][rowMid]>target){
                            rowEnd=rowMid-1;
                            rowMid=(rowStart+rowEnd)/2;
                        }else if(matrix[columnMid][rowMid]<target){
                            rowStart=rowMid+1;
                            rowMid=(rowStart+rowEnd)/2;
                        }else{
                            return true;
                        }
                    }
                    return false;
                }else{
                   columnStart=columnMid+1;
                   columnMid=(columnEnd+columnStart)/2;
                }
            }
        }
        return false;
    }
}



public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    //从右上角开始，每次去除一行或者一列
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int columnStart=0,columnEnd=matrix.length-1;
        if(columnEnd<0)
            return false;
        int rowStart=0,rowEnd=matrix[0].length-1;
        while(columnStart<=columnEnd&&rowEnd>=0){
            if(matrix[columnStart][rowEnd]<target){
                columnStart++;
            }else if(matrix[columnStart][rowEnd]>target){
                rowEnd--;
            }else{
                return true;
            }
        }
        return false;
    }    
}
