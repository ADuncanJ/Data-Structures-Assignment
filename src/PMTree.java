import java.util.*;

public class PMTree {
    private class Node {
        Node parent;
        Node left, right;
        int days;
        String name;
        int size;

        Node (Node parent, int days, String name) {
            this.parent = parent;
            this.days = days;
            this.name = name;
            this.left = this.right = null;
            this.size = 1;

        }

        /*
         *  When deleting, we want to know how many children a node has.
         */
        int numChildren () {
            return (left == null ? 0 : 1) + (right == null ? 0 : 1);
        }
    }

    private Node root = null;

    public String contains (int days) {
        Node cur = root;
        if (root == null){
            return null;
        }
        while(true){
            if(days == cur.days){
                return cur.name;
            }else if(days < cur.days){
                if(cur.left == null){
                    return null;
                }else{
                    cur = cur.left;
                }
            }else{
                if(cur.right == null){
                    return null;
                }else{
                    cur = cur.right;
                }
            }
        }
    }

    private Node getNode (int days) {
        Node cur = root;
        while (cur != null) {
            if (days == cur.days)
                return cur;
            else if (days < cur.days)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return null;
    }

    public void insert (int days, String name) {
        Node cur = root;
        if (root == null) {
            root = new Node (null, days, name);
            return;
        }

        while (true) {
            if (days == cur.days) {
                cur.name = name;
                return;
            }else if (days < cur.days) {
                if (cur.left == null) {
                    cur.left = new Node (cur, days, name);
                    updateSize(root);
                    return;
                } else
                    cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Node (cur, days, name);
                    updateSize(root);
                    return;
                } else
                    cur = cur.right;
            }
        }

    }

    /*
     *  Delete a node from the tree. If the node has one child or none,
     *  delete it as if it, its parent (if it exists) and its child (if
     *  it has one) are a doubly linked list. Otherwise, replace the value
     *  in the node to be deleted with the minimum element of its right
     *  subtree and delete the node that originally contained that element.
     *  Note that, by construction, that node has at most one child (it has
     *  no left child because a left child would contain a smaller value).
     */
    public void delete (int days) {
        Node node = getNode (days);
        if (node == null)
            return;

        if (node.numChildren() < 2) {
            simpleDelete (node);
        } else {
            Node min = getMinNode(node.right);
            simpleDelete (min);
            node.days = min.days;
            node.name = min.name;
        }
    }

    /*
     *  Delete a node that has one child or none. We treat this node,
     *  its parent (if it exists) and its child (if it has one) as a doubly
     *  linked list and delete accordingly. The code is fiddly because of
     *  the special cases. We might be deleting the root (parent == null)
     *  and/or we might be deleting a node with no child, with just a left
     *  child or just a right child.
     */
    private void simpleDelete (Node node) {
        Node child = node.left != null ? node.left : node.right;

        if (node == root) {
            root = child;
            if (root != null)
                root.parent = null;
        } else {
            if (node == node.parent.left)
                node.parent.left = child;
            else
                node.parent.right = child;
            if (child != null)
                child.parent = node.parent;
        }
        updateSize(root);
    }

    /*
     *  Return the node containing the smallest value in the subtree
     *  rooted at the given node. This is found by following the left
     *  child reference until we get to a node that has no left child.
     */
    private Node getMinNode (Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private int updateSize(Node node){
        if(node == null){
            return 0;
        }else{
            return node.size = 1 + updateSize(node.left) + updateSize(node.right);
        }

    }
    //Decided that it would be simpler to get the item from the end of the array than
    //keep track of how many elements had been looked at.
    public String nthShortest(int n){
        String name = allNShortest(n)[n-1];
        return  name;
    }
    /*Because this is probably messy its following this flowchart
    Is there a Left Child?
    Yes: Go Left -> Is There a Left Child?
    No: Add to Array -> Is there a Right Child?

    Is there a Right Child?
    Yes: Go Right -> Is There a Left Child?
    No:Go Up -> Is The Current Right Child the Previous Node?

    Is The Current Right Child the Previous Node?
    Yes: Go Up -> Is The Current Right Child the Previous Node?
    No: Add to Array -> Is there Right Child
     */
    public String[] allNShortest(int n){
        String[] outputArray = new String[n];
        int i = 0;
        Node node = root;
        Node temp;
        while(true){
            if(i == n){
                break;
            }
            if(node.left != null){
                node = node.left;
            }
            if(node.left == null){
                outputArray[i] = node.name;
                i +=1;
                if(i == n){
                    break;
                }else{
                    int y = 0;
                    while(y == 0){
                        if(i==n){
                            break;
                        }
                        if(node.right != null){
                            node = node.right;
                            y = 1;
                        }else{
                            int x = 0;
                            while(x ==0){
                                temp = node;
                                node = node.parent;
                                if(node.right == null || node.right != temp){

                                    outputArray[i] = node.name;
                                    i += 1;
                                    x = 1;}
                                if(i == n){
                                    break;
                                }

                            }
                        }
                    }
                }
            }

        }
        return outputArray;
    }


    public static void main(String[] args) {
        PMList pmList = new PMList();
        PMTree pmTree = new PMTree();
        List listOPMs = pmList.getPrimeMinisters();
        for(int i = 0; i < listOPMs.size(); i++){
            PMList.Entry e = (PMList.Entry) listOPMs.get(i);
            pmTree.insert(e.days,e.name);
        }
        System.out.println("the 10th Shortest serving Prime Minister was " + pmTree.nthShortest(10));
        System.out.println("the 20th Shortest serving Prime Minister was " + pmTree.nthShortest(20));
        System.out.println("the 30th Shortest serving Prime Minister was " + pmTree.nthShortest(30));
        System.out.println("the 40th Shortest serving Prime Minister was " + pmTree.nthShortest(40));
        System.out.println("the 50th Shortest serving Prime Minister was " + pmTree.nthShortest(50));
        System.out.println("the 10 Shortest serving Prime Minsters are: ");
        String[] tenShort = pmTree.allNShortest(10);
        for(int i = 0; i < tenShort.length; i++){
            System.out.println(tenShort[i]);
        }
        int[] incomplete = PMList.INCOMPLETE;
        for(int i = 0; i < incomplete.length; i++){
            pmTree.delete(incomplete[i]);
        }
        System.out.println("the 10 Shortest serving Prime Minsters who served a complete term are: ");
        String[] tenShortRevised = pmTree.allNShortest(10);
        for(int i = 0; i < tenShortRevised.length; i++){
            System.out.println(tenShortRevised[i]);
        }
    }
}

