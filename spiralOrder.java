public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here

        List<Integer> list=new ArrayList<Integer>();
        int row=matrix.length;
        if(matrix==null||row==0){
            return list;
        }
        int column=matrix[0].length;
        int columnStart=0;
        int columnEnd=column-1;
        int rowStart=0;
        int rowEnd=row-1;
        int i=0,j=0;
        while(true){
            //向右--->
            while(j<=columnEnd){
                list.add(matrix[i][j]);
                j++;
            }
            j=j-1;//补充多减了一次
            i=i+1;//行数下移
            rowStart++;//每次循环时开始的行数加1
            if(rowStart>rowEnd)
                break;
            //向下
            //  |
            //  |
            //  V
            while(i<=rowEnd){
                list.add(matrix[i][j]);
                i++;
            }
            i=i-1;
            j=j-1;
            columnEnd--;//每次循环时开始的列数减1
            if(columnEnd<columnStart)
                break;
            //向左 <---
            while(j>=columnStart){
                list.add(matrix[i][j]);
                j--;
            }
            j=j+1;
            i=i-1;
            rowEnd--;
            if(rowEnd<rowStart)
                break;
            //向上
            //   ^
            //   |
            while(i>=rowStart){
                list.add(matrix[i][j]);
                i--;
            }
            i=i+1;
            j=j+1;
            columnStart++;
            if(columnStart>columnEnd)
                break;
        }
        return list;
    }
}