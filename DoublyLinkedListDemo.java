  import java.util.*;
  class Node
  {
      public Node prev;
      public int data;
      public Node next;
  }

  class DoublyLinkedList
  {
      private Node start;
      private Node end;

      public DoublyLinkedList() {
        start =null;
        end = null;
  
      }

      //insert at any beginning fuction
      public void insertAtBeg(int item)
      {
          //making the newnode
        Node newnode = new Node();
        //if newnode's next is not null and contains the adress of the start
        if(start == null)
         {
         newnode.data=item;
         newnode.prev=newnode.next =null;
        //updating the start
         start = newnode;
         end = newnode;
        }
        //case if the newnode next is null
         
         else{
             newnode.data=item;
             newnode.prev=null;
             newnode.next = start;
             start.prev = newnode;
             start = newnode;
         }
      }
      public void traverseFromStart()
      {

        //checking for if the list is empty 
        if(start == null && end == null)
        {
            System.out.println("\n Empty Doubly Linked List");
            return;
        }
        System.out.println("list contains the following items");
        Node tra = start ;
       // Node tra1 =end;

        while(tra!=null)
        {
            
            System.out.println(tra.data);
            tra = tra.next;            
        }
    }

        public void traverseFromEnd()
        {
            if( start== null && end == null)
            {
                System.out.println("\nEmpty Doubly linked list");
                return;
            }
            System.out.println("List contains the following items");
            
            Node tra = end;
             
            while(tra!=null)
            {
                System.out.println(tra.data);
                tra = tra.prev;
            }
        }

        public void insertAtEnd(int item)
        {
          //making the newnode
            Node newnode = new Node();
            //if newnode's next is not null and contains the adress of the start
            if(start == null)
            {
                newnode.data=item;
                newnode.prev=newnode.next =null;
                //updating the start
                start = newnode;
                end = newnode;
            }
            else
            {
                newnode.data = item;
                newnode.next = null;
                newnode.prev = end;
                end.next = newnode;
                end = newnode;
            }
        }
        public int countNode()
        {
            
            Node tra = start;
            int count=0;
            while(tra!= null)
            {
                count++;
                //as tra refers start so we checking wehen will start.next will get null 
                tra = tra.next;
            }
            return count;
        }

      public void insertAtPos(int item , int pos)
      {
        // checking if the pos enter is correct or not
        if(pos<=0 || pos >countNode())
        {
            return;
        }
       
            Node newnode = new Node();
            Node tra = start ;
            for(int i =1 ; i<pos-1 ;i++)
            {
                tra = tra.next;
               // tra = tra.prev;
            }

            newnode.next=tra.next;
            newnode.prev = tra;

             tra.next=newnode;
             newnode.next.prev= newnode;
            newnode.data = item;
      }
      public void deleteAtAnyPos(int pos)

      {
        //checking if the pos is correct or not
        if(pos<=0 || pos>countNode())
        {
            return;
        }

        Node tra = start;
 
        for(int  i=1;i<pos-1 ; i++)
        {
            tra = tra.next;
        }
        Node node_to_del ;

        
        node_to_del = tra.next;
        
        tra.next = tra.next.next;
        tra.next.prev = tra;
        node_to_del.next = node_to_del.prev = null;
        
        node_to_del=null;

      }
        public void deleteFromBeg()
        {
           // checking for underflow
           if( start == null)
           {
               System.out.println("underflow linked list");
               return ;
           }
           
           if(start == end && start.next ==  null && end.prev == null)
           {
               //if singly linked list make start and end null and make them empty linked list 
                start = null;
                end = null;
           }
           else
           {
                Node node_to_del = start;
                // updatin the start with the getnext means adress of second node 
                start = start.next ;
                start.prev = null;
                // upadting the next of the node or first node to null
                node_to_del.next = null;
                // deleting the link between the node and the second node and now start with refer to second node
                node_to_del = null;

                
           }
        }
           public void deleteFromEnd()
           {

            //checking for underflow 
            if(start == null)
            {
                System.out.println("udnerflow linked list");
                return;
            }

            //if the linked list is singly make it empty linked list
            if(start == end && start == null && end == null)
            {
                start = null;
                end = null;
            }
            else
            {
                Node node_to_del = end ;
                end = end.prev;
                end.next = null;
                node_to_del.prev = null;
                node_to_del = null;
            }
           }
        
  }


  class DoublyLinkedListDemo
  {
      public static void main(String args[])
      {
          DoublyLinkedList list =  new DoublyLinkedList();
          Scanner sc = new Scanner(System.in);
          
        while (true)
        {
            System.out.println("\nPress 1 to insert elements at the beginning");
            System.out.println("\nPress 2 to traverse the doubly linked list from start");
            System.out.println("\nPress 3 to traverse the doubly linked list from end");
            System.out.println("\nPress 4 to insert elements at the end");
            System.out.println("\nPress 5 to delete item from the beignning");
            System.out.println("\nPress 6 to delete item from the end");
            System.out.println("\nPres 7 to insert item at any position");
            System.out.println("\nPres 8 to delete item at any position");
            System.out.println("\nPress 9 to end");
            int item,pos;
            int choice = sc.nextInt();
            switch(choice)
            {
               case 1:
                System.out.println("Enter the number to be inserted");
                item = sc.nextInt();
                list.insertAtBeg(item);
                break;
                case 2:
                list.traverseFromStart();
                break;
                case 3:
                list.traverseFromEnd();
                break;
                case 4:
                System.out.println("Enter the number to be inserted at the end");
                item = sc.nextInt();
                list.insertAtEnd(item);
                break;
                case 5:
                System.out.println("\nItem have been deletd from the beginning");
                list.deleteFromBeg();
                break;
                case 6:
                System.out.println("\nItem have been deletd from the end");
                list.deleteFromEnd();
                break;
                case 7:
                System.out.println("\nEnter item which you wnats to add and which position");
                item = sc.nextInt();
                pos=sc.nextInt();
                list.insertAtPos(item, pos);
                break;
                case 8:
                System.out.println("\nEnter the position from where u wanted to deletethe item");
                pos=sc.nextInt();
                list.deleteAtAnyPos(pos);
                break;
                case 9:
                System.exit(0);
                break;
                default:
                System.out.println("\nwrong choice");
            }


        }
      }
  }