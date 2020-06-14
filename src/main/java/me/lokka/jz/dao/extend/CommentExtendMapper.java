package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.Comment;
import me.lokka.jz.bean.extend.CommentExtend;

import java.util.List;

public interface CommentExtendMapper {

    List<CommentExtend> selectAllWithChild();

    List<Comment> selectById(Long id);

}