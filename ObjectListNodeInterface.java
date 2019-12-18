/**
 * Interface Class for ObjectListNode, see ObjectListNode class for method descriptions
 * @author Andrews Samuel
 * @version 23/4/17
 */
public interface ObjectListNodeInterface{
    public void setInfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
}