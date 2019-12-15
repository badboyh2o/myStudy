package com.hqxu.Class.collection;

import java.util.LinkedList;

public class LinkedListApply {
    
    
    // 测试
    public static void main(String[] args) {
        
        testQueue();
        
        System.out.println("\n\n\n");
        
        testStack();
    }
    
    
    
    
    
    
    
    
    
    // 测试队列
    public static void testQueue() {
        

        User user1 = new User(1, "账号1", "密码1", "姓名1");
        User user2 = new User(2, "账号2", "密码2", "姓名2");
        User user3 = new User(3, "账号3", "密码3", "姓名3");
        User user4 = new User(4, "账号4", "密码4", "姓名4");
        User user5 = new User(5, "账号5", "密码5", "姓名5");

        Queue<User> queue = new Queue<User>();

        queue.enQueue(user1);
        queue.enQueue(user2);
        queue.enQueue(user3);
        queue.enQueue(user4);
        queue.enQueue(user5);// 进队

        System.out.println("队首元素：" + queue.queueFirst());
        System.out.println("队尾元素：" + queue.queueLast());
        System.out.println("队列长度：" + queue.queueLength());
        System.out.println("队列是否为空：" + queue.isEmpty());
        System.out.println(queue.toString());// 打印队列

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();// 出队

        System.out.println("队首元素：" + queue.queueFirst());
        System.out.println("队尾元素：" + queue.queueLast());
        System.out.println("队列长度：" + queue.queueLength());
        System.out.println("队列是否为空：" + queue.isEmpty());
        System.out.println(queue.toString());// 打印队列

        queue.destroyQueue();// 销毁队列

        System.out.println("队列长度：" + queue.queueLength());
        System.out.println("队列是否为空：" + queue.isEmpty());
        System.out.println(queue.toString());// 打印队列
        
        
    }
    
    
    
    // 测试 栈
    public static void testStack() {

        User user1 = new User(1, "账号1", "密码1", "姓名1");
        User user2 = new User(2, "账号2", "密码2", "姓名2");
        User user3 = new User(3, "账号3", "密码3", "姓名3");
        User user4 = new User(4, "账号4", "密码4", "姓名4");
        User user5 = new User(5, "账号5", "密码5", "姓名5");

        Stack<User> stack = new Stack<User>();

        stack.push(user1);
        stack.push(user2);
        stack.push(user3);
        stack.push(user4);
        stack.push(user5);// 进栈

        System.out.println("栈顶元素：" + stack.stackFirst());
        System.out.println("栈底元素：" + stack.stackLast());
        System.out.println("栈长度：" + stack.stackLength());
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println(stack.toString());// 打印栈

        stack.pop();
        stack.pop();
        stack.pop();// 出栈

        System.out.println("栈顶元素：" + stack.stackFirst());
        System.out.println("栈底元素：" + stack.stackLast());
        System.out.println("栈长度：" + stack.stackLength());
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println(stack.toString());// 打印栈

        stack.destroyStack();// 销毁栈

        System.out.println("栈长度：" + stack.stackLength());
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println(stack.toString());// 打印栈

    }
    
    

}



/**
 * LinkedList模队列，先进先出
 *
 * @param <T>
 */
class Queue<T> {

    private LinkedList<T> linkedList = new LinkedList<T>();

    /**
     * 进队
     * 
     * @param t
     *            进队的元素
     */
    public void enQueue(T t) {
        linkedList.addLast(t);
    }

    /**
     * 出队
     * 
     * @return 出队的元素
     */
    public T deQueue() {
        return linkedList.removeFirst();
    }

    /**
     * 销毁队列
     */
    public void destroyQueue() {
        linkedList.clear();
    }

    /**
     * 查看队首元素
     * 
     * @return 队首的元素
     */
    public T queueFirst() {
        return linkedList.getFirst();
    }

    /**
     * 查看队尾元素
     * 
     * @return 队尾的元素
     */
    public T queueLast() {
        return linkedList.getLast();
    }

    /**
     * 查看队列长度
     * 
     * @return 队列的长度
     */
    public int queueLength() {
        return linkedList.size();
    }

    /**
     * 判断队列是否为空
     * 
     * @return 队列为空 true 队列不为空 false
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * 打印队列
     */
    public String toString() {
        return linkedList.toString();
    }

}





/**
 * LinkedList模拟栈，先进后出
 * 
 */
class Stack<T> {

    private LinkedList<T> linkedList = new LinkedList<T>();

    /**
     * 进栈
     * 
     * @param t
     *            进栈的元素
     */
    public void push(T t) {
        linkedList.addFirst(t);
    }

    /**
     * 出栈
     * 
     * @return 出栈的元素
     */
    public T pop() {
        return linkedList.removeFirst();
    }

    /**
     * 销毁栈
     */
    public void destroyStack() {
        linkedList.clear();
    }

    /**
     * 查看栈顶元素
     * 
     * @return 栈顶的元素
     */
    public T stackFirst() {
        return linkedList.getFirst();
    }

    /**
     * 查看栈底元素
     * 
     * @return 栈底的元素
     */
    public T stackLast() {
        return linkedList.getLast();
    }

    /**
     * 查看栈长度
     * 
     * @return 栈的长度
     */
    public int stackLength() {
        return linkedList.size();
    }

    /**
     * 判断栈是否为空
     * 
     * @return 栈为空 true 栈不为空 false
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * 打印栈
     */
    public String toString() {
        return linkedList.toString();
    }

}












class User {
    private int id;
    private String account;
    private String password;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        super();
    }

    public User(int id, String account, String password, String name) {
        super();
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + "]";
    }

}


