public class Solution {
    public long result;
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        mergeSort(A,0,A.length-1);
        return result;
    }
    public void mergeSort(int[] array,int begin,int end){
        if(begin<end){
            int mid=(begin+end)/2;
            mergeSort(array,begin,mid);
            mergeSort(array,mid+1,end);
            merge(array,begin,mid,end);
        }
    }
    public void merge(int[] array,int beginIndexL,int endIndexL,int endIndexR){
        int beginIndexR=endIndexL+1;
        int lengthL=endIndexL-beginIndexL+1;
        int lengthR=endIndexR-endIndexL;
        int L[]=new int[lengthL];
        int R[]=new int[lengthR];
        int i,j,k;
        for(i=0,k=beginIndexL;i<lengthL;i++,k++){
            L[i]=array[k];
        }
        for(i=0,k=beginIndexR;i<lengthR;i++,k++){
            R[i]=array[k];
        }
        for(i=0,j=0,k=beginIndexL;i<lengthL&&j<lengthR;k++){
            if(L[i]>R[j]){
                array[k]=R[j++];
                result +=lengthL-i;//当前位置L[i]的值大于R[j],那么L[i]后面的数肯定也大于R[j],所以result +=lengthL-i
            }else{
                array[k]=L[i++];
            }
        }
        if(i<lengthL){
            for(;i<lengthL;k++){
                array[k]=L[i++];
            }
        }
        if(j<lengthR){
            for(;j<lengthR;k++){
                array[k]=R[j++];
            }
        }
    }
}