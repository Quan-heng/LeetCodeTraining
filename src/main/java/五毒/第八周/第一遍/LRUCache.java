package 五毒.第八周.第一遍;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private class DlinkNode{
        int value;
        int key;
        DlinkNode next;
        DlinkNode pre;
        public DlinkNode(){}
        public DlinkNode(int key,int value){
            this.key = key;
            this.value = value;

        }
    }

    private int capacity;
    private int size;
    DlinkNode head;
    DlinkNode tail;
    private Map<Integer,DlinkNode> _cathe;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        _cathe = new HashMap<>();
        head = new DlinkNode();
        tail = new DlinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DlinkNode node = _cathe.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DlinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DlinkNode node  = _cathe.get(key);
        if(node==null){
            DlinkNode newNode = new DlinkNode(key,value);
            _cathe.put(key,newNode);
            moveToHead(newNode);
            size++;
            if(size>capacity){
                removeTail();
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeTail() {
        DlinkNode node = tail.pre;
        removeNode(node);
    }

    private void removeNode(DlinkNode node) {
        _cathe.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
