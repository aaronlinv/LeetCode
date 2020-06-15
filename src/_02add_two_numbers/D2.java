package _02add_two_numbers;

import java.nio.file.Path;

/**
 * 注意点：
 * 1.进位
 * 2.元素为0
 */
public class D2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        // node1.next = new ListNode(0);
        ListNode node2 = new ListNode(0);
        node2.next = null;
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(node1, node2);


        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = null;
        // 上一个节点 
        ListNode lastNode = null;

        // 进位
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;


            ListNode curNode = new ListNode();

            // 当前位
            int curNum = x + y + t;

            int i = curNum % 10;
            curNode.val = i;
            // 重置t
            t = 0;

            if (headNode == null) {
                headNode = curNode;
            } else {
                lastNode.next = curNode;
            }
            lastNode = curNode;
            t = curNum / 10;

            // 移动指针
            if (l1 != null) {
                l1 = l1.next;

            }
            if (l2 != null) {
                l2 = l2.next;

            }
        }
        // next 默认为null

        return headNode;
    }
}

/**
 * 思路错误，测试数据超过long范围
 * 1560 / 1563 个通过测试用例
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = getNum(l1) + getNum(l2);
        return toNode(sum);
    }

    public long getNum(ListNode node) {
        long sum = 0;
        long n = 1;
        while (true) {
            if (node == null) {
                break;
            }
            sum += (node.val * n);
            n *= 10;
            node = node.next;
        }
        return sum;

    }

    public ListNode toNode(long num) {
        // 头节点
        ListNode nodeHead = null;
        ListNode node = null;
        int t = 0;

        // 如果是0会直接跳过
        while (num > 0) {
            // 创建节点
            if (nodeHead == null) {
                node = new ListNode();
                nodeHead = node;
            } else {
                ListNode newNode = new ListNode();
                node.next = newNode;
                node = newNode;
            }

            t = (int) (num % 10);
            num /= 10;

            node.val = t;
        }
        // 为0的情况
        if (node == null) {
            return new ListNode();
        }

        node.next = null;
        return nodeHead;
    }
}