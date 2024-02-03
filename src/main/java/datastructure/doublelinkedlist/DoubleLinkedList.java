package datastructure.doublelinkedlist;

public class DoubleLinkedList<E> {
  Node<E> head;
  Node<E> tail;

  public static void main(String[] args) {
    DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
    list.insertAtEnd(5);
    list.insertAtEnd(6);
    list.insertAtEnd(7);
    list.insertAtEnd(8);
    list.printFromFront();
    list.printInReverse();
    list.insertAtFront(4);
    list.printFromFront();
    list.printInReverse();
    System.out.println("New List");
    list = new DoubleLinkedList<>();
    list.removeFromBack();
    list.removeFromFront();
    list.delete(7);
    list.insertAtFront(7);
    list.insertAtFront(6);
    list.insertAtFront(5);
    list.insertAtFront(4);
    list.printFromFront();
    list.printInReverse();
    list.insertAtEnd(8);
    list.insertAtEnd(9);
    list.insertAtEnd(10);
    list.insertAtEnd(11);
    list.printFromFront();
    list.printInReverse();
    list.removeFromBack();
    list.removeFromFront();
    list.printFromFront();
    list.printInReverse();
    list.delete(7);
    list.printFromFront();
    list.printInReverse();
    DoubleLinkedList<Integer> newList = new DoubleLinkedList<>();
    newList.delete(89);
    newList.insertAtFront(89);
    newList.insertAtEnd(90);
    newList.delete(89);
    newList.insertAtFront(89);
    newList.delete(90);
    list.printFromFront();
    list.printInReverse();
    System.out.println("Reversing!");
    list.reverse();
    list.printFromFront();
    list.printInReverse();
  }

  private void reverse() {
    Node<E> newTail = head;
    Node<E> newHead = tail;
    //todo remove above
    Node<E> temp = head;
    while (temp != null) {
      Node<E> tempNext = temp.next;
      temp.next = temp.prev;
      temp.prev = tempNext;
      temp = tempNext;
    }
    head = newHead;
    tail = newTail;
  }

  private void delete(E data) {
    if (head == null) {
      System.out.println("Can't delete " + data);
      return;
    }
    Node<E> temp = head;
    while (temp != null) {
      if (temp.data == data) {
        if (head == tail) {
          head = tail = null;
          System.out.println("Deleted -> " + data);
        } else if (temp == head) {
          removeFromFront();
        } else if (temp == tail) {
          removeFromBack();
        } else {
          temp.prev.next = temp.next;
          temp.next.prev = temp.prev;
          temp = null;
          System.out.println("Deleted -> " + data);
        }
      }
      temp = temp != null ? temp.next : null;
    }
  }

  private void removeFromFront() {
    if (head == null) {
      System.out.println("Can't delete jack!");
      return;
    }
    E removedData = head.data;
    head = head.next;
    head.prev = null;
    System.out.println("Delete from front -> " + removedData);
  }

  private void removeFromBack() {
    if (head == null) {
      System.out.println("Can't delete jack!");
      return;
    }
    E removedData = tail.data;
    tail = tail.prev;
    tail.next = null;
    System.out.println("Deleted from back -> " + removedData);
  }

  private void insertAtFront(E data) {
    Node<E> newNode = new Node<>(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      if (head == tail) {
        head.prev = newNode;
      } else {
        head.prev = newNode;
      }
      newNode.next = head;
      head = newNode;
    }
  }

  void insertAtEnd(E data) {
    Node<E> newNode = new Node<>(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      if (head == tail) {
        head.next = newNode;
      } else {
        tail.next = newNode;
      }
      newNode.prev = tail;
      tail = newNode;
    }
  }

  private void printInReverse() {
    StringBuilder res = new StringBuilder();
    Node<E> temp = tail;
    while (temp != null) {
      res.append(temp.data).append(", ");
      temp = temp.prev;
    }
    System.out.println(res.substring(0, res.lastIndexOf(",")));
  }

  private void printFromFront() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    Node<E> temp = head;
    while (temp != null) {
      res.append(temp.data).append(", ");
      temp = temp.next;
    }
    return res.substring(0, res.lastIndexOf(","));
  }

  private class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

//    public Node(Node<E> node) {
//      this(node.data, node.prev, node.next);
//    }

    public Node(E data) {
      this(data, null, null);
    }

    public Node(E data, Node<E> prev, Node<E> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public String toString() {
      return String.format("%s<--prev%ncurrent==%s%nnext-->%s", prev != null ? prev.data : null, data,
          next != null ? next.data : null);
    }
  }
}
