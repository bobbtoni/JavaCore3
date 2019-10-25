public class Main {

    static Node reverse(Node headNode){
        Node buffer1 = null, buffer2 = null;

        buffer2 = null;
        while(headNode != null){
            buffer1 = headNode.getNext();
            headNode.setNext(buffer2);
            buffer2 = headNode;
            headNode = buffer1;
        }
        return buffer2;
    }

    public static void main(String[] args) {
        Node headNode = new Node(1);
        for (int i = 2; i <= 6; i++) {
            headNode.add(new Node(i));
        }
        System.out.println(headNode.toString());
        System.out.println(reverse(headNode).toString());

    }
}
