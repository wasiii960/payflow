package com.practise;

import java.util.Objects;

public class MyHashMap<K,V> {
    private static class Node<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        private Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
    private Node<K,V> [] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    public MyHashMap(){
        this.table=new Node[DEFAULT_CAPACITY];
    }
    private int hash(K key){
        if(key==null) return 0;
        int h =  key.hashCode();
        return h ^ (h >>> 16);
    }
    private int indexFor(int hash,int capacity){
        return hash & (capacity -1);
    }
    V put(K key,V value){
        if(size>=table.length*LOAD_FACTOR) resize();
        int hash = hash(key);
        int index = indexFor(hash,table.length);
        if(table[index]==null){
            table[index]=new Node<>(hash,key,value);
            size++;
        }else{
            Node<K,V> p = table[index];
            Node<K,V> prev=null;
            while(p!=null){
                if(p.hash==hash && Objects.equals(p.key,key)){
                    V oldValue=p.value;
                    p.value=value;
                    return oldValue;
                }
                prev=p;
                p=p.next;
            }
            prev.next = new Node<>(hash,key,value);
            size++;
        }
        return null;
    }

    private void resize() {
         Node<K,V> [] newTable = new Node[table.length*2];
         for(int i=0;i<table.length;i++){
             Node<K,V> p = table[i];
             while(p!=null){
                 int hash = hash(p.key);
                 int index = indexFor(hash,newTable.length);
                 if(newTable[index]==null){
                     newTable[index] = new Node<>(hash,p.key,p.value);
                 }
                 else{
                  Node<K,V> q = newTable[index];
                  Node<K,V> prev=null;
                  while(q!=null){
                      prev=q;
                      q=q.next;
                  }
                  prev.next = new Node<>(hash,p.key,p.value);
                 }
                 p=p.next;
             }
         }
         table=newTable;
    }

    V get(K key){
        int hash = hash(key);
        int index = indexFor(hash,table.length);
        if(table[index]==null) return null;
        else{
            Node<K,V> p = table[index];
            while(p!=null){
                if(p.hash==hash && Objects.equals(p.key,key)){
                    return p.value;
                }
                p=p.next;
            }
            return null;
        }
    }
    boolean containsKey(K key){
        int hash = hash(key);
        int index = indexFor(hash,table.length);
        if(table[index]==null) return false;
        else{
            Node<K,V> p = table[index];
            while(p!=null){
                if(p.hash==hash && Objects.equals(p.key,key)){
                    return true;
                }
                p=p.next;
            }
        }
        return false;
    }
    V remove(K key){
        int hash = hash(key);
        int index = indexFor(hash,table.length);
        if(table[index]==null) return null;
        else{
            Node<K,V> p = table[index];
            Node<K,V> prev=null;
            while(p!=null){
                if(p.hash==hash && Objects.equals(p.key,key)){
                    if(prev==null){
                        table[index]=p.next;
                        size--;
                        return p.value;
                    }else{
                        prev.next = p.next;
                        size--;
                        return p.value;
                    }
                }
                prev=p;
                p=p.next;
            }
            return null;
        }
    }
    public int size() {
        return size;
    }
}
