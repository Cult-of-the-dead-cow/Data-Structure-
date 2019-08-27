import java.util.Scanner;


//node definition
class Node {
    private int data;
    private Node next;
    
    public void setData(int data) {
        this.data = data;
    }
    public int getData() {
        return this.data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return this.next;
    }
}

//LinkedList class
class SinglyLinkedList {
    private Node start;
    public SinglyLinkedList() {
        //empty the linked list
        start = null;
    }
    public void insertAtBeg(int item) {
        //create a new node
        Node newnode = new Node(); 

        //fill up the newnode
        //newnode's data
        newnode.setData(item);
        //newnode's next
        newnode.setNext(start);
        //update start
        start = newnode;
    }
    public void traverse() {
        //check for emmpty list
        if(start == null) {
            System.out.println("Empty Linked List");
            return;
        }

        System.out.println("The Linked List contents:");
        //declare a reference object for traversal & init. it from the start
        Node tra = start;

        //iterate till the end
        while(tra!=null) {
            //display the data of the current node
            System.out.println(tra.getData());
            //move the traversal reference object to the next
            tra = tra.getNext();
        }
    }

    public void insertAtEnd(int item) {
        //create a new node
        Node newnode = new Node();

        //fill up the data in the newnode
        newnode.setData(item);
        //fill null in the newnode's next
        newnode.setNext(null);

        //check insertion cases:
        if(start == null) {
            //empty list insertion case
            //refer the newnode to the start
            start = newnode;
        }
        else {
            //non empty list insertion case
            //traverse till the current last node
            //declare a reference object for traversal & init. it from start
            Node tra = start;
            //iterate till the last node is reached
            while(tra.getNext() != null) {
                //move the traversal referece to the next object
                tra = tra.getNext();
            }
            //update the current last node's next with the newnode
            tra.setNext(newnode);
        }
    }
    public void deleteFromBeg()
    {
        //check for underflow
        //underflow is when we are trying to delete from an empty list
        //check for empty linked list
        if(start == null)
        {
            System.out.println("Underflow!");
            return;
        }

        //check cases
        if(start.getNext() == null)
        {
            //delete from single node linked list
            //update the start and empty the list
            start = null;
        
        }
        else
        {
            //delete from multi node linked list
            //declare a reference object for deletion
            Node node_to_del;
            //init. the node to del reference object with start
            node_to_del = start;
            //update the start and refer it to the current second node
            start = start.getNext();
            //remove the link between the old start node and the new start node
            node_to_del.setNext(null);
            //delete the node
            node_to_del = null;
        }
    }

    public void deleteFromEnd()
    {
        //check for underflow
        //underflow is when we are trying to delete from an empty list
        //check for empty linked list
        if(start == null)
        {
            System.out.println("Underflow!");
            return;
        }
        //check cases
        if(start.getNext() == null)
        {
            //delete from single node linked list
            //update the start and empty the list
            start = null;
        
        }
        else
        {
            //delete from multiple node linked list
            //traverse till the current second last node
            //declare a reference for traversal
            Node tra;
            //initil this traversal reference from start
            tra = start;
            //traverse
            while(tra.getNext().getNext() != null)
            {
                //move the traversal reference to the next node
                tra = tra.getNext();
            }
            //declare a reference for deleteion
            Node node_to_del;
            //store the last node as the deleteion node
            node_to_del = tra.getNext();
            //update the current 2nd last node with null
            tra.setNext(null);
            //delete the node
            node_to_del = null;
        }
    }
   
    public int countNode()
    {
        int count=0;
        Node tra = start;
        while(tra != null )
            {
                
                count++;
                tra = tra.getNext();
                
            }
        return count;
    }
    public void deleteFromAnyPosition(int pos)

    {
     
     
     if (pos <=0 || pos >countNode())
        {
             return;
        }
     Node tra = start;
     for(int i=1;i<pos-1;i++)
        
        {
            tra = tra.getNext();
        }
        //declare a reference obect for deleteion and store the pos item in it
        Node node_to_del = tra.getNext();
        //store the pos+1 item's addess in pos-1 item's next
        tra.setNext(tra.getNext().getNext());
        //delete the node
        node_to_del = null;
    }
    public void insertAtAnyPosition(int item, int pos)
        {
            Node newnode = new Node();

            newnode.setData(item);

            //check the validity of pos
            if(pos <= 0 || pos > countNode()) {
                return;
            }
            
            //traverse till pos -1
            //declare a ref for traversal & init. it from start
            Node tra = start;
            for (int i=1; i < pos-1 ;i++)
            {
                tra = tra.getNext();
            }

            //store the current pos node's address in newnode's next
            newnode.setNext(tra.getNext());
            //update the current pos-1 node's next
            tra.setNext(newnode);
            
        }


}


class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("\nWelcome to the Singly Linked List Program:");
            System.out.println("\nPress 1 to insert item at beg:");
            System.out.println("\nPress 2 to insert item at end:");
            System.out.println("\nPress 3 to insert item at any position:");
            System.out.println("\nPress 4 to traverse:");
            System.out.println("\nPress 5 to delete from beginning:");
            System.out.println("\nPress 6 to delete from end:");
            System.out.println("\nPress 7 to delete from At any position:");
            System.out.println("\nPress 9 to exit:");
            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            int item , pos;
            switch(choice) {
                case 1:
                    System.out.println("\nEnter item to be inserted at beg: ");
                    item = sc.nextInt();
                    list1.insertAtBeg(item);
                    break;
                case 2:
                    System.out.println("\nEnter item to be inserted at end: ");
                    item = sc.nextInt();
                    list1.insertAtEnd(item);
                    break;
                case 3:
                    System.out.println("\nEnter the position item to be inserted: ");
                    item = sc.nextInt();
                    pos = sc.nextInt();
                    list1.insertAtAnyPosition(item , pos);
                    break;
                case 4:
                    list1.traverse();
                    break;
                case 5:
                    System.out.println("\nItem have been deleted from the begining");
                    list1.deleteFromBeg();
                    break;
                case 6:
                    System.out.println("\nItme have been deleted from the end");
                    list1.deleteFromEnd();
                    break;
                case 7:
                    System.out.println("\nItem have been deleted from the position you have enetered");
                    pos=sc.nextInt();
                    list1.deleteFromAnyPosition(pos);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nWrong Choice!");
                    break;
            }
        }
    }
}