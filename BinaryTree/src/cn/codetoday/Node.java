package cn.codetoday;

/**
 * @author: codetoday
 * @date: 2021-11-13 10:19
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
