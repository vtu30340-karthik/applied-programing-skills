class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode[] arr = new ListNode[100];
        int i = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            arr[i++] = temp;
        }
        return arr[i / 2];
    }
}