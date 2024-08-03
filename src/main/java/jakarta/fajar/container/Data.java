package jakarta.fajar.container;

// contoh extract ValueExtractor pada single generic type
public class Data<T>{//ini hampi mirip dengan Optional<T>

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }




}
