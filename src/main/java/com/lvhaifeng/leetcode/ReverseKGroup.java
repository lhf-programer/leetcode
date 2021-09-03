package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.LinkListUtil;
import com.lvhaifeng.leetcode.utils.ListNode;

/**
 * @Description K 个一组翻转链表
 * @Author haifeng.lv
 * @Date 2021/9/3 15:25
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        ListNode listNode = LinkListUtil.arrayToLinkList(list);
        ListNode node = reverseKGroup(listNode, 3);
        LinkListUtil.printLinkList(node);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = LinkListUtil.length(head);
        ListNode node = new ListNode(0, head);

        ListNode temp = node;
        for (int i = 0; i < length / k; i++) {
            temp = swapPairs(temp.next, k);
        }

        return node.next;
    }

    public static ListNode swapPairs(ListNode head, int k) {
        ListNode next;
        ListNode newNode = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            next = temp.next;
            temp.next = newNode.next;
            newNode.next = temp;
            temp = next;
        }

        head = newNode.next;
        return head;
    }
}
