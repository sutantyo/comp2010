public class Stack {
    private java.util.ArrayList pool = new java.util.ArrayList();
    public Stack() {
    }
    public Stack(int n) {
        pool.ensureCapacity(n);
    }
    public void clear() {
        pool.clear();
    }
    public boolean isEmpty() {
        return pool.isEmpty();
    }
    public Object topEl() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return pool.get(pool.size()-1);
    }
    public Object pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return pool.remove(pool.size()-1);
    }
    public void push(Object el) {
        pool.add(el);
    }
    public String toString() {
        return pool.toString();
    }
}
