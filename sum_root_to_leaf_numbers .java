/*
 * // {Approach 1, 2}
// Time Complexity : O(N) ...... N is total number of elements in tree
// Space Complexity : O(1) ... if we consider stack used for recursion --> O(hight of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 * 
 * 
 * 
/*
Leetcode : https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.
 Test cases are generated so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.


*
*
*/



/*
 * Approach 1 - Using global variable sum
 * 
 * WE pass the root and current to helper functions. When we make the call to root node, the current will be 0.
 * WE pass the current as parameter, and if we declare curr as global, then it will not work as every node needs an update
 * to curr variable.
 * Also, if we change the root calculation in other orders ( example postorder, inorder ), it will not works as the current value is not gettig correctly updated at each node.
 * Below is preorder
 * 
 * // root calculation basically 
 * curr = curr * 10 + root.val;    // calculate the current value for the traversing node
        if(root.left == null && root.right == null){
            sum+= curr;         // we have reached the leaf node, add to the sum
        }
 */


public class sum_root_to_leaf_numbers {
    int sum; // take global variable as sum

    public int sumNumbers(TreeNode root){
        helper(root, 0); //we start from root so we pass the current as 0
        return sum;
    }

    private void helper(TreeNode root, int curr){
        if(root == null) return;

        curr = curr * 10 + root.val;    // calculate the current value for the traversing node
        if(root.left == null && root.right == null){
            sum+= curr;         // we have reached the leaf node, add to the sum
        }
        helper(root.left, curr);    // traverse left    
        helper(root.right, curr);   // traverse right

    }
}


/*
 * 
 * With interchanging lines 55 and 56.
 * 
 * When we do summation before update on curr, then the sum of the leaf node is left out hence we change as below
 * 
 */


 public class sum_root_to_leaf_numbers {
    int sum; // take global variable as sum

    public int sumNumbers(TreeNode root){
        helper(root, 0); //we start from root so we pass the current as 0
        return sum;
    }

    private void helper(TreeNode root, int curr){
        if(root == null) return;

        
        if(root.left == null && root.right == null){
            sum+= curr *10 + roo.val;         // we have reached the leaf node as it is been left out add to the summation here
        }
        curr = curr * 10 + root.val;    // calculate the current value for the traversing node
        helper(root.left, curr);    // traverse left    
        helper(root.right, curr);   // traverse right

    }
}





/*
 * Without using global variable sum, so return type of helper becomes int and passing as parameter
 * Below even if we pass as parameter, it is actually acting as the global variable
 * 
 */
public class sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root){
        return helper(root, 0, 0); //we start from root so we pass the current as 0
    }

    private int helper(TreeNode root, int curr, int sum){
        if(root == null) return 0 ;

        curr = curr * 10 + root.val;    // calculate the current value for the traversing node
        if(root.left == null && root.right == null){
            sum+= curr;         // we have reached the leaf node, add to sum
            return sum;
        }
       
        int left = helper(root.left, curr, sum);    // traverse left    
        int right = helper(root.right, curr, sum);   // traverse right

        return left + right;

    }
}

/*
 * Without using global variable sum, so return type of helper becomes int.
 * 
 */
public class sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root){
        return helper(root, 0); //we start from root so we pass the current as 0
    }

    private int helper(TreeNode root, int curr){
        if(root == null) return 0 ;

        curr = curr * 10 + root.val;    // calculate the current value for the traversing node
        if(root.left == null && root.right == null){
            //if we have reached the leaf node, we will return the number we have formed there.
            rerurn curr;
        }
       
        int left = helper(root.left, curr);    // traverse left    
        int right = helper(root.right, curr);   // traverse right

        return left + right;

    }
}
