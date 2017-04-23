// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree{

    BinaryTreeNode<Person> root;

    public AVLTree() {
        root = null;
    }

    public int height(BinaryTreeNode<Person> node) {
        if (node != null) {
            return node.height;
        }
        return -1;
    }

    public int balanceFactor(BinaryTreeNode<Person> node) {
        return height(node.right) - height(node.left);
    }

    public void fixHeight(BinaryTreeNode<Person> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public BinaryTreeNode<Person> rotateRight(BinaryTreeNode<Person> p) {
        BinaryTreeNode<Person> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    public BinaryTreeNode<Person> rotateLeft(BinaryTreeNode<Person> q) {
        BinaryTreeNode<Person> p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    public BinaryTreeNode<Person> balance(BinaryTreeNode<Person> p) {
        fixHeight(p);
        if (balanceFactor(p) == 2) {
            if (balanceFactor(p.right) < 0) {
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if (balanceFactor(p) == -2) {
            if (balanceFactor(p.left) > 0) {
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
    }

   public void insert ( Person p )
   {
      root = insert (p, root);
   }
   public BinaryTreeNode<Person> insert ( Person p, BinaryTreeNode<Person> node )
   {
      if (node == null)
         return new BinaryTreeNode<Person> (p, null, null);
      if (p.name.compareTo (node.p.name) <= 0)
         node.left = insert (p, node.left);
      else
         node.right = insert (p, node.right);
      return balance (node);
   }

    public void delete(String s) {
        root = delete(s, root);
    }

    public BinaryTreeNode<Person> delete(String s, BinaryTreeNode<Person> node) {
        if (node == null) {
            return null;
        }
        if (s.compareTo(node.p.getName()) < 0) {
            node.left = delete(s, node.left);
        } else if (s.compareTo(node.p.getName()) > 0) {
            node.right = delete(s, node.right);
        } else {
            BinaryTreeNode<Person> q = node.left;
            BinaryTreeNode<Person> r = node.right;
            if (r == null) {
                return q;
            }
            BinaryTreeNode<Person> min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(node);
    }

    public BinaryTreeNode<Person> findMin(BinaryTreeNode<Person> node) {
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }
    }

    public BinaryTreeNode<Person> removeMin(BinaryTreeNode<Person> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return balance(node);
    }

    public void find(String s) {
    // Searches for a search query (String) in the BST 
    
        if (root == null) {
        } else {
            find(s, root);
        }
    }

    public void find(String s, BinaryTreeNode<Person> node) { 
        boolean found = false;
        
        if (s.equals(node.p.getName())) {
            found = true;
            System.out.println(node.p.toString());      
        }
        
        if (found == false) { 
            if (node.p.getName().compareTo(s) > 0) {
                if (node.left != null) {
                    find(s, node.left);
                }
                else{System.out.println("Not Found: " + s);}
            }   
            else {
                if (node.right != null) {                       
                find(s, node.right);
                }
                else{System.out.println("Not Found: " + s);}
                    
                }
            }
        }
    public boolean isAVLTree() {
        return isAVLTree(root);
    }

    public boolean isAVLTree(BinaryTreeNode<Person> node) {
        if (node != null) {
            isAVLTree(node.getLeft());
            
            if (balanceFactor(node) < -1 || balanceFactor(node) > 1) {
                return false;
            }
            isAVLTree(node.getRight());
            
        }
        return true;

    }

    public void visit(BinaryTreeNode<Person> node) {
        // Outputs name value of the Person object contained in the node
        //System.out.println(node.p.toString());
        
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(BinaryTreeNode<Person> node) {
        // Outputs BST inorder

        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.p.toString());
            inOrder(node.getRight());
        }
    }
       public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<Person> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.p.toString());
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}
