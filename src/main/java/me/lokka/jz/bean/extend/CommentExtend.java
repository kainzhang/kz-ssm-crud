package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Comment;

import java.util.List;

public class CommentExtend extends Comment {
    private List<Comment> child;

    public List<Comment> getChild() {
        return child;
    }

    public void setChild(List<Comment> child) {
        this.child = child;
    }

}