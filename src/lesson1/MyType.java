package lesson1;

public class MyType<T> {
    private T obj;

    public MyType(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String toString(){
        return obj.toString();
    }
}
