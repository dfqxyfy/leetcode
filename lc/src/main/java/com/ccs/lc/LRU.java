package com.ccs.lc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date 2024/10/15 5:04 PM
 */
public class LRU {

    private Map<String,Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();

    private int size = 3;

    public LRU(){
        head.next = tail;
        tail.pre = head;
    }

    public void put(String key,String value){
        Node node = map.get(key);
        if(node == null){
            if(map.size() == size){
                removeNode(tail.pre.key);
            }
        }else{
            removeNode(key);
        }
        add(key,value);
    }

    public String getCache(String key){

        Node value = map.get(key);
        if(value!=null){
            removeNode(key);
            add(key,value.value);
        }else{
            return null;
        }
        return value.value;
    }

    private void add(String key,String value){
        Node node = new Node();
        node.value=value;
        node.key=key;

        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.pre = head;
        temp.pre = node;

        map.put(key,node);

    }

    private void removeNode(String key){
        Node node = map.get(key);
        Node pre = node.pre;
        Node next = node.next;
        pre.next=next;
        next.pre=pre;
        map.remove(key);
    }


    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.put("a","1");
        lru.put("b","2");
        lru.put("c","3");
        lru.put("d","1");
//        lru.put("d","4");
//        lru.put("e","4");
//        lru.put("f","4");
//        lru.put("g","4");
//        lru.put("h","4");

        System.out.println(lru.getCache("a"));
        System.out.println(lru.getCache("c"));
    }

}
class Node{
    Node pre;
    Node next;
    String key;
    String value;


}
