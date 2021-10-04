import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestSolution {

    @ParameterizedTest
    @MethodSource("testScenariosProvider")
    public void testScenarios(ListNode l1, ListNode l2, ListNode expectedSolution) {
        assertLinkedListsEquals(expectedSolution, new Solution().mergeTwoLists(
                l1,
                l2
        ));

    }

    private static Stream<Arguments> testScenariosProvider() {
        return Stream.of(
                Arguments.arguments(arrayToLinkedList(new int[]{1, 2, 4}),
                        arrayToLinkedList(new int[]{1, 3, 4}),
                        arrayToLinkedList(new int[]{1, 1, 2, 3, 4, 4})),

                Arguments.arguments(
                        arrayToLinkedList(new int[]{3}),
                        arrayToLinkedList(new int[]{1, 2, 5, 8}),
                        arrayToLinkedList(new int[]{1, 2, 3, 5, 8})),

                Arguments.arguments(arrayToLinkedList(new int[]{7}),
                        arrayToLinkedList(new int[]{1, 2, 5}),
                        arrayToLinkedList(new int[]{1, 2, 5, 7})),

                Arguments.arguments(arrayToLinkedList(new int[]{4, 7, 12}),
                        arrayToLinkedList(new int[]{1}),
                        arrayToLinkedList(new int[]{1, 4, 7, 12})),

                Arguments.arguments(arrayToLinkedList(new int[]{6, 7, 12,13,14,156}),
                        arrayToLinkedList(new int[]{1}),
                        arrayToLinkedList(new int[]{1, 6, 7, 12, 13, 14, 156})),

                Arguments.arguments(arrayToLinkedList(new int[]{6}),
                        arrayToLinkedList(new int[]{1,2,3,4,17,19,400}),
                        arrayToLinkedList(new int[]{1, 2, 3, 4, 6, 17, 19, 400}))
        );
    }

    private void assertLinkedListsEquals(ListNode l1, ListNode l2) {
        do {
            Assertions.assertNotNull(l1);
            Assertions.assertNotNull(l2);
            Assertions.assertEquals(l1.val, l2.val);

            l1 = l1.next;
            l2 = l2.next;
        } while (l1.next != null || l2.next != null);
    }

    private static ListNode arrayToLinkedList(int[] nums) {
        ListNode head = null;
        ListNode currentNode = null;

        for (int i : nums) {
            if (head == null) {
                head = currentNode = new ListNode(i);
            } else {
                currentNode.next = new ListNode(i);
                currentNode = currentNode.next;
            }
        }

        return head;
    }

}
