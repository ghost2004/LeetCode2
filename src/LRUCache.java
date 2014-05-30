/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key 
exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present.
 
 When the cache reached its capacity, it should invalidate the least recently 
 used item before inserting a new item.
 */
import java.util.*;
public class LRUCache {
    
    private HashMap<Integer, CacheNode> map;
    private CacheNodeList list;
    private int capacity;
    
    private class CacheNode {
        public int key;
        public int val;
        public CacheNode prev;
        public CacheNode next;
        
        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private class CacheNodeList {
        private CacheNode head;
        private CacheNode tail;
        
        public CacheNodeList() {
            this.head = new CacheNode(-1, 0);
            this.tail = new CacheNode(-1, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }
        
        // insert the new node to head
        public void insertHead(CacheNode node) {
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
            
        }
        
        // remove the tail node and return its key
        public int removeTail() {
            // in case of empty linked list, return -1
            if (this.tail.prev == this.head)
                return -1;
            CacheNode node = this.tail.prev;
            node.prev.next = this.tail;
            this.tail.prev = node.prev;
            return node.key;
        }
        
        // shift the node to head
        public void shiftHead(CacheNode node){
            if (node.key == this.head.next.key)
                return;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
        }
        
    }
    
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, CacheNode>();
        list = new CacheNodeList();
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        CacheNode node = map.get(key);
        if (node == null)
            return -1;
        list.shiftHead(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        CacheNode node = map.get(key);
        
        if (node == null) {
            node = new CacheNode(key, value);
            list.insertHead(node);
            map.put(key, node);
            if (map.size() > this.capacity) {
                int k = list.removeTail();
                map.remove(k);
            }
            
        } else {
            node.val = value;
            list.shiftHead(node);
        }
        
        
    }
    
    public static void main(String args[]) {
        
        LRUCache c = new LRUCache(1);
        
        c.set(2, 1);
        System.out.println(c.get(2));
        c.set(3, 2);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        
        c = new LRUCache(2);
        
        c.set(2, 1);
        c.set(1, 1);
        System.out.println(c.get(2));
        c.set(4, 1);
        System.out.println(c.get(1));
        System.out.println(c.get(2));
    }
}
