import java.util.NoSuchElementException;

public class Stack<T> {
    class Element {
        T data;
        Element next;

        public Element(T data) {
            this.data = data;
        }
    }

    Element top;

    boolean isEmpty() {
        return top == null;
    }

    void push(T data) {
        Element e = new Element(data);
        e.next = top;
        top = e;
    }

    T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("스택이 비어있습니다.");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("스택이 비어있습니다.");
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
    }

}
