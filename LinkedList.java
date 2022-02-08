package sll;
class Node{

    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node( int data,Node next) {
        this.next = next;
        this.data = data;
    }
}
public class LinkedList {

    Node head,tail;
    int size;

    public LinkedList() {
        this.size = 0;
    }


    public void insertStart(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        if (tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLast(int data){
        if (tail==null){
            insertStart(data);
        }
        Node newNode=new Node(data);
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public void insertAtIndex(int data,int index){
        if (index==0){
            insertStart(data);
            return;
        }
        if (index==size){
            insertLast(data);
            return;
        }
        Node temp=head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node newNode=new Node(data,temp.next);
        temp.next=newNode;
        size++;

    }


    public  int deleteAtStart(){

        if (size==0) {
            System.out.println("list is empty");
            return 0;
        }

        int val=head.data;//deleted data returned
        head=head.next;
        size--;
        return val;
    }

    public int deleteLast(){
        if (size<=1){
            deleteAtStart();
        }
        Node secondLast=get(size-2);
        int val=tail.data;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;
    }

    public int deleteAtMid(int index){
        if (index==0){
           deleteAtStart();

        }
        if (index==size-1){
            deleteLast();
        }
        Node previous=get(index-1);
        int val=previous.next.data;
        previous.next=previous.next.next;
        return val;
    }
    private Node get(int index) {

        Node node=head;
        for (int i = 0; i <index ; i++) {
            node=node.next;
        }
        return node;
    }

    public boolean searchNode(int data){
        Node temp=head;
        while (temp!=null){
            if (temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void display(){

        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println(" end");
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();

        list.insertStart(10);
        list.insertStart(12);
        list.insertStart(19);
        list.insertLast(76);
        list.insertLast(11);

        list.insertAtIndex(23,3);
        list.insertAtIndex(77,4);
        list.display();
        System.out.println(list.deleteAtStart());
    //   list.deleteAtStart();

        System.out.println(list.deleteLast());
        list.display();

        System.out.println(list.deleteAtMid(2));
        list.display();

        System.out.println(list.searchNode(23));

    }

}
