<h2><a href="https://leetcode.com/problems/max-consecutive-ones-iii">Max Consecutive Ones III</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a binary array <code>nums</code> and an integer <code>k</code>, return <em>the maximum number of consecutive </em><code>1</code><em>&#39;s in the array if you can flip at most</em> <code>k</code> <code>0</code>&#39;s.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> [1,1,1,0,0,<u><strong>1</strong>,1,1,1,1,<strong>1</strong></u>]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
<strong>Output:</strong> 10
<strong>Explanation:</strong> [0,0,<u>1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1</u>,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either 0 or 1.</li>
	<li><code>0 &lt;= k &lt;= nums.length</code></li>
</ul>

# 🔢 Max Consecutive Ones III | LeetCode 1004

![Java](https://img.shields.io/badge/Java-Solution-blue)
![Sliding Window](https://img.shields.io/badge/Sliding%20Window-green)
![Time Complexity](https://img.shields.io/badge/Time-O(n)-green)
![Space](https://img.shields.io/badge/Space-O(1)-yellow)

## Problem Statement

Given a binary array `nums` and an integer `k`, return the **maximum number of consecutive 1's** you can achieve by flipping **at most `k` 0's**.

---

## Theory of the Method: Sliding Window Technique

### What is Sliding Window?
Sliding Window is an optimization technique that maintains a **dynamic subarray** (window) using two pointers — `left` and `right`.

- **Expand** the window by moving `right`.
- **Shrink** the window by moving `left` when the window becomes **invalid**.

### Why Sliding Window is Perfect Here?
We need the **longest valid subarray** that contains **at most `k` zeros**.  
Sliding Window efficiently finds the maximum length valid window in linear time.

---

## Intuition You Should Think Of

**Core Intuition:**

> "I have a budget of `k` flips. I want the longest continuous segment I can cover using this budget."

**Think like this:**
- Treat `0`s as "costly" elements that require a flip.
- Expand your window as much as possible.
- When you run out of flips (`zeros > k`), remove elements from the start (move `left` pointer) to "refund" a flip.
- Always keep track of the longest valid window seen so far.

**Real-life Analogy**:  
You are driving on a road with potholes (0s). You have `k` repair kits. What's the longest stretch of road you can make fully usable?

This intuition leads directly to the **Sliding Window** solution.

---

## Java Solution

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int zerosCount = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Expand window
            if (nums[right] == 0) {
                zerosCount++;
            }
            
            // Shrink window if invalid (more than k zeros)
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
