package com.hqxu.Class.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 *1.集合：
 *  只能存放对象
 * 
 *单列集合
 *<Iterable>
 *  <Collection> （两个子接口）
 *      <List>                      (有序、有索引、可重复, 可为null)
 *          ArrayList
 *          LinkedList
 *          Vector
 *              Stack
 *              
 *      <Set> [无索引、无重复]
 *          HashSet                 (无序, 可为null, 无重复)
 *              LinkedHashSet       (有序, 可为null, 无重复)
 *          <SortedSet>
 *              TreeSet             (无序, 支持排序, 不能为null, 无重复)
 *          
 *  
 *  
 * 双列集合
 *  <Map>   [key无重复]
 *      HashMap             (无序; key-value都可以是null)
 *          LinkedHashMap   (有序; key-value都可以是null)
 *          
 *      Hashtable           (无序; key-value都不能为null)
 *          Properties
 *          
 *      <SoretedMap>
 *          TreeMap         (无序,支持排序; key不能为null,value可以null)
 *          
 *  ****************************************************************************        
 *          
 *          
 * 2.List 实现原理
 *  2.1 ArrayList
 *      实现：对象数组，超出数组容量,数组扩容
 *      非线程安全
 *      
 *  2.2 LinkedList
 *      实现：链表
 *      非线程安全
 *      
 *  2.3 Vector：
 *      实现：对象数组
 *      线程安全
 *  2.4 Stack
 *      实现：对象数组
 *      线程安全
 *       
 *    **************************
 *      
 * 3.Set 实现原理
 *  3.1 HashSet
 *      实现：内部使用一个HashMap [哈希表 (数组+单向链表)]，无序。
 *      非线程安全
 *      
 *  3.2 LinkedHashSet 
 *      实现： 内部使用一个LinkedHashMap [哈希表 + 双向链表]，因此是有序的。
 *      非线程安全
 *      
 *  3.3 TreeSet
 *      实现：基于 TreeMap [红黑树]
 *      非线程安全
 *      
 *   ***************************
 *
 * 4.Map 实现原理
 *  4.1 HashMap
 *      实现：哈希表 (数组+单向链表/红黑树)
 *      非线程安全

 *  4.2 LinkedHashMap
 *      实现：HashMap（哈希表）的基础上，多了一个双向链表来维持 顺序 ，有序。
               非线程安全
 *  
 *  4.3 Hashtable
 *      实现：哈希表 (数组+单向链表)，数据结构与HashMap是相同的
 *      线程安全
 *      
 *  4.4 TreeMap
 *      实现：红黑树
 *      非线程安全
 *  
 *  ***********************************************************************
 *  
 *  红黑树
 *  是一种自平衡排序二叉树，树中每个节点的值，都大于或等于在它的左子树中的所有节点的值，并且小于或等于在它的右子树中的所有节点的值，
 *  这确保红黑树运行时可以快速地在树中查找和定位的所需节点。
 *  
 *  
 *  ***********************************************************************
 *  
 *  5.线程安全的集合
 *      Vector
 *          Stack
 *          
 *      HashTable
 *  
 *  
 *  6.如何遍历集合
 *  
 *  6.1 Collection 继承了 Iterable，可以会用 iterator 迭代器遍历; (底层是链表实现的优先使用迭代器)
 *                  或者 加强for循环
 *  
 *  6.2 Map 通过 iterator 遍历  Set<K> keySet() 或者 Set<Map.Entry<K, V>> entrySet
 *              或者 加强for循环   Set<K> keySet() 或者 Set<Map.Entry<K, V>> entrySet
 *  
 *  
 * 
 */
public class CollectionClass {

    public static void main(String[] args) {
        // 测试 ArrayList
        arrayList();
        
        // 测试 LinkedList
        linkedList();
        
        
        // 测试 hashSet
        hashSet();
        
        // LinkedHashSet
        linkedHashSet();
        
        
        // 测试hashmap
        hashMap();
        
        // 测试hashtable
        hashtable();
        
        // 测试 LinkedHashMap
        linkedHashMap();
        
        // 测试 treeMap
        treeMap();
        
        // 测试 treeSet
        treeSet();
        
    }
    
    /**
     * 测试 ArrayList
     */
    public static void arrayList() {
        List<String> list = new ArrayList<String>();
        
        // add()
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("3");
        list.add("6");
        list.add("3");
        list.add("7");
        list.add(null);
        list.add(null);
        
        // get()
        System.out.println(list.get(0));
        
        // 如果有重复，删除第一个
        list.remove("3");
        System.out.println(list);
        
        
        // 遍历
        Iterator<String> i = list.iterator();
        while(i.hasNext()) {
            String s = i.next();
            System.out.println(s);
        }
        
        for(String str : list) {
            System.out.println(str);
        }
        for(int b=0; b<list.size(); b++) {
            System.out.println(list.get(b));
        }
        
        System.out.println("arrayList ------------------------------- end");
        
    }
    
    
    /**
     * 测试 LinkedList
     *  有序
     *  可为null
     *  可重复
     */
    public static void linkedList() {
        List<String> list = new LinkedList<String>();
        
        // add()
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("3");
        list.add("6");
        list.add("3");
        list.add(null);
        list.add(null);
        
        // get()
        System.out.println(list.get(0));
        
        // 如果有重复，删除第一个
        list.remove("3");
        System.out.println(list);
        
        System.out.println("linkedList ------------------------------- end");
        
    }
    
    
    /**
     * 测试 HashSet
     *  无序
     *  可为null
     *  无重复
     */
    public static void hashSet() {
        Set<String> list = new HashSet<String>();
        
        // add()
        list.add("5");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add(null);

        System.out.println(list);
        
        
        
        
        // 遍历
        Iterator<String> i = list.iterator();
        while(i.hasNext()) {
            String s = i.next();
            System.out.println(s);
        }
        
        for(String str : list) {
            System.out.println(str);
        }
        
        
        System.out.println("HashSet ------------------------------- end");
        
    }
    
    /**
     * 测试 LinkedHashSet
     *  有序
     *  可为null
     *  无重复
     */
    public static void linkedHashSet() {
        Set<String> list = new LinkedHashSet<String>();
        
        // add()
        list.add("5");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add(null);

        System.out.println(list);
        
        System.out.println("LinkedHashSet ------------------------------- end");
        
    }
    
    /**
     * 测试 HashMap
     *  无序
     *  key value 可为null
     *  key 无重复
     */
    public static void hashMap() {
        Map<String,String> hashmap = new HashMap<String,String>();
        
        // put()
        hashmap.put("1", "1");
        hashmap.put(null, "2");
        hashmap.put(null, null);
        
        // get()
        System.out.println(hashmap.get(null));
        
        System.out.println(hashmap);
        
        
        // 遍历 key Set
        Set<String> ks = hashmap.keySet();
        for(String k: ks) {
            System.out.println(hashmap.get(k));
        }
        
        
        // 遍历 Entry Set
        Set<Map.Entry<String, String>> es = hashmap.entrySet();
        for(Map.Entry<String, String> e: es) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
        
        
        // 仅遍历values
        Collection<String> vs = hashmap.values();
        for(String s : vs) {
            System.out.println("value: " + s);
        }
        
        
        System.out.println("HashMap ------------------------------- end");
        
    }
    
    
    /**
     * 测试 Hashtable
     *  无序
     *  key value 均不为null
     *  key 无重复
     */
    public static void hashtable() {
        Map<String,String> hashmap = new Hashtable<String,String>();
        
        // put()
        hashmap.put("1", "1");
        hashmap.put("2", "3"); // 被覆盖
        hashmap.put("2", "2");
        hashmap.put("3", "3");
        
        System.out.println(hashmap);
        
        
        // 遍历 key Set
        Set<String> ks = hashmap.keySet();
        for(String k: ks) {
            System.out.println(hashmap.get(k));
        }
        
        
        // 遍历 Entry Set
        Set<Map.Entry<String, String>> es = hashmap.entrySet();
        for(Map.Entry<String, String> e: es) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
        
        
        // 仅遍历values
        Collection<String> vs = hashmap.values();
        for(String s : vs) {
            System.out.println("value: " + s);
        }
        
        System.out.println("Hashtable ------------------------------- end");
        
    }
    
    
    
    
    
    /**
     * 测试LinkedHashMap
     *  有序
     *  key value 可为null
     *  key 无重复
     */
    public static void linkedHashMap() {
        Map<String,String> hashmap = new LinkedHashMap<String,String>();
        
        // put()
        hashmap.put("1", "1");
        hashmap.put(null, "2");
        hashmap.put(null, null);
        
        // get()
        System.out.println(hashmap.get(null));
        
        System.out.println(hashmap);
        
        System.out.println("LinkedHashMap ------------------------------- end");
    }
    
    
    
    
    /**
     * 测试 treeMap
     *  无序，支持按key排序
     *  key 不能为null; value 可为null
     *  key 无重复
     *  
     */
    public static void treeMap() {
        Map<String,String> hashmap = new TreeMap<String,String>();
        
        // put()
        hashmap.put("a", null);
        hashmap.put("1", "1");
        hashmap.put("2", null);
        hashmap.put("4", null);
        hashmap.put("3", null);
        //hashmap.put(null, null); // key不能为null
        
        // get()
        System.out.println(hashmap);
        
        System.out.println("treeMap ------------------------------- end");
    }
    
    
    /**
     * 测试TreeSet
     *  无序,支持排序
     *  不能为null
     *  
     */
    public static void treeSet() {
        Set<Integer> hashmap = new TreeSet<Integer>();
        
        // add()
        hashmap.add(1);
        hashmap.add(2);
        hashmap.add(4);
        hashmap.add(3);
        hashmap.add(-1);
        // hashmap.add(null); // 不能为Null
        
        // get()
        System.out.println(hashmap);
        
        System.out.println("treeSet ------------------------------- end");
    }
    
}
