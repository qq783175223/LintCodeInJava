public class MinStack {
    Stack<Integer> stack=null;
    Stack<Integer> minStack=null;
    public MinStack() {
        // do initialize if necessary
        stack=new Stack<Integer>();
        minStack=new Stack<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(number<=minStack.peek()){
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
