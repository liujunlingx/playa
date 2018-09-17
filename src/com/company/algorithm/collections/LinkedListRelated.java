package com.company.algorithm.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListRelated {

    /**
     * Node for LinkedList
     */
    static class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //测试反转链表
        testReverse();
    }

    /**
     * 从尾到头打印链表
     */
    public ArrayList<Integer> printListFromTailToHead(Node node) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (node != null) {
            stack.addFirst(node.val);
            node = node.next;
        }
        ArrayList<Integer> result = new ArrayList<>(stack);
        return result;
    }

    /**
     * 找链表倒数第k个元素
     */
    public Node FindKthToTail(Node head, int k) {
        //需要判断链表是否有环
        //需要判断倒数第k个是否存在，不存在时可根据实际场景可以报错或返回链表头。
        Node left = head;
        Node right = head;
        for(int i = 0;i < k;i++){
            if(right == null) return null;
            right = right.next;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }
        return left;
    }

    /**
     * 反转链表
     */
    public static Node reverseList(Node head) {
        if(head == null) return null;
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        head.next = null;
        while (next != null){
            prev = curr;
            curr = next;
            next = next.next;

            curr.next = prev;
        }
        return curr;

//        method 2: more precise
//        ListNode curr = head;
//        ListNode next = null;
//        ListNode prev = null;
//        while(curr != null){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
    }

    public static void testReverse(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Node head = a;

        System.out.println("origin");
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

        Node newHead = reverseList(a);

        System.out.println("after reverse");

        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
