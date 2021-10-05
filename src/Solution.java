class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //this is definitely something that could be done in linear time.
        if (l1 == null) return l2; //if l2 is also null then it is fine to return null
        if (l2 == null) return l1;

        ListNode mergedListHead = null;
        ListNode mergedList = null;
        /*
            find the larger list
            and find the smaller list

            walk through the larger list:
                while the current number is less or equal to the current number in the smaller list:
                    add that number to the new list
                iterate the smaller list and it to the new list

         */

        do {
            //are the numbers equal? Add both, iterate both lists
            if (l1 == null || l2 == null) {
                ListNode nodeToIterate = l1;

                if (l2 != null) {
                    nodeToIterate = l2;
                }

                mergedList.next = nodeToIterate;
                mergedList = mergedList.next;

                if (l2 != null) {
                    l2 = nodeToIterate.next;
                } else {
                    l1 = nodeToIterate.next;
                }

            } else if (l1.val == l2.val) {
                //iterate both
                ListNode n1 = l1;
                ListNode n2 = l2;

                l1 = l1.next;
                l2 = l2.next;

                if (mergedList == null) {
                    mergedList = n1;
                    mergedList.next = n2;

                    mergedListHead = mergedList;
                    mergedList = mergedList.next;

                } else {
                    mergedList.next = n1;
                    mergedList.next.next = n2;
                    mergedList = mergedList.next.next;
                }

            } else {
                //else is the current number in the larger list smaller than the current number in the smaller list:
                //yes ? add it to the new list and iterate the larger list
                //no ? add current number from smaller list and iterate it
                ListNode nodeToIterate;

                if (l1.val <= l2.val) {
                    nodeToIterate = l1;
                } else {
                    nodeToIterate = l2;
                }

                if (mergedList == null) {
                    mergedList = nodeToIterate;
                    mergedListHead = mergedList;
                } else {
                    mergedList.next = nodeToIterate;
                    mergedList = mergedList.next;
                }

                if (l1.val < l2.val) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }

            }

        } while (l1 != null || l2 != null);


        return mergedListHead;
    }

}