/**
 * Interface class for ObjectList class, see ObjectList class for method descriptions
 * @author Andrews Samuel
 * @version 23/4/17
 */
public interface ObjectListInterface{
    public ObjectListNode getFirstNode();
    public ObjectListNode getLastNode();
    public void addFirst(ObjectListNode p);
    public void addLast(ObjectListNode p);
    public Object removeFirst();
    public Object removeLast();
    public void insertAfter(ObjectListNode p,ObjectListNode q);
    public Object deleteAfter(ObjectListNode p);
    public void insert(ObjectListNode r);
    public Object remove(Object o);
    public ObjectListNode select(Object o);
    public boolean isEmpty();
    public void clear();
    public int size();
    public ObjectList copyList();
    public void reverse();
    public void sort();
}