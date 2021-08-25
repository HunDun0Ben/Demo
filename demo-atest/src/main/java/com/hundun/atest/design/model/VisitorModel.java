package com.hundun.atest.design.model;

import java.util.Arrays;
import java.util.List;

public class VisitorModel {
    public static void main(String[] args){
        Visitor v = new VisitorImpl();
        List<Resource> list = Arrays.asList(new ResourceImpl(""));
        for (Resource resource : list) {
            resource.accept(v);
        }
    }
}

interface Visitor{
    void visit(ResourceImpl impl);
    // void visit(ResourceImpl2 impl);
    // ... another type
}

class VisitorImpl implements Visitor {

    @Override
    public void visit(ResourceImpl impl) {
        // 实现逻辑
        System.out.println("实现逻辑");
    }
}

abstract class Resource {
    protected String path;

    public Resource(String path) {
        this.path = path;
    }

    abstract public void accept(Visitor visitor);
}

class ResourceImpl extends Resource {

    public ResourceImpl(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}