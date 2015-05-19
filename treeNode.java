/**
 * Tyler Schumacher
 */
public class treeNode
{
    private int data;
    private treeNode left;
    private treeNode right;
    public treeNode(int y)
    {
        data = y;
        left = null;
        right = null;
    }
    public int getData()
    {
        return data;
    }
    public treeNode getLeft()
    {
        return left;
    }
    public treeNode getRight()
    {
        return right;
    }
    public void setData(int y)
    {
        data = y;
    }
    public void setLeft(treeNode leftChild)
    {
        left = leftChild;
    }
    public void setRight(treeNode rightChild)
    {
        right = rightChild;
    }
}
