public class DLL {
    private DllNode head = null;
    private DllNode tail = null;
    class DllNode{
        int data;
        DllNode next;
        DllNode prev;

        public DllNode(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addToHead(int data){
        DllNode first = new DllNode(data);
        if(this.head == null){
            this.head = first;
            this.tail = first;
        }else {
            this.head.prev = first;
            first.next = this.head;
            this.head = first;
        }
    }
    public void addToTail(int data){
        DllNode sec = new DllNode(data);
        if (this.head == null){
            this.head = sec;
            this.tail = sec;
        }else {
            this.tail.next = sec;
            sec.prev = tail;
            this.tail = sec;
        }
    }
    public int deletHead(){
        if (this.head == null){
            System.out.println("Empty");
        }else {
           this.head = this.head.next;
           this.head.prev = null;
        }
        return -1;
    }
    public int deletTail(){
        if (this.head == null){
            System.out.println("Empty");
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        return -1;
    }
    public void deletRandom(int data){
        if (this.head == null){
            System.out.println("Empty");
        }else {
           if (this.head.data == data && this.head.next == null){
               head = null;
               tail = null;
           }else if (this.head.data == data){
               this.head = this.head.next;
               this.head.prev = null;
           }else {
               DllNode x = this.head;
               DllNode temp = null;
               while (x!= null && x.data != data){
                   temp = x;
                   x = x.next;
               }
               if (x== null) System.out.println("Not in the list");
               else {
                   if (x== this.tail){
                       this.tail = x.prev;
                       this.tail.next = null;
                   }else {
                       temp.next = x.next;
                       x.next.prev = temp;
                       x = null;
                   }
               }
           }
        }
    }

    public int getHead(){
        return this.head.data;
    }
    public int getTail(){
        return this.tail.data;
    }

    public void printList(){
        DllNode x = head;
        while (x != null){
            System.out.print( x.data + " ");
            x = x.next;
        }
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.addToHead(5);
        list.addToTail(7);
        list.addToHead(3);
        list.addToHead(9);
        list.addToHead(11);
        list.deletRandom(9);
        list.printList();
        list.deletHead();
        System.out.println();
        list.printList();
        list.deletTail();
        System.out.println();
        list.printList();
    }
}
