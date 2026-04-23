package DSA.LinkedList;

import java.util.HashMap;

public class LFUCache {


    private final int capacity;
    private int minFreq;
    HashMap<Integer, Node> nodeHashMap ;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity, HashMap<Integer, Node> map, HashMap<Integer, DLL> freqMap) {
        this.capacity = capacity;
        this.nodeHashMap = new HashMap<>();
        this.freqMap =   new HashMap<>();
        this.minFreq = 0;
    }

    class Node {
        int key, val;
        Node prev, next;
        int freq = 1;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DLL {
        Node tail = new Node(0, 0);
        Node head = new Node(0, 0);
        int size = 0;

        public DLL() {
            head.next = tail;
            tail.next = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev= node.prev;
            size--;
        }

        Node removeLast(){
            if (size==0) return null;
            Node node = tail.prev;
            remove(node);
            return  node;
        }
    }

    public int get(int key){
        if (!nodeHashMap.containsKey(key)) return -1;

        Node node = nodeHashMap.get(key);
        updateFreq(node);
        return node.val;
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if(oldFreq==minFreq && oldList.size==0){
           minFreq--;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLL())
                .addFirst(node);

    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodeHashMap.containsKey(key)) {
            Node node = nodeHashMap.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }

        if (nodeHashMap.size() == capacity) {
            DLL minList = freqMap.get(minFreq);
            Node evict = minList.removeLast();
            nodeHashMap.remove(evict.key);
        }

        Node node = new Node(key, value);
        nodeHashMap.put(key, node);
        minFreq = 1;

        freqMap.computeIfAbsent(1, k -> new DLL())
                .addFirst(node);
    }


}
