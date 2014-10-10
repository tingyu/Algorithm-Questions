  add a node to binary search tree
  
       5
     3   8

class TreeNode{
	int val;
  	TreeNode left, right;
  	TreeNode(int x){
  		val = x;
    }
}
public TreeNode addNodeToBST(TreeNode root, int value){
	 return helper(root, value);
}

private TreeNode helper(TreeNode node, int value){
  	if(node == null){
 		return new TreeNode(value);
    }
  	if(node.val > value) {
    	node.left = helper(node.left, value);
    }else if(node.val < value){
    	node.right = helper(node.right, value);
    }
  	return node;
}