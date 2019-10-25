public class Node {
    int value;
    Node next;

    Node(int value){
        this.value = value;
        next = null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void add(Node next){
        if (this.next != null) this.next.add(next);
        else this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        if (this.next!=null) string.append(value + " " + this.next.toString());
        else return String.valueOf(value);
        return string.toString();
    }
}
