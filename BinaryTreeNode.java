// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<Person>
{
   Person p;
   BinaryTreeNode<Person> left;
   BinaryTreeNode<Person> right;
   int height;
   
   public BinaryTreeNode (Person per, BinaryTreeNode<Person> l, BinaryTreeNode<Person> r )
   {
      this.p = per;
      left = l;
      right = r;
      height = 0;
   }
   
   BinaryTreeNode<Person> getLeft () { return left; }
   BinaryTreeNode<Person> getRight () { return right; }
   
}
