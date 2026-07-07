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
We need to get the minimum element in O(1) time while also supporting normal stack operations.

**Naive Approach** (Not Good):  
Keeping a sorted list or using a min-heap would make `push`/`pop` slower than O(1).

**Best Approach**:  
Use **two stacks**:
1. One normal stack to store all elements.
2. Another stack (`minStack`) to keep track of the **current minimum** at each state.

**Key Idea**:
- Whenever we push a new element, we also push the **current minimum** onto the min stack.
- When we pop, we pop from both stacks.
- The top of the min stack always gives us the minimum element in O(1) time.

---

## Java Solution

```java
class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        // Push current minimum to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
