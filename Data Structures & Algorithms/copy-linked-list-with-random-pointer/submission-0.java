/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// class Solution {

//     HashMap<Node, Node>visitedNode = new HashMap<Node, Node>();

//         public Node copyRandomList(Node head){
//             if(head == null){
//                 return null;
//             }
//             if(this.visitedNode.containsKey(head)){
//                 return this.visitedNode.get(head);
//             }
//             Node node =  new Node(head.val, null, null);

//             this.visitedNode.put(head, node);
//             node.next = copyRandomList(head.next);
//             node.random = copyRandomList(head.random);

//             return node;
//         }
    
// }
public class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);

        Node copy = new Node(head.val);
        map.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = map.get(head.random);
        return copy;
    }
}