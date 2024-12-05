package com.ccs.test2;

/**
 * @date 2024/10/25 12:03 AM
 */
public class Test {

    public void genNode(Node node,int height){
        if(height<=0){
            return;
        }
        Node left = new Node();
        Node right = new Node();

        left.parent=node;
        right.parent=node;

        node.left = left;
        node.right=right;

        genNode(node.left,height-1);

        genNode(node.right,height-1);
    }

    public void genNodeInit(Node<Integer> node,int height){
        if(height<=1){
            return;
        }
        Node left = new Node(2*node.val);
        Node right = new Node(2*node.val+1);

        left.parent=node;
        right.parent=node;

        node.left = left;
        node.right = right;

        genNodeInit(node.left,height-1);

        genNodeInit(node.right,height-1);
    }



    public void genNodeInitChar(Node<Character> node,int height){
        if(height<=1){
            return;
        }

        Character nodeLeftVal = (char)(2*(node.val.charValue() - 'A') +'A'+1);
        Character nodeRightVal = (char)(2*(node.val.charValue() - 'A') +'A'+1+1);

        Node left = new Node(nodeLeftVal);
        Node right = new Node( nodeRightVal );

        left.parent=node;
        right.parent=node;

        node.left = left;
        node.right = right;

        genNodeInitChar(node.left,height-1);

        genNodeInitChar(node.right,height-1);
    }


    public void mulitiSearch(){
        Test test = new Test();
        Node<Character> root1 = new Node<>('A');
        test.genNodeInitChar(root1,5);
        Node<Character> root2 = new Node<>('A');
        test.genNodeInitChar(root2,5);
        Node<Character> root3 = new Node<>('A');
        test.genNodeInitChar(root3,5);

        root2.parent= root1;
        root3.parent= root2;
        root1.parent= root3;

        searchParent(root1,null);

    }

    public void searchParent(Node node ,Node first){


        if(node == first){
            return;
        }
        if(first == null){
            first = node;
        }
        System.out.println();
        searchAll(node);

        searchParent(node.parent,first);

    }
    public void searchAll(Node node){
        if(node == null ){
            return;
        }
        System.out.print(node.val+" ");
        searchAll(node.left);
        searchAll(node.right);
    }


    public static void main(String[] args) {
        Test test = new Test();
        //Node root = new Node(1);
        ///test.genNodeInit(root,2);
        //System.out.println(root);
        Node<Character> root = new Node<>('A');
        test.genNodeInitChar(root,5);
        System.out.println(root);


        test.mulitiSearch();


    }
}

class Node<T>{
    Node parent;

    Node left;
    Node right;

    T val;

    public Node(){
    }
    public Node(T t){
        this.val=t;
    }

    public String toString(){
        return val+"";
    }
}
