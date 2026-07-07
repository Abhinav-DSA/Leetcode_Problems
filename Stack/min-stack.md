# Min Stack | LeetCode 155

Design a stack that supports `push`, `pop`, `top`, and retrieving the **minimum element in constant time**.

---

## Problem Statement

Design a stack that supports the following operations in **constant time** (O(1)):

- `push(x)` — Push element `x` onto the stack.
- `pop()` — Removes the element on the top of the stack.
- `top()` — Get the top element.
- `getMin()` — Retrieve the minimum element in the stack.

You must implement the `MinStack` class with these methods.

---

## Intuition & How to Think

**Main Challenge**:  
We need to get the minimum element in O(1) time while supporting normal stack operations.

**Best Approach**:  
Instead of using two separate stacks, we store **both the value and the current minimum** in each node.  
This way, every element in the stack knows the minimum value up to that point.

**Key Idea**:
- When pushing a new value, we calculate the new minimum and store it with the value.
- When popping, we simply remove the top node.
- The top node's `min` value always gives us the current minimum.

---

## Java Solution

```java
import java.util.Stack;

class Node {
    int val;
    int min;
    public Node(int v, int m) {
        this.val = v;
        this.min = m;
    }
}

class MinStack {
    Stack<Node> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new Node(value, value));
            return;
        }
        
        Node nodeTop = stack.peek();
        int minTop = nodeTop.min;
        
        if (value < minTop) {
            stack.push(new Node(value, value));
        } else {
            stack.push(new Node(value, minTop));
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().val;
    }
    
    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().min;
    }
}
