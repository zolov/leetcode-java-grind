package ru.zolov.linkedlist;

/**
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list
 * ---
 * Definition for singly-linked list
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @author skaiur
 */
public class ReverseLinkedListSolution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[ %d ] -> ".formatted(val);
        }
    }
    /*
        0.  0 -> 1 -> 2 ->  3 -> null           | current = 0(head); prev = null; next = null
        1.         [0] -> 1 -> 2 ->  3 -> null  | current = 0; next = current.next(1); current.next = prev(null); prev = current(0); current = next(1)
        2.  null <- 0 <- [1] -> 2 -> 3 -> null  | current = 1; next = current.next(2); current.next = prev(0); prev = current(1); current = next(2)
        3.  null <- 0 <- 1 <- [2] ->  3 -> null | current = 2; next = current.next(3); current.next = prev(1); prev = current(2); current = next(3)
        4.  null <- 0 <- 1 <- 2 <- [3] -> null  | current = 3; next = current.next(null); current.next = prev(2); prev = current(3); current = next(null)
        5.  null <- 0 <- 1 <- 2 <- 3 - [null]   |
     */

    public static ListNode reverseList(ListNode head) {
        // Объявляем переменные для Текущего узла, Предыдущего узла, Следующего Текущего узла
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        // Пока Текущий узел не равен null
        while (current != null) {
            // Сохраняем ссылку на следующий узел от текущего. Для того чтобы сместить туда current для следующей итерации
            next = current.next;
            // Меняем ссылку у следующего узла на предыдущий (делаем инверсию связи)
            current.next = previous;

            // Сохраняем в переменную предыдущего узла ссылку на текущий узел
            previous = current;
            // Сохраняем в переменную текущего узла ссылку на следующий узел
            current = next;
        }

        // [ 0 ] <- [ 1 ] <- [ 2 ] <- [ 3 ] _ null
        //                              ^       ^
        //                            prev    curr
        // Возвращаем предыдущий узел как корневой
        // В current узле находится null
        return previous;
    }

    //  0 -> 1 -> 2 ->  3 -> null
    public static void main(String[] args) {
        var listNode = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null))));
        System.out.println(nodeToString(listNode));
        System.out.println(nodeToString(reverseList(listNode)));
    }

    public static String nodeToString(ListNode node) {
        var builder = new StringBuilder();
        var current = node;
        while (current != null) {
            builder.append("[ %s ] ".formatted(current.val));
            current = current.next;
            if (current != null) {
                builder.append(" -> ");
            }
        }

        return builder.toString();
    }
}
