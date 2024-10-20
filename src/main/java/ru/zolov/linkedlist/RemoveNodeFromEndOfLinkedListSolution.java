package ru.zolov.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * You are given the beginning of a linked list head, and an integer n.
 * Remove the nth node from the end of the list and return the beginning of the list.
 *
 * @author skaiur
 */
public class RemoveNodeFromEndOfLinkedListSolution {
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

	// n = 2; 1 -> 2 -> 3 -> [4] -> 5 -> null
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		// Создаем фиктивный узел в начале листа для того чтобы можно было использовать быстрый и
		// медленный указатель
		var dummy = new ListNode(0, head);
		// Левый указатель начинается с фиктивного листа
		var left = dummy;
		// Правый указатель начинается с головы
		var right = head;

		// Пока n больше нуля
		// r: 1 -> 2 -> 3 -> 4 -> 5 -> null
		// ^ ^ ^
		// n: 2 1 0
		while (n > 0) {
			// Двигаем правый указатель к следующему узлу
			right = right.next;
			// уменьшаем N
			n--;
			// Тем самым создавая разрыв между левым и правым указателем для использования быстрого
			// и медленного указателя
		}

		// l: dummy 0
		// r: 3
		// Пока правый указатель не достиг конца листа
		while (right != null) {
			// Перемещаем левый указатель к следующему узлу
			left = left.next;
			// Перемещаем правый указатель к следующему узлу
			right = right.next;
		}

		// Как только правый указатель достиг конца списка
		// левый указатель находится перед узлом который нужно удалить из листа.
		// Меняем ссылки у листа перед удаляемым и после него для удаления узла из листа
		// 3 -> 4 -> 5
		// 3 -> 5
		left.next = left.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println("#1");
		var listNode1 = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
		System.out.println(nodeToString(listNode1));
		System.out.println(nodeToString(removeNthFromEnd(listNode1, 2)));


		System.out.println("#2");
		var listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
				new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, null))))))));
		System.out.println(nodeToString(listNode2));
		System.out.println(nodeToString(removeNthFromEnd(listNode2, 4)));
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
