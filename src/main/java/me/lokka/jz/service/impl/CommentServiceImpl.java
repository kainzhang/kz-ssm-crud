package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Comment;
import me.lokka.jz.bean.CommentExample;
import me.lokka.jz.bean.extend.CommentExtend;
import me.lokka.jz.dao.CommentMapper;
import me.lokka.jz.dao.extend.CommentExtendMapper;
import me.lokka.jz.service.ICommentService;
import me.lokka.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private  CommentExtendMapper commentExtendMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.selectByExample(new CommentExample());
    }

    @Override
    public List<CommentExtend> findAllWithChild() {
        return commentExtendMapper.selectAllWithChild();
    }

    @Override
    public Comment selectById(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if(comment == null){
            throw new CustomerException("删除失败，要删除的数据不存在");
        }
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void commit(Comment comment) throws CustomerException {
        if (comment.getId()==null){
            commentMapper.insert(comment);
        }else {
            Comment commentT=commentMapper.selectByPrimaryKey(comment.getId());
            if (commentT ==null){
                throw new CustomerException("修改失败，数据不存在");
            }
            commentMapper.updateByPrimaryKey(comment);

        }
    }

}