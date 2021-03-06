package Challenge052020

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
 *
 * Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 *
 */
class Question16 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  object Solution {

    def oddEvenList(head: ListNode): ListNode = {
      if (head == null || head.next == null) head
      else {
        val evenListHead = head.next
        def reLinkList(odd: ListNode, even: ListNode): Unit = {
          if (even == null || even.next == null) odd.next = evenListHead
          else {
            odd.next = even.next
            even.next = odd.next.next
            reLinkList(odd.next, even.next)
          }
        }
        reLinkList(head, evenListHead)
        head
      }
    }
  }

}
