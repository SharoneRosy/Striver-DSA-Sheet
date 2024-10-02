class BSTIterator {
Stack<TreeNode> s = new Stack<>();
Boolean reverse = true;
public BSTIterator(TreeNode root,Boolean reverse) {
    this.reverse = reverse;
    pushAll(root);
}
public int next() {
    TreeNode temp = s.pop();
    if(reverse == false){
        pushAll(temp.right);
    }
    else{
        pushAll(temp.left);
    }
    return temp.val;
    
}

//This function just tells whether there are any elements left or not.
public boolean hasNext() {
    return !s.isEmpty();
}
public void pushAll(TreeNode node){
    
    if(reverse == false){
        while(node!=null){
        s.push(node);
        node = node.left;
    }
}
    else{
        while(node!=null){
        s.push(node);
        node = node.right;
		}
	}
}
}
class Solution {
public boolean findTarget(TreeNode root, int k) {

	//Creating an instance of the BSTIterator class to get the desired traversal.
    BSTIterator left = new BSTIterator(root,false);
    BSTIterator right = new BSTIterator(root,true);
    
	//Taking the first element of the ascending and descending traversals.
    int i = left.next();
    int j = right.next();
    
	//Using simple binary search logic to find the answer.
    while(i<j){
        if(i+j == k) return true;
        else if(i+j< k) i = left.next();
        else j =right.next();
        }
    return false;
    }
}

