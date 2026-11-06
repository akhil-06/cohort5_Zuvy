import java.util.*;

// internal class for HashMap implementation
public class InternalHashMap {
    // number of key-value pairs in the map, this k and v are generic types
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
    }
    // constructor for Node class with key, value and next node

    Node(K key, V value, Node<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    // my bucket array to store the key-value pairs with initial capacity of 10
    private Node<K, V>[] buckets;
    private int capacity = 10;

    // this is the number of key-value pairs in the map
    InternalHashMap() {
        buckets = new Node[capacity];
    }

    // this is usedto get the index of the key in the bucket array
    private int getIndex(K key) {
        // thisline returns the index of the key in the bucket array by taking the
        // absolute value of the hash code of the key and then taking the modulus with
        // the capacity of the bucket array
        return Math.abs(key.hashCode()) % capacity;
    }

    // this method is used to rehash the bucket array when the load factor exceeds
    // 0.7
    public void rehashing() {
        Node<K, V>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;

        // iterating through the old bucket array and putting the key-value pairs in the
        // new bucket array

        for (Node<K, V> head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    // put function to add key-value pairs to the map, if the key already exists, it
    // will update the value
    public void put(K key, V value) {
        // load fctor is the ratio of the number of key-value pairs to the capacity of
        // the bucket array, if it exceeds 0.7, we will rehash the bucket array
        if ((double) size / capacity >= 0.7) {
            rehashing();
        }
        // getting the index of the key in the bucket array and checking if the key
        // already exists, if it does, we will update the value, if it doesn't, we will
        // add a new node to the bucket array
        int index = getIndex(key);
        // /this measn we are getting the head of the linked list at the index in the
        // bucket array
        Node<K, V> curr = buckets[index];
        // this is used to check if the key already exists in the linked list, if it
        // does, we will update the value, if it doesn't, we will add a new node to the
        // linked list
        if (curr == null) {
            buckets[index] = new Node<>(key, value, null);
            return;
        }
        // thisloop is used to iterate through the linked list at the index in the
        // bucket array and check if the key already exists, if it does, we will update
        // the value, if it doesn't, we will add a new node to the linked list
        while (curr != null) {
            // this if statement is used to check if the key already exists in the linked
            // list, if it does, we will update the value, if it doesn't, we will add a new
            // node to the linked list
            if (curr.key != null && curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            // this stands for the next node in the linked list, if it is null, we will
            // break the loop and add a new node to the linked list, if it is not null, we
            // will continue iterating through the linked list
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        // add a new node to the linked list at the index in the bucket array
        curr.next = new Node<>(key, value, null);
    }

    // this is get function to get the value of the key in the map, if the key
    // doesn't exist, it will return null
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> curr = buckets[index];
        while (curr != null) {
            if (curr.key != null && curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> curr = buckets[index];
        // this prev variable is used to keep track of the previous node in the linked
        // list, if the key is found, we will update the next pointer of the previous
        // node to skip the current node and remove it from the linked list
        Node<K, V> prev = null;
        while (curr != null) {
            // found out the key in the linked list, we will update the next pointer of the
            // previous node to skip the current node and remove it from the linked list
            if (curr.key != null && curr.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                // size variable is used to keep track of the number of key-value pairs in the
                // map, we will decrement it by 1 when we remove a key-value pair from the map
                size--;
                return;
            }
            // now we will update the prev and curr variables to continue iterating through
            // the linked list
            prev = curr;
            curr = curr.next;
        }

    }

}
