public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length==0||matrix[0].length==0){
            return 0;//matrix等于{}或{{}}是返回0
        }
        int row=matrix.length;
        int column=matrix[0].length;
        int result=0;
        //从右上角开始
        for(int r=0,c=column-1;r<row&&c>=0;r++,c--){
            if(matrix[r][c]==target){
                result++;
            }else if(matrix[r][c]>target){//target小于右上角元素，则说明target在左边
                if(Arrays.binarySearch(matrix[r],0,c,target)>=0)
                    result++;
            }else{//target大于右上角元素，说明target在下边
                for(int i=r+1;i<row;i++){
                    if((matrix[i][c])==target)
                        result++;
                }
            }
        }
        return result;
    }
    
}
