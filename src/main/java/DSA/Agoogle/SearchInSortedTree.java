package DSA.Agoogle;

public class SearchInSortedTree {
    /*Given a perfect binary tree where the values are sorted from top to bottom and left to right and a target value, write function to check if value exists in the perfect binary tree.
    e.g.: 1 / | 2 3 / \ / | 4 10 20 30 target = 5 return false Interviewer wanted a better approach than O(N).
    I assume we can use binary search to achieve O(logN) but could not figure out how it would work.*/


    /*BST Left <root<right  but here its sorted level wise*/

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(20);
        root.right.right = new Node(30);

        System.out.println(search(root, 1));

    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static boolean search(Node root, int target) {
        int n = countNodes(root);
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = getValues(root, mid);
            if (val == target) {
                return true;
            } else if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

//    0 1 2 3 4 5 6
//    00 01 10 11 100 101 110

    private static int getValues(Node root, int index) {
        index = index + 1;
        int msb = Integer.highestOneBit(index);
        Node curr = root;
        while (msb > 1) {
            if ((index & (msb >> 1)) == 0) curr = curr.left;
            else curr = curr.right;
            msb = msb >> 1;
        }
        return curr.val;
    }

    /*Index,Binary,Bits (after MSB),Path
       1,1,(none),Root
       2,10,0,Left
       3,11,1,Right
       4,100,00,"Left, Left"
       5,101,01,"Left, Right"
       6,110,10,"Right, Left"
       7,111,11,"Right, Right"
       */

    private static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
