package bitcamp.util;

public class Test {
  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    Node node = list.first;
    System.out.println(node.value);
    node = node.next;
    System.out.println(node.value);
    node = node.next;
    System.out.println(node.value);
    node = node.next;
    System.out.println(node.value);
  }
}
