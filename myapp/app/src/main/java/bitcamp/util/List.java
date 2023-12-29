package bitcamp.util;

public interface List<E> {

  public void add(E object);

  public E remove(int index);

  public boolean remove(E value);

  public Object[] toArray();

  public E[] toArray(E[] arr);

  public E get(int index);

  E set(int index, E object);

  int size();

  Iterator<E> iterator();
}
