package com.lrwatcl;

/**
 * @ClassName: AddTwoNumbers
 * @Description: TODO
 * @author: linrongwu
 * @date: 2021年02月11日 下午10:13
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
* 执行用时: 2 ms
* 内存消耗: 38.8 MB
* */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int before=0;
        ListNode l = new ListNode();
        ListNode tempL = l;
        ListNode beforeList = tempL;
        while(null!=temp1 && null!=temp2){
            beforeList = tempL;
            int data = temp1.val+temp2.val+before;
            tempL.val = data%10;
            before = data/10;
            tempL.next = new ListNode();
            tempL = tempL.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(null!=temp2){
            beforeList = tempL;
            int data = temp2.val+before;
            tempL.val = data%10;
            before = data/10;
            tempL.next = new ListNode();
            tempL = tempL.next;
            temp2 = temp2.next;
        }
        while(null!=temp1){
            beforeList = tempL;
            int data = temp1.val+before;
            tempL.val = data%10;
            before = data/10;
            tempL.next = new ListNode();
            tempL = tempL.next;
            temp1 = temp1.next;
        }
        if(before!=0){
            tempL.val = before;
        }else{
            beforeList.next=null;
        }
        return l;
    }

    public static ListNode createList(int[] nums){
        ListNode l = new ListNode();
        ListNode tempL = l;
        ListNode before = tempL;
        for(Integer integer:nums){
            before=tempL;
            tempL.val = integer;
            tempL.next = new ListNode();
            tempL = tempL.next;

        }
        before.next=null;
        return l;
    }
    public static void printList(ListNode data){
        while(null!=data){
            System.out.print(data.val);
            data = data.next;
        }
    }

    public static void main(String[] args) {
        int[] one={2,4,9};
        int[] two={5,6,4,9};
        ListNode listNode1 = AddTwoNumbers.createList(one);
        printList(listNode1);
        System.out.println();
        ListNode listNode2 = AddTwoNumbers.createList(two);
        printList(listNode2);
        System.out.println();
        printList(new AddTwoNumbers().addTwoNumbers(listNode1,listNode2));
    }
}
