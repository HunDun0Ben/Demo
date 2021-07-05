package design.model;

public class IteratorModel {

}

interface Iterator<T> {
    boolean hasNext();
    T currentElement();
    T next();
}

