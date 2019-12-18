/**
 * ObjectList class for a linked list of objects (employees in this case)
 * @author Andrews Samuel
 * @version 23/4/17
 */
public class ObjectList implements ObjectListInterface{
    private ObjectListNode list;
    private ObjectListNode last;
    /**
     * Default constructor for an initially empty linked list
     */
    public ObjectList(){
        list=null;
        last=null;
    }
    /**
     * Method to return first node in linked list
     * @return first node in list
     */
    public ObjectListNode getFirstNode(){
        return list;
    }
    /**
     * Method to return last node in list before null
     * @return last node in list
     */
    public ObjectListNode getLastNode(){
        return last;
    }
    /**
     * Adds a node as first in list
     * @param new node to be placed first in list
     */
    public void addFirst(ObjectListNode p){
        if(p==null){
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if(list==null)
            last=p;
        list=p;
    }
    /**
     * Adds a node at the end of a list before null
     * @param node to be placed at the end of list
     */
    public void addLast(ObjectListNode p){
        if (p==null){
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list==null)
            list=p;
        else
            last.setNext(p);
        last=p;
    }
    /**
     * Eleminates first node in list and returns the object within
     * @return object within the node removed
     */
    public Object removeFirst(){
        if(list==null){
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p=list;
        list=p.getNext();
        if (list==null)
            last=null;
        return p.getInfo();
    }
    /**
     * Eliminates last node in list
     * @return the object contained within the last node that was just removed
     */
    public Object removeLast(){
        if (list==null){
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p=list;
        ObjectListNode q=null;
        while (p.getNext()!=null){
            q=p;
            p=p.getNext();
        }
        if (q==null){
            list=null;
            last=null;
        }    
        else{
            q.setNext(null);
            last=q;
        }    
        return p.getInfo();
    }
    /**
     * Places a node q after node p
     * @param ObjectListNode p the node before new node q
     * @param ObjectListNode q the new node to follow node p
     */
    public void insertAfter(ObjectListNode p,ObjectListNode q){
        if(list==null||p==null||q==null){
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext()!=null)
            last=q;
    }
    /**
     * Removes the node following node p and returns the object within
     * @param ObjectListNode p the node before the one to be deleted
     * @return the object contained within the node following node p
     */
    public Object deleteAfter(ObjectListNode p){
        if(list==null||p==null||p.getNext()==null){
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q=p.getNext();
        p.setNext(q.getNext());
        if (p.getNext()==null)
            last=p;
        return q.getInfo();
    }
    /**
     * Inserts a new node r into its proper place in a sorted list
     * @param ObjectListNode r to be inserted into its place in sorted list
     */
    public void insert(ObjectListNode r){
        ObjectListNode p=list;
        ObjectListNode q=null;
        while(p!=null&&((Comparable)r.getInfo()).compareTo(p.getInfo())>0){
            q=p;
            p=p.getNext();
        }
        if (q==null)
            addFirst(r);
        else
            insertAfter(q,r);
    }
    /**
     * Removes first occurance of object o from list
     * @param Object o the object to be found and removed
     * @return object contained within the node removed, null if not present
     */
    public Object remove(Object o){
        ObjectListNode p=list;
        ObjectListNode q=null;
        while(p!=null&&((Comparable)o).compareTo(p.getInfo())!=0){
            q = p;
            p = p.getNext();
        }
        if (p==null)
            return null;
        else return q==null?removeFirst():deleteAfter(q);
    }
    /**
     * Returns the node with the first occurence of object
     * @param object sought
     * @return the sought after object, null if not present
     */
    public ObjectListNode select(Object o){
        ObjectListNode p=list;
        while (p!=null)
            if (((Comparable)o).compareTo(p.getInfo())==0)
                return p;
            else
                p=p.getNext(); 
        return null;
    }
    /**
     * Determines if a list is empty or not
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty(){
        return list==null;
    }
    /**
     * clears a list of all nodes
     */
    public void clear(){
        list=null;
        last=null;
    }
    /**
     * Determines the number of nodes contained within a list
     * @return the number of nodes within this list
     */
    public int size(){
        int count=0;
        ObjectListNode p=list;
        while (p!=null){
            ++count;
            p=p.getNext();
        }
        return count;
    }
    /**
     * Allocates memory for an entirely new list that is a duplicate of this list
     * @return new list with same content as this list, just occupying different memory locations
     */
    public ObjectList copyList(){
        ObjectListNode p=null; 
        ObjectListNode q=null; // to satisfy compiler;
        ObjectListNode r=list;   
        if (isEmpty())
            return null;
        ObjectList newList=new ObjectList();
        while (r != null){
            p=new ObjectListNode(r.getInfo());
            if(newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p); 
            q=p;
            r=r.getNext();
        }
        newList.last=p;
        return newList;
    }
    /**
     * Reverses the order of all nodes within list without changing the content
     */
    public void reverse(){
       ObjectListNode p=list;
       ObjectListNode q=null;
       ObjectListNode r;
       while(p!=null){
            r=q;
            q=p;
            p=p.getNext();
            q.setNext(r);
       }
       last=list;
       list=q;
    }
    /**
     * Sorts the objects in the list according to compareTo(Object) implementation
     */
        public void sort(){
        ObjectListNode p,q,r,s;
        ObjectList newList=new ObjectList();
        Comparable e,f;
        while(list!=null){
            q=list;
            p=q.getNext();
            r=q;
            s=q;
            while(p!=null){
                e=(Comparable)p.getInfo();
                f=(Comparable)r.getInfo();
                if(f.compareTo(e)<0){
                    s=q;
                    r=p;
                }
                else if(f.compareTo(e)==0&&f.compareTo(e)<0){
                    s=q;
                    r=p;
                }
                q=p;
                p=p.getNext();
            }
            if(r==list)
                newList.addFirst(new ObjectListNode(this.removeFirst()));
            else
                newList.addFirst(new ObjectListNode(this.deleteAfter(s)));
        }
        list=newList.getFirstNode();
        q=list;
        p=list.getNext();
        while(p!=null){
            q=p;
            p=p.getNext();
        }
        last=q;
    }
}