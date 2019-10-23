package com.pcz.list;

/**
 * @author picongzhi
 */
public class SinglyLinkedList {
    /**
     * 头结点
     */
    private Node head;

    /**
     * 链表长度
     */
    private int size;

    public SinglyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /**
     * 获取position位置上的数据
     *
     * @param position 位置
     * @return 数据
     */
    public int get(int position) {
        checkBounds(position, 0, size - 1);

        Node cur = head.next;
        for (int i = 0; i < position; i++) {
            cur = cur.next;
        }

        return cur.value;
    }

    /**
     * 往链表头添加一个节点
     *
     * @param data 数据
     */
    public void insertHead(int data) {
        insertNth(data, 0);
    }

    /**
     * 往链表最后添加一个节点
     *
     * @param data 数据
     */
    public void insert(int data) {
        insertNth(data, size);
    }

    /**
     * 删除第一个节点
     */
    public void deleteHead() {
        deleteNth(0);
    }

    /**
     * 删除最后一个节点
     */
    public void delete() {
        deleteNth(size - 1);
    }

    /**
     * 往队列的第position个位置插入一个数据
     *
     * @param data     数据
     * @param position 位置(0~size)
     */
    public void insertNth(int data, int position) {
        checkBounds(position, 0, size);

        Node cur = head;
        for (int i = 0; i < position; i++) {
            cur = cur.next;
        }

        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    /**
     * 删除第position个位置的元素
     *
     * @param position 位置(0~size)
     */
    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);

        Node cur = head;
        for (int i = 0; i < position; i++) {
            cur = cur.next;
        }

        Node deleted = cur.next;
        cur.next = cur.next.next;
        deleted = null;
        size--;
    }

    /**
     * 检查位置是否合法
     *
     * @param position 位置
     * @param low      下边界
     * @param high     上边界
     */
    private void checkBounds(int position, int low, int high) {
        if (position < low || position > high) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /**
     * 清空链表
     * (直接 head.next = null; size = 0 即可？？？)
     */
    public void clear() {
        if (size == 0) {
            return;
        }

        Node prev = head.next;
        Node cur = prev.next;
        while (cur != null) {
            prev = null;
            prev = cur;
            cur = cur.next;
        }

        prev = null;
        head.next = null;
        size = 0;
    }

    /**
     * 判断链表是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取链表长度
     *
     * @return 长度
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        Node cur = head.next;
        while (cur != null) {
            stringBuilder.append(cur.value).append("->");
            cur = cur.next;
        }

        return stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "").toString();
    }

    class Node {
        /**
         * 值
         */
        int value;

        /**
         * 下一个节点
         */
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
