class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //this is definitely something that could be done in linear time and constant space.
        ListNode mergedList = null;
        ListNode mergedListHead = null;
        /*
            find the larger list
            and find the smaller list

            walk through the larger list:
                while the current number is less or equal to the current number in the smaller list:
                    add that number to the new list
                iterate the smaller list and it to the new list

         */

        ListNode smallerList = l1;
        ListNode largerList = l2;
        int smallerSize = countListSize(smallerList);
        int largerSize = countListSize(largerList);

        if (largerSize < smallerSize) {
            largerList = smallerList;
            smallerList = l2;
        }

        ListNode currentLargerListNode = largerList;
        ListNode currentSmallerListNode = smallerList;

        do {
            //are the numbers equal? Add both, iterate both lists
            if (currentSmallerListNode == null) {
                //add the rest of the larger list
                mergedList.next = currentLargerListNode;
                currentLargerListNode = currentLargerListNode.next;
                mergedList = mergedList.next;
            } else if (currentLargerListNode == null) {
                //add the rest of the larger list
                mergedList.next = currentSmallerListNode;
                currentSmallerListNode = currentSmallerListNode.next;
                mergedList = mergedList.next;
            } else if (currentLargerListNode.val == currentSmallerListNode.val) {
                //iterate both
                ListNode n1 = currentLargerListNode;
                ListNode n2 = currentSmallerListNode;

                currentLargerListNode = currentLargerListNode.next;
                currentSmallerListNode = currentSmallerListNode.next;

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
                if (currentLargerListNode.val < currentSmallerListNode.val) {
                    if (mergedList == null) {
                        mergedList = currentLargerListNode;
                        mergedListHead = mergedList;
                    } else {
                        mergedList.next = currentLargerListNode;
                        mergedList = mergedList.next;
                    }
                    currentLargerListNode = currentLargerListNode.next;
                } else {
                    if (mergedList == null) {
                        mergedList = currentSmallerListNode;
                        mergedListHead = mergedList;
                    } else {
                        mergedList.next = currentSmallerListNode;
                        mergedList = mergedList.next;
                    }
                    currentSmallerListNode = currentSmallerListNode.next;
                }

            }

        } while (currentLargerListNode != null || currentSmallerListNode != null);


        return mergedListHead;
    }

    private int countListSize(ListNode node) {
        int count = 0;

        do {
            count++;
            node = node.next;
        } while (node != null);

        return count;
    }
}