package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.LinkListUtil;
import com.lvhaifeng.leetcode.utils.ListNode;

/**
 * @Description 合并K个升序链表
 * @Author haifeng.lv
 * @Date 2021/9/2 17:20
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode[] listNode = {LinkListUtil.arrayToLinkList(new int[]{1, 4, 5}), LinkListUtil.arrayToLinkList(new int[]{1, 3, 4}),
                LinkListUtil.arrayToLinkList(new int[]{2, 6})};
        ListNode node = mergeKLists(listNode);
        LinkListUtil.printLinkList(node);
    }

    /**
     * 归并 + 双指针
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        while ((lists.length + 1) / 2 > 1) {
            int left = 0, right = lists.length - 1;
            ListNode[] temp = new ListNode[(lists.length + 1) / 2];
            int index = 0;
            while (left < right) {
                temp[index++] = merge(lists[left], lists[right]);
                left++;
                right--;
            }
            if (left == right) {
                temp[index] = lists[left];
            }

            lists = temp;
        }

        return merge(lists[0], lists[1]);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
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

        temp.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
