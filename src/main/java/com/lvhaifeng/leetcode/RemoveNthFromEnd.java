package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.LinkListUtil;
import com.lvhaifeng.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/9/1 17:22
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {1, 2};
        ListNode listNode = LinkListUtil.arrayToLinkList(nums);

        ListNode node = removeNthFromEnd3(listNode, 5);
        LinkListUtil.printLinkList(node);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = LinkListUtil.length(head);
        ListNode node = new ListNode();
        node.next = head;

        int index = 0;
        ListNode temp = node;
        while (true) {
            if (index == length - n) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                } else {
                    temp.next = null;
                }
                break;
            }
            temp = temp.next;
            index++;
        }

        return node.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next = head;

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        cur = stack.peek();
        cur.next = cur.next.next;
        return node.next;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode first = head;
        ListNode second = node;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return node.next;
    }
}
