/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
package com.zea7ot.lc.lvl2.lc0160;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproachTwoPointers {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        
        while(curA != curB){
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }
        
        return curA;
    }
}