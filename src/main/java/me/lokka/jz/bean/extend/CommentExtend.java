package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Comment;

import java.util.List;

public class CommentExtend extends Comment {
    private List<Comment> children;

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }
}