public class Solution {
    //维护一个最大堆，一个最小堆。
    //最大堆存的是到目前为止较小的那一半数，
    //最小堆存的是到目前为止较大的那一半数
    private PriorityQueue<Integer> minHeap,maxHeap;
    private int elementNum=1;
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        //定义反向比较器
        Comparator<Integer> revCmp=new Comparator<Integer>(){
            public int compare(Integer num1,Integer num2){
                return num2.compareTo(num1);
            }
        };
        int cnt=nums.length;
        minHeap=new PriorityQueue<Integer>(cnt);
        maxHeap=new PriorityQueue<Integer>(cnt,revCmp);
        int ans[]=new int[cnt];
        for(int i=0;i<cnt;i++){
            addNumber(nums[i]);
            ans[i]=getMedian();
        }
        return ans;
    }
    //添加元素到堆
    public void addNumber(Integer value){
        maxHeap.add(value);
        if(elementNum%2==1){//当前元素个数为奇数个,则将当前num元素添加到大顶堆
            if(minHeap.isEmpty()){
                elementNum++;
                return;
            }
            //调整大顶堆、小顶堆。使得任意时刻都是minHeap.peek()>maxHeap.peek()
            if(maxHeap.peek()>minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(maxHeap.poll());
            }
        }else{//当前元素个数为偶数个,则将最大元素添加到小顶堆
            minHeap.add(maxHeap.poll());
        }
        elementNum++;
    }
    //当元素个数是奇数时，大顶堆多一个元素，所以返回maxHeap.peek()
    //当元素个数为偶数时，大小顶堆个数一致，但题目要求是返回前一个数，所以返回maxHeap.peek()
    public int getMedian(){
        return maxHeap.peek();
    }
}