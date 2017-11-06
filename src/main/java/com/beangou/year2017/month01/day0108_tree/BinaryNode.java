package com.beangou.year2017.month01.day0108_tree;

/**
 * Created by liutb on 2017/1/8.
 *
 * @since 1.0.0
 */
public class BinaryNode<T> {
    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T element) {
        this(element, null, null);
    }

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
