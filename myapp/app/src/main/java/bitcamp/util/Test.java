package bitcamp.util;

public class Test {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add(new String("aaa")); // aaa,
    list.add(new String("bbb")); // aaa, bbb,
    list.add(new String("ccc")); // aaa, bbb, ccc,
    list.add(new String("ddd")); // aaa, bbb, ccc, ddd,

    System.out.println(list.remove("xxx")); // aaa, bbb, ddd,
    System.out.println(list.remove("ccc"));
    System.out.println(list.remove("ddd"));
    System.out.println(list.remove("aaa"));
    System.out.println(list.remove("bbb"));

    list.add(new String("aaa")); // aaa,
    list.add(new String("bbb")); // aaa, bbb,
    list.add(new String("ccc")); // aaa, bbb, ccc,
    list.add(new String("ddd")); // aaa, bbb, ccc, ddd,


    String[] arr = list.toArray(new String[0]);
    for (String value : arr) {
      System.out.printf("%s, ", value);
    }

//    // 맨 앞
//    list.add(0, new String("xxx")); // xxx, aaa, bbb, ccc, ddd,
//
//    // 맨 뒤
//    list.add(5, new String("yyy")); // xxx, aaa, bbb, ccc, ddd, yyy,
//
//    // 기존 값 자리
//    list.add(1, new String("mmm")); // xxx, mmm, aaa, bbb, ccc, ddd, yyy,
//    list.add(3, new String("ttt")); // xxx, mmm, aaa, ttt, bbb, ccc, ddd, yyy,
//    list.add(7, new String("ppp")); // xxx, mmm, aaa, ttt, bbb, ccc, ddd, ppp, yyy,

//    Object[] arr = list.toArray();
//    for (Object value : arr) {
//      System.out.printf("%s, ", value);
//    }
//    System.out.println();

//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
//    System.out.println(list.get(4));
  }
}
