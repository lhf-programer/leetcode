package com.lvhaifeng.leetcode.utils;

import java.util.Stack;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/9/1 17:25
 */
public class LinkListUtil {
    public static ListNode arrayToLinkList(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        ListNode listNode = new ListNode(nums[0]);
        ListNode temp = listNode;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return listNode;
    }

    public static void printLinkList(ListNode listNode) {
        if (null == listNode) {
            return;
        }

        ListNode temp = listNode;

        while (temp.next != null) {
            System.out.printf(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp.next != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        head = temp;
        while (!stack.empty()) {
            head.next = new ListNode(stack.pop());
            head = head.next;
        }

        return temp;
    }

    public static int length(ListNode listNode) {
        if (null == listNode) {
            return 0;
        }

        int length = 1;
        ListNode temp = listNode;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        return length;
    }
}
