package me.lokka.jz.service;

import me.lokka.jz.bean.Comment;
import me.lokka.jz.bean.extend.CommentExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    List<CommentExtend> findAllWithChild();

    Comment selectById(Long id);

    void deleteById(long id) throws CustomerException;

    void commit(Comment comment)throws CustomerException;

}