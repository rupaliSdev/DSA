package DSA.AMatrix;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class test {


    /*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Test Cases:

["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
[null,null,null,1,null,-1,null,-1,3,4]

    * */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);


        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }


}

class LRUCache{
    private int capacity;
    private Map<Integer, Node> map;
    private Node head,tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head =new Node(0,0);
        this.tail =new Node(0,0);
        head.next=tail;
        tail.prev= head;
    }

    public int get(int key){

        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key,int value){

        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);

        if (map.size()>capacity){
            Node lruNode = tail.prev;
            remove(lruNode);
            map.remove(lruNode.key);
        }

    }

    public void insert(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next= node;

    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev= node.prev;
    }

    class Node{
        int key,value;
        Node prev,next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;

        }
    }

}



