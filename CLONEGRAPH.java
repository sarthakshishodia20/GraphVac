/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Node clone=new Node(node.val);
        map.put(node,clone);
        q.add(node);
        while(!q.isEmpty()){
            Node current=q.poll();
            for(Node neighbour:current.neighbors){
                if(!map.containsKey(neighbour)){
                    Node neighborClone=new Node(neighbour.val);
                    map.put(neighbour,neighborClone);
                    q.add(neighbour);
                }
                map.get(current).neighbors.add(map.get(neighbour));
            }
        }
        return clone;
    }
}
