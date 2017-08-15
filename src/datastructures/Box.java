package datastructures;

/**
 * Created by bartek on 16.07.2017.
 */
public class Box<ContentType> {
    //istnieje klasa Optional

    private ContentType element;

    public Box(ContentType element){
        this.element = element;
    }

    public Box(){
    }

    //umieszcza element w pudełku
    public void insert(ContentType element){
        if(!empty())
            throw new IllegalStateException("Box is not empty");
        this.element = element;
    }

    //wyciąga element z pudełka (po tej operacji pudełko jest puste)
    public ContentType pull(){
        if (empty())
            throw new IllegalStateException("Box is empty");
        ContentType tmp = element;
        element = null;
        return tmp;
    }

    //zwraca informację czy pudełko jest puste
    public boolean empty(){
        return element == null;
    }

}
