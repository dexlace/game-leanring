//
//
//public class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//class Solution {
//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//        // 1. 计算链表长度 和获取尾部节点
//        ListNode tmp = head;
//        ListNode tail = null;
//        int len = 0;
//        while (tmp != null) {
//            len++;
//            tail = tmp;
//            tmp = tmp.next;
//        }
//        // 2.如果k是长度的整数倍将直接返回即可
//        if (k % len == 0) {
//            return head;
//        }
//
//
//        // 3 这里可以大胆的把tail和head连起来,成环了，以后的工作只需要断开即可
//        tail.next = head;
//        // 4. 假如k大于len 且不是整数倍 比如len=3 k=5
//        // 312 231 123 312 231
//        // 头部节点落在len-k%len+1
//        // 需要找到头部节点的前驱 即len-k%len pre
//        // 先res=pre.next
//        // pre.next=null;
//        // 把tail和head连上即可
//        //  return res
//        if (k > len) {
//            int prePosition = len - k % len;
//            ListNode pre = head;
//            prePosition--;
//            while (prePosition > 0) {
//                pre = pre.next;
//                prePosition--;
//            }
//            // 这里已经得到了pre
//            ListNode res = pre.next;
//            pre.next = null;
//            return res;
//        }
//
//        // 5.假如k小于len，那么将需要在倒数第k个和倒数第k+1个节点间断开 我们需要找到第k+1个节点
//        // 快指针到达tail的位置后  即倒数第一个 而慢指针需要走到倒数第k+1个，所以慢指针需要比快指针慢k个节点
//        // 先让快指针多走k步
//        ListNode fast = head;
//        ListNode slow = head;
//        int gap = k;
//        while (gap-- > 0) {
//            fast = fast.next;
//        }
//        // 此时前进
//        while (fast != tail) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        // 先缓存slow.next,然后断开即可
//        ListNode result = slow.next;
//        slow.next = null;
//        return result;
//
//    }
//}
