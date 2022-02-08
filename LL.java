package sll;




public class LL {

    Node head,tail;
     int size;

    public LL() {
        this.size=0;
    }


    public void insertAtStart(int data){
        Node node=new Node(data);
        node.next=head;
        head=node;
        if (tail==null){
            tail=head;
        }
        size++;
    }

    public void insertAtLast(int data){
        if (tail==null){
            insertAtStart(data);
        }
        Node node=new Node(data);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insertAtIndex(int data,int index){
        if (index==0){
            insertAtStart(data);
            return;
        }
        if (index==size){
            insertAtLast(data);
            return;
        }
        Node temp=head;
        for (int i = 1; i <index ; i++) {
            temp=temp.next;
        }
        Node node=new Node(data,temp.next);
        temp.next=node;
        size++;
    }

    public int deleteStart(){
        int val=head.data;
        head=head.next;
        if (size==0){
            System.out.println("list is empty");
            return 0;
        }
        if (head==null){
            tail=null;
        }
        size--;
        return val;

    }
    public int deleteLast(){
        if (size<=1){
            deleteStart();
        }
        Node secondLast=get(size-2);
        int val=tail.data;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;
    }


    private Node get(int index) {
        Node node=head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public int deleteAtIndex(int index){
        if (index==0){
            deleteStart();
        }
        if (index==size-1){
            deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.data;
        prev.next=prev.next.next;
        size--;
        return val;
    }

    public boolean searchNode(int data){
        Node temp=head;
        while (temp!= null){
            if (temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void makeCycle(int index){
        Node cNode=get(index);
        tail.next=cNode;
    }
        //detect loop
    public boolean detectLoop(){
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;

            }

        }
        return false;
    }
        //finding the length of the loop
    public int lengthOfLoop() {
       Node slow=head;
       Node fast=head;
       while (fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if (slow==fast){
               Node temp=slow;
               int length=0;
               do {
                   temp=temp.next;
                   length++;
               }while (temp!=slow);
               return length;
           }

       }

        return 0;

    }
        //return meet point to break the loop
    public Node loopStartNode(){
        Node fast=head;
        Node slow=head;
        int length=0;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                length=lengthOfLoop();
                break;
            }
        }
        if (length==0){
            return null;
        }

        Node first=head;
        Node second=head;
        while (length>0){
            first=first.next;
            length--;
        }

        while (first!=second){
            first=first.next;
            second=second.next;
        }
        return first;
       // return first.data;//when we want to return the data
    }
        //break loop
    public boolean breakLoop(Node node){
        Node temp=node;
        do{
            temp=temp.next;
        }while (temp.next!=node);
        Node prev=temp;
        prev.next=null;
        return true;
    }

    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LL list=new LL();

        list.insertAtStart(12);
        list.insertAtStart(14);
        list.insertAtStart(18);
        list.insertAtStart(27);

        list.insertAtLast(99);

        list.insertAtIndex(10,3);


//        System.out.println(list.deleteStart());
//
//        System.out.println(list.deleteLast());
//
//        System.out.println(list.deleteAtIndex(1));
//
//        System.out.println(list.searchNode(10));

        list.makeCycle(2);
        System.out.println(list.detectLoop());

        System.out.println(list.lengthOfLoop());

        System.out.println(list.loopStartNode());//used when we want to get meet point
        /*
            now i want to use loopStartNode method by changing the return type to Node
            by using this Node we take the previous of this node to break the loop

         */

        //list.display();

        Node node=list.loopStartNode();
        System.out.println(list.breakLoop(node));

        list.display();
    }
}
