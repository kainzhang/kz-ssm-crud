package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import me.lokka.jz.bean.Comment;
import me.lokka.jz.bean.extend.CommentExtend;
import me.lokka.jz.service.ICommentService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "评论管理接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @PostMapping("commit")
    @ApiOperation("提交评论")
    public Message commit(Comment comment){
        commentService.commit(comment);
        return MessageUtil.success("提交成功");}

    @ApiOperation(value = "查询所有评论")
    @GetMapping("findAll")
    public List<Comment> findAll(){
        return commentService.findAll();
    }


    @ApiOperation(value = "查询所有评论,级联获得评论")
    @GetMapping("findAllWithChild")
    public List<CommentExtend> findAllWithChild(){
        return commentService.findAllWithChild();
    }

    @ApiOperation(value = "通过id查询评论")
    @GetMapping("selectById")
    public  Comment selectById(Long id){
        return  commentService.selectById(id);
    }


    @ApiOperation(value = "通过id删除评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "唯一编号", required = true, paramType = "query")
    })
    @GetMapping("deleteById")
    public Message deleteById(long id){
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}
