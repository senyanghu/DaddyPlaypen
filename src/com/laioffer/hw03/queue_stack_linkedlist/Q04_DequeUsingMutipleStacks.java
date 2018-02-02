package com.laioffer.hw03.queue_stack_linkedlist;

// Systematic Thinking
// API - left.add(), left.remove(), right.add(), right.remove()
// 相当于两个stack背靠背   (stack 1) _________] VS [_________ (stack 2)
// method 1: we can only use two stacks to simulate
// left.add(): stack1.push(); O(1)
// left.remove(): case1: if stack1 is not empty, call stack1.pop(); O(1)
//                case2: if stack1 empty(), move all elements from stack2 to stack1 and call stack1.pop(); O(n)
// right.add(): stack2.push();
// right.remove(): case1: if stack2 is not empty, call stack2.pop(); O(1)
//                 case2: if stack2 empty(), move all elements from stack1 to stack2 and call stack2.pop(); O(n)

// method 2: how to optimize the time complexity
// _________] VS [ 5 6 7 8
// 3rd stack: [5 6 7 8
// ____5, 6] VS [ 7 8____
// In order to optimize the time complexity, we use 3rd stack, as the buffer, in order to balance the number of 
// elements in S1 and S2, such that S1 size roughly equal to S2 size.

public class Q04_DequeUsingMutipleStacks {

}
