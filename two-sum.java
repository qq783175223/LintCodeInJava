public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    //搞这么复杂是为了将最暴力的两层循环时间复杂度O(N^2)降到O(NlogN)
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int len=numbers.length;
        int[] result=new int[2];
        //map存放numbers数组的“值=索引下标”这样的键值对
        Map<MyInteger,Integer> map=new HashMap<MyInteger,Integer>();
        //由于map中不能存放相同的int值,即使是两个相同值的Integer对象也不行(new Integer(相同的值)).
        //所以自定义了我自己的类型存放numbers数组的值
        MyInteger[] myInteger=new MyInteger[len];
        for(int i=0;i<len;i++){
        	myInteger[i]=new MyInteger(numbers[i]);
            map.put(myInteger[i],i+1);
        }
        //排序是为了后面方便使用两端指针
        Arrays.sort(myInteger);
        //两端指针前后开始遍历
        for(int i=0,j=len-1;i<j;){
            if(myInteger[i].getNumber()+myInteger[j].getNumber()>target){
                j--;
            }else if(myInteger[i].getNumber()+myInteger[j].getNumber()<target){
                i++;
            }else{
                result[0]=Math.min(map.get(myInteger[i]),map.get(myInteger[j]));
                result[1]=Math.max(map.get(myInteger[i]),map.get(myInteger[j]));
                break;
            }
        }
        return result;
    }
}

//为了对象可比较必须实现Comparable接口
class MyInteger implements Comparable<MyInteger>{
    private Integer number;
    public Integer getNumber() {
		return number;
	}

	public MyInteger(Integer number){
        this.number=number;
    }
    
	@Override
	public int compareTo(MyInteger o) {
		// TODO Auto-generated method stub
		return this.number.compareTo(o.number);
	}
}