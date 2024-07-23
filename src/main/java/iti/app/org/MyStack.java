package iti.app.org;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private ArrayList<Integer> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public MyStack push(int x) {
        list.add(x);
        return this;
    }

    public int getSize() {
        return list.size();
    }

    public MyStack pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Can't pop from empty stack!!");
        }
        list.remove(getSize() - 1);
        return this;
    }

    public int getPeek() {
        return list.get(getSize() - 1);
    }

    public List<Integer> getCurrentStack() {
        return list;
    }
}
