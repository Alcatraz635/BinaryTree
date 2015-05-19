/**
 * Tyler Schumacher
 */
public class bstTest
{
    public static void main(String[] args)
    {
        BST a = new BST();
        a.insert(3);
        a.insert(17);
        a.insert(-3);
        a.insert(0);
        a.insert(-5);
        a.insert(-7);
        a.insert(-4);
        a.insert(10);
        a.insert(9);
        a.insert(-1);
        a.insert(8);
        BST a2 = a;
        BST a3 = a;
        System.out.println("Original BST a");
        a.trav();
        System.out.println("Removing (-3)....");
        a.delete(a.getRoot(),-3);
        a.trav();
        System.out.println("Original BST a");
        a2.trav();
        System.out.println("Removing (0)....");
        a2.delete(a2.getRoot(),0);
        a2.trav();
        System.out.println("Original BST a");
        a3.trav();
        System.out.println("Removing (8)....");
        a3.delete(a3.getRoot(),8);
        a3.trav();
    }
}
