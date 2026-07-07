class Node{
    int val;
    int min;
    public Node(int v,int m){
        this.val=v;
        this.min=m;
    }
}

class MinStack {
    Stack<Node> stack;
    public MinStack() {
        stack =new Stack<>();
  }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
            return;
        }
        Node nodeTop=stack.peek();
        int minTop=nodeTop.min;
        if(val< minTop){
            stack.push(new Node(val,val));
        }else{
            stack.push(new Node(val,minTop));
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()){
            return-1;
        }
        Node nodeTop=stack.peek();
        return nodeTop.val;
        
    }
    
    public int getMin() {
        Node node=stack.peek();
        return node.min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
