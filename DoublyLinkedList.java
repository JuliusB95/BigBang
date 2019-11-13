/**
 * Hochschule Harz
 * Fachbereich Automatisierung und Informatik
 * Prof. Dr. Bernhard Zimmermann
 * 
 * LV "Algorithmen" WiSe 2019
 *
 * Problem: ...
 * 
 * @author Behr Julius, Ralfs Torben
 * @version 1.0
 * 
 **/
package Lists;
public class DoublyLinkedList extends List {
  
  Listnode last  = null;
  
  protected class DLListnode extends Listnode{
    Listnode pred = null;
    DLListnode(Object val, Listnode next, Listnode pred){
      super(val,next);
      this.pred=pred;
    }
    
  }
  


  public boolean existActListnodePredecessor() {
    if(cursor==null)
      return false;
    if(((DLListnode)cursor).pred==null)
      return false;
    return true;
  }
  
  public void processListnodesReverse() {
    // TODO Auto-generated method stub
    for(DLListnode current=((DLListnode)last);current!=null;current=((DLListnode)current.pred)) {
      current.process();
    }
  }

  public void findReverse(Object val) {
    // TODO Auto-generated method stub
    for(last();cursor!=null&&!cursor.val.equals(val);pred());
  }



  public void setValPred(Object val) {
    // TODO Auto-generated method stub
    if(cursor!=null&&((DLListnode)cursor).pred!=null) {
      ((DLListnode)cursor).pred.val=val;
    }else {
      System.out.println("setValPred: Der Vorgaenger des aktuellen Listenknotens existiert nicht.");
    }
  }

  public Object getValPred() {
    // TODO Auto-generated method stub
    if(existActListnodePredecessor())
      return ((DLListnode)cursor).pred.val;
    return null;
  }

  
  public void last() {
    // TODO Auto-generated method stub
    cursor=last;
  }
  

  public void next() {
    if(hasActListnode())
      cursor=cursor.next;
  }

  public void pred() {
    // TODO Auto-generated method stub
    if(hasActListnode())
      cursor=((DLListnode)cursor).pred;
  }
  
  
  public void deleteLast() {
    // TODO Auto-generated method stub
    if(!isEmpty()) {
      if(last==first) {
        last=null;
        first=null;
        cursor=null;
    }
    else {
        Listnode del = last;
        last=((DLListnode)last).pred;
        if(cursor==last.next)
          cursor=null;
        last.next=null;
        del.next=null;
        ((DLListnode)del).pred=null;
      }
    }else {
      System.out.println("deleteLast: Die Liste ist leer.");
    }
  }

  public void deleteBefore() {
    
    if(existActListnodePredecessor()) {
      if(first.val.equals(cursor.val))
        first=first.next;
      Listnode del = ((DLListnode)cursor).pred;
      ((DLListnode)((DLListnode)cursor).pred).pred.next=((DLListnode)cursor).pred.next;
      ((DLListnode)cursor).pred=((DLListnode)((DLListnode)cursor).pred).pred;
      del.next=null;
      ((DLListnode)del).pred=null;
    }else {
      System.out.println("deleteBefore: Der Vorgänger des aktuellen Listenknotens existiert nicht.");
    }
    
}

  public void delete() {
    DLListnode del = ((DLListnode)cursor);
    if(cursor.val.equals(first.val))
      first=first.next;
    if(existActListnodeSuccessor()) {
      ((DLListnode)cursor.next).pred=((DLListnode)cursor).pred;
      if(existActListnodePredecessor())
        ((DLListnode)cursor).pred.next=((DLListnode)cursor).next;
      cursor=((DLListnode)cursor).next;
      del.next=null;
      del.pred=null;
    }else System.out.println("delete: Es gibt keinen aktuellen Listenknoten oder \r\n" + 
        "        dieser Listenknoten hat keinen Nachfolger.");
  }
  
  public void deleteAfter() {
    if(existActListnodeSuccessor()) {
      if(last.val.equals(cursor.next.val))
        last=((DLListnode)last).pred;
      Listnode del = ((DLListnode)cursor).next;
      if(cursor.next.next!=null)
        ((DLListnode)cursor.next.next).pred=((DLListnode)cursor.next).pred;
      cursor.next=cursor.next.next;
      del.next=null;
      ((DLListnode)del).pred=null;
    }else {
      System.out.println("deleteAfter: Der Nachfolger des aktuellen Listenknotens existiert nicht.");
    }
    
  }
  
  public void deleteFirst() {
    if(!isEmpty()) {
      if (cursor == first)
        cursor = null;
      DLListnode del = (DLListnode) first;
      first = first.next;
      ((DLListnode)first).pred = null;
      del.pred = null;
      del.next = null;
    }else System.out.println("deleteFirst: Die Liste ist leer.");
  }


  public void insertBefore(Object val) {
    if(hasActListnode()) {
      ((DLListnode)cursor).pred = new DLListnode (val, cursor, ((DLListnode)cursor).pred);
      if(((DLListnode)((DLListnode)cursor).pred).pred!=null)
        ((DLListnode)((DLListnode)cursor).pred).pred.next=((DLListnode)cursor).pred;
      cursor=((DLListnode)cursor).pred;
    }else if(isEmpty()) {
      last=first=cursor = new DLListnode (val,null,null);
    }else System.out.println("insertBefore: Die Liste ist nicht leer und hat keinen aktuellen Listenknoten.");
    if(((DLListnode)first).pred!=null)first=((DLListnode)first).pred;
  }
  
  public void insertAfter(Object val) {
    if(hasActListnode()) {
      Listnode temp = cursor.next;
      cursor.next = new DLListnode (val, temp, cursor);
      if(cursor.next.next!=null)
        ((DLListnode)cursor.next.next).pred=((DLListnode)cursor.next);
    }else if(isEmpty()) {
      last = first = cursor = new DLListnode (val,null,null);
    }else System.out.println("insertAfter: Die Liste ist nicht leer und hat keinen aktuellen Listenknoten.");
    if(last.next!=null)last=last.next;
  }
  
  public void processListnodes() {
    for(DLListnode current=((DLListnode)first);current!=null;current=(DLListnode) current.next) {
      current.process();
    }
  }
}


