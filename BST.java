/**
 * Tyler Schumacher
 */
public class BST
{
    private treeNode root;
    private int size;
    
    public int getSize()
    {
        return size;
    }
    public treeNode getRoot()
    {
        return root;
    }
    public void setSize(int s)
    {
        size = s;
    }
    public void setRoot(treeNode r)
    {
        root = r;
    }
    public void Pre(treeNode curr, int leftDir, treeNode save)
    {
        if(curr != null)
        {
            treeNode newNode = new treeNode(curr.getData());
            if(save != null)
            {
                if(leftDir == 1)
                {
                    save.setLeft(newNode);
                }
                else
                {
                    save.setRight(newNode);
                }
            }
            save = newNode;
            Pre(curr.getLeft(), 1, save);
            Pre(curr.getRight(), 0, save);
        }
    }
    public BST()
    {
        root = null;
        size = 0;
    }
    public BST(BST x)
    {
        size = x.getSize();
        treeNode xroot = x.getRoot();
        root = new treeNode(xroot.getData());
        Pre(xroot.getLeft(), 1, root);
        Pre(xroot.getRight(), 0, root);
    }
    public void insert(int y)
    {
        treeNode newNode = new treeNode(y);
        assert(newNode != null);
        size++;
        if(root == null)
        {
            root = newNode;
        }
        else
        {
            int leftDir = 0;
            treeNode save = null;
            treeNode curr = root;
            while(curr != null)
            {
                save = curr;
                if(y <= curr.getData())
                {
                    curr = curr.getLeft();
                    leftDir = 1;
                }
                else
                {
                    curr = curr.getRight();
                    leftDir = 0;
                }
            }
            if(leftDir == 1)
            {
                save.setLeft(newNode);
            }
            else
            {
                save.setRight(newNode);
            }
        }
    }
    public void trav()
    {
        System.out.println("inorder traversal of the BST: ");
        inorder(root);  
    }
    public void inorder(treeNode ptr)
    {
        if(ptr != null)
        {
            inorder(ptr.getLeft());
            System.out.println(ptr.getData());
            inorder(ptr.getRight());
        }
    }
    public static BST CombineBST(BST A, BST B, int x)
    {
        BST Acopy = new BST(A);
        BST Bcopy = new BST(B);
        BST C = new BST();
        treeNode r = new treeNode(x);
        C.setRoot(r);
        r.setLeft(Acopy.getRoot());
        r.setRight(Bcopy.getRoot());
        C.setSize(A.getSize() + B.getSize() + 1);
        return C;
    }
    public int smallestNode(treeNode n)
    {
        if (n.getLeft() == null) 
        {
            return n.getData();
        } 
        else 
        {
            return smallestNode(n.getLeft());
        }
    }
    public treeNode delete(treeNode n, int y) 
    {
        if (n == null) 
        {
            return null;
        }
        if (y ==  n.getData()) 
        {
            if (n.getLeft() == null && n.getRight() == null) 
            {
                return null;
            }
            if (n.getLeft() == null) 
            {
                return n.getRight();
            }
            if (n.getRight() == null) 
            {
                return n.getLeft();
            }
            int smallest = smallestNode(n.getRight());
            n.setData(smallest);
            n.setRight(delete(n.getRight(), smallest));
            return n;
        }
        else if (y < n.getData()) 
        {
            n.setLeft( delete(n.getLeft(), y) );
            return n;
        }
            
        else 
        {
            n.setRight( delete(n.getRight(), y) );
            return n;
        }
    }
}
