package com.lvhaifeng.leetcode;

import com.lvhaifeng.leetcode.utils.LinkListUtil;
import com.lvhaifeng.leetcode.utils.ListNode;

/**
 * @Description 两两交换链表中的节点
 * @Author haifeng.lv
 * @Date 2021/9/3 10:09
 */
public class SwapPairs {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4};
        ListNode listNode = LinkListUtil.arrayToLinkList(list);
        ListNode node = swapPairs(listNode);
        LinkListUtil.printLinkList(node);
    }

    /**
     * 交换思维
     *
     * 程序结束点: 节点为空 或 节点的下个节点为空（一个节点没有必要交换了）
     * 交换的核心必要操作
     * 必须要有一个新的节点
     * 新节点必定是 头节点的 next
     * 新节点的 next必定是头节点
     *
     * 直接交换会出现问题
     * 新节点的 next是头节点 头节点的 next又是新节点
     * 所以我们必须将头节点的 next改变（也是方法递归回来之后最终的结果）
     *
     * 核心思想: 由大逻辑拆成小逻辑递推
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode newNode = head.next;
        head.next = swapPairs(newNode.next);
        newNode.next = head;

        return newNode;
    }
}
