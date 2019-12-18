/**
 * class for nodes for linked list class
 * @author Andrews Samuel
 * @version 23/4/17
 */
public class ObjectListNode implements ObjectListNodeInterface{
    private Object info;
    private ObjectListNode next;
    /**
     * Default constructor
     */
    public ObjectListNode(){
        info=null;
        next=null;
    }
    /**
     * Constructor that initializes an object within the node
     * @param object to be contained within this node
     */
    public ObjectListNode(Object o){
        info=o;
        next = null;
    }
    /**
     * Constructor that initializes both the object contained as well as the next node in list
     * @param object to be contained in this node, next node to follow
     */
    public ObjectListNode(Object o,ObjectListNode p){
        info=o;
        next=p;
    }
    /**
     * Sets object in this node
     * @param Object to be placed in this node
     */
    public void setInfo(Object o){
        info=o;
    }
    /**
     * Returns the object contained within this node
     * @return the object contained in this node
     */
    public Object getInfo(){
        return info;
    }
    /**
     * Sets the next node to succeed this node
     * @param next node to follow this node
     */
    public void setNext(ObjectListNode p){
        next=p;
    }
    /**
     * Returns next node in sequence
     * @return the following node
     */
    public ObjectListNode getNext(){
        return next;
    }
}