//Given the head of a singly linked list where elements are sorted in ascending 
//order, convert it to a height balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
//n which the depth of the two subtrees of every node never differ by more than 1.
// 
//
// 
// Example 1: 
//
// 
//Input: head = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the 
//shown height balanced BST.
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [0]
//Output: [0]
// 
//
// Example 4: 
//
// 
//Input: head = [1,3]
//Output: [3,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in head is in the range [0, 2 * 104]. 
// -10^5 <= Node.val <= 10^5 
// 
// Related Topics Linked List Depth-first Search 
// 👍 2370 👎 90


package q.q109;

import dataStructure.ListNode;
import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
  public static void main(String[] args) {
    Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode() {}
   * TreeNode(int val) { this.val = val; }
   * TreeNode(int val, TreeNode left, TreeNode right) {
   * this.val = val;
   * this.left = left;
   * this.right = right;
   * }
   * }
   */
  class Solution {
    public TreeNode sortedListToBST(ListNode head) {

      if (head == null) return null;

      if (head.next == null) return new TreeNode(head.val);

      ListNode mid = mid(head);

      TreeNode node = new TreeNode(mid.val);
      node.left = sortedListToBST(head);
      node.right = sortedListToBST(mid.next);

      return node;
    }

    ListNode mid(ListNode head){
      if (head == null) return null;

      ListNode dum = new ListNode();
      dum.next = head;
      ListNode fast = dum, slow = dum;

      while (fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
      }

      ListNode next = slow.next;
      slow.next = null;
      return next;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}