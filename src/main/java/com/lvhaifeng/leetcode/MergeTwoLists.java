package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.LinkListUtil;
import com.lvhaifeng.leetcode.utils.ListNode;

/**
 * @Description
 * @Author haifeng.lv
 * @Date 2021/9/2 11:02
 */
public class MergeTwoLists {
    public static void main(String[] args) {
//        int[] l1 = {1, 2, 4}, l2 = {1, 3, 4};
        int[] l1 = {}, l2 = {0};
        ListNode listNode = mergeTwoLists(LinkListUtil.arrayToLinkList(l1), LinkListUtil.arrayToLinkList(l2));
        LinkListUtil.printLinkList(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return head.next;
    }
}
