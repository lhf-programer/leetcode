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
        return swapPairs(head, length, k);
    }

    /**
     * 与两个节点交换的区别在于
     * 你需要记录第一个节点的指向（该方法的 pre）
     *
     * @param head
     * @param length
     * @param k
     * @return
     */
    public static ListNode swapPairs(ListNode head, int length, int k) {
        if (length / k == 0) {
            return head;
        }
        ListNode pre = head;

        ListNode next;
        ListNode newNode = new ListNode(0);
        for (int i = 0; i < k; i++) {
            next = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = next;
        }
        pre.next = swapPairs(head, length - k, k);

        return newNode.next;
    }
}
