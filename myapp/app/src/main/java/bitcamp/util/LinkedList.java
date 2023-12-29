package bitcamp.util;

import java.util.Arrays;

public class LinkedList<E> extends AbstractList<E> {
  private Node<E> first;
  private Node<E> last;


  public void add(E value) {
    Node<E> node = new Node<E>();
    node.value = value;

    if (last == null) {
      // 노드 객체가 없을 때,
      first = last = node;
    } else {
      // 기존에 노드 객체가 있을 때,
      // 마지막 노드의 다음 노드로 새로 만든 노드를 가리키게 한다.
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    int index = 0;
    Node<E> node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    return node.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    E old = node.value;
    node.value = value;
    return old;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node node = new Node();
    node.value = value;

    if (first == null) {
      first = last = node;

    } else if (index == 0) {
      node.next = first;
      first = node;

    } else if (index == size) {
      last.next = node;
      last = node;

    } else {
      int cursor = 0;
      Node currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }



  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    // 삭제될 노드객체
    Node<E> deleted = null;

    if (size == 1) {
      deleted = first;
      first = last = null;

    } else if (index == 0) {
      deleted = first;
      first = first.next;

    } else {
      int cursor = 0;
      Node<E> currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      deleted = currNode.next;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }
    size--;

    //가비지가 되기 전에 다른 객체를 참조하던 것을 제거한다.
    E old = deleted.value;
    deleted.value = null;
    deleted.next = null;
    return old;
  }

  public boolean remove(E value){
    Node<E> prevNode = null;
    Node<E> node = first;
    while (node != null) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
      node = node.next;
    }
    // 일치하는게 없을때
    if (node == null){
      return false;
    }
    // 일치하는게 처음에있을때
    if (node == first){
      first = node.next;

      // 일치하는게 처음인데 size가1일때
      if( first == null){
        last = null;

      }
    } else{
      prevNode.next = node.next;
    }
    size --;
    return true;
  }

  public E[] toArray(final E[] arr){
    E[] values = arr;
    if (arr.length < size){
      values = Arrays.copyOf(arr, size);
    }

    int i = 0;
    Node<E> node = first;
    while (node != null){
      values[i++] = node.value;
      node = node.next;
    }

    return values;
  }


  private static class Node<E> {
    E value;
    Node<E> next;
  }

//  // 1) 패키지 멤버 클래스로 Iterator 구현하기
//  @Override
//  public Iterator<E> iterator() {
//    return new LinkedListIterator<>(this);
//  }

//  // 2) static inner 클래스로 Iterator 구현하기
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(this);
//  }
//  private static class IteratorImpl<E> implements Iterator<E>{
//    LinkedList<E> list;
//    int cursor;
//
//    public IteratorImpl(LinkedList<E> list){
//      this.list = list;
//    }
//
//    @Override
//    public boolean hasNext() {
//      return cursor >= 0 && cursor < list.size();
//    }
//
//    @Override
//    public E next() {
//      return list.get(cursor++);
//    }
//  }

//  // 3) non-static 클래스로 Iterator 구현하기
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>();
//  }
//  private class IteratorImpl<E> implements Iterator<E>{
//
//    Node<E> cursor;
//    public IteratorImpl(){
//      this.cursor = (Node<E>) LinkedList.this.first;
//    }
//
//    @Override
//    public boolean hasNext() {
//      return cursor != null;
//    }
//
//    @Override
//    public E next() {
//      E value = cursor.value;
//      cursor = cursor.next;
//      return value;
//    }
//  }

//  // 4) 로컬클래스로 Iterator 구현하기
//  @Override
//  public Iterator<E> iterator() {
//
//    class IteratorImpl<E> implements Iterator<E> {
//
//      Node<E> cursor;
//
//      public IteratorImpl() {
//        this.cursor = (Node<E>) LinkedList.this.first;
//      }
//
//      @Override
//      public boolean hasNext() {
//        return cursor != null;
//      }
//
//      @Override
//      public E next() {
//        E value = cursor.value;
//        cursor = cursor.next;
//        return value;
//      }
//    }
//    return new IteratorImpl<>();
//  }

  // 5) 익명개체로 Iterator 구현하기
  @Override
  public Iterator<E> iterator() {

    return new Iterator<E>(){

      Node<E> cursor = (Node<E>) LinkedList.this.first;

      @Override
      public boolean hasNext() {
        return cursor != null;
      }

      @Override
      public E next() {
        E value = cursor.value;
        cursor = cursor.next;
        return value;
      }
    };
  }

}

