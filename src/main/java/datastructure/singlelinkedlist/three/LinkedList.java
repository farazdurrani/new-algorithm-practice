package datastructure.singlelinkedlist.three;

public class LinkedList<E extends Comparable<E>> {

  private Node<E> first;
  private Node<E> last;

  public void print() {
    if (isEmpty()) {
      System.out.println("List is empty.");
    }
    Node<E> temp = first;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void insertAtFront(E data) {
    Node<E> newNode = new Node<>(data);
    if (first == null) {
      first = last = newNode;
    } else {
      newNode.next = first;
      first = newNode;
    }
  }

  public void insertAtBack(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()) {
      first = last = newNode;
    } else {
      last = last.next = newNode;
    }
  }

  public E removeFromFront() {
    if (isEmpty()) {
      System.out.println("List is empty.");
      return null;
    }
    Node<E> removedNode = first;
    if (first == last) {
      first = last = null;
    } else {
      first = first.next;
    }
    return removedNode.data;
  }

  public E removeFromBack() {
    if (isEmpty()) {
      System.err.println("List is empty.");
      return null;
    }
    Node<E> temp = first;
    if (first == last) {
      first = last = null;
      return temp.data;
    } else {
      while (temp.next != last) {temp = temp.next;}
      last = temp;
      E data = temp.next.data;
      last.next = null;
      return data;
    }
  }

  public boolean delete(E data) {
    if (isEmpty()) {
      System.err.println("List is Empty.");
      return false;
    }
    if (first.data.compareTo(data) == 0) {
      return removeFromFront() != null;
    } else if (last.data.compareTo(data) == 0) {
      return removeFromBack() != null;
    } else {
      Node<E> temp = first;
      while (temp.next != null && temp.next.data.compareTo(data) != 0) {
        temp = temp.next;
      }
      if (temp.next != null && temp.next.data.compareTo(data) == 0) {
        temp.next = temp.next.next;
        return true;
      }
      return false;
    }
  }

  public void reverse() {
    if (isEmpty() || first == last) {
      System.out.println("List is empty or contains a single item.");
      return;
    }
    last = first;
    Node<E> curr = first;
    Node<E> prev = null;
    Node<E> next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    first = prev;
  }

  private class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "Node [data=" + data + ", next=" + (next != null ? next.data : null) + "]";
    }
  }

}
