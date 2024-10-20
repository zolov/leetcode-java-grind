package ru.zolov.linkedlist;

/**
 * @author skaiur
 *         Definition for singly-linked list.
 *         public class ListNode {
 *         int val;
 *         ListNode next;
 *         ListNode() {}
 *         ListNode(int val) { this.val = val; }
 *         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *         }
 *         You are given the heads of two sorted linked lists list1 and list2.
 *         Merge the two lists into one sorted linked list and return the head of the new sorted
 *         linked list.
 *         The new list should be made up of nodes from list1 and list2.
 */
public class MergeTwoSortedLinkedListsSolution {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode() {}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "[ %d ] -> ".formatted(val);
		}
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// Создаем фиктивный узел, для того чтобы крепить к нему два исходных списка
		ListNode dummy = new ListNode();
		// Создаем переменную для хранения последнего на данный момент узла списка
		ListNode tail = dummy;

		// Продолжаем, до тех пор пока оба списка не пусты
		while (list1 != null && list2 != null) {
			// Если значение из списка 1 меньше значения из списка 2
			if (list1.val < list2.val) {
				// то меняем следующий узел у хвоста на узел из списка один
				tail.next = list1;
				// передвигаем первый лист к следующему элементу
				list1 = list1.next;
			} else {
				// Если значение из списка 1 больше значения из списка 2
				// то меняем следующий узел у хвоста на узел из списка два
				tail.next = list2;
				// передвигаем второй лист к следующему элементу
				list2 = list2.next;
			}
			// передвигаем хвостовой узел чтобы дальше уже к нему крепить следующий элемент
			tail = tail.next;
		}
		// Если в первом списке остались элементы
		if (list1 != null) {
			// то крепим их все к хвостовому узлу
			tail.next = list1;

			// Если во втором списке остались элементы
		} else if (list2 != null) {

			// то крепим их все к хвостовому узлу
			tail.next = list2;
		}

		// возвращаем первый узел прикрепленный к фиктивному узлу
		return dummy.next;
	}

	public static void main(String[] args) {
		var listNode1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
		System.out.println(nodeToString(listNode1));
		var listNode2 = new ListNode(1, new ListNode(3, new ListNode(5, null)));
		System.out.println(nodeToString(listNode2));
		System.out.println(nodeToString(mergeTwoLists(listNode1, listNode2)));
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
