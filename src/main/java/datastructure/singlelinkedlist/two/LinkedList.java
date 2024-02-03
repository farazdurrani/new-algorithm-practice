package datastructure.singlelinkedlist.two;

public class LinkedList<E extends Comparable<E>> {

  private Node<E> first;
  private Node<E> last;

  public void print() {

  }

  public boolean isEmpty() {
    return false;
  }

  public void insertAtFront(E data) {

  }

  public void insertAtBack(E data) {

  }

  public E removeFromFront() {
    return null;
  }

  public E removeFromBack() {
    return null;
  }

  public boolean delete(E data) {
    return false;
  }

  public void reverse() {

  }

  private class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "Node [data=" + data + ", next=" + (next != null ? next.data : "") + "]";
    }

  }

}
