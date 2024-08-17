package org.example.clickup.controller;

import org.example.clickup.dto.CommentDto;
import org.example.clickup.model.Comment;
import org.example.clickup.model.Result;
import org.example.clickup.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping
    public List<Comment> getComments() {
        return commentService.getAllComments();
    }
    @GetMapping("/{id}")
    public Comment getCommentbyId(@PathVariable Integer id) {
        return commentService.getCommentById(id);
    }
    @PostMapping
    public Result addComment(@RequestBody CommentDto commentDto) {
        Result comment = commentService.createComment(commentDto);
        return comment;
    }
    @PutMapping("/{id}")
    public Result updateComment(@PathVariable Integer id,@RequestBody CommentDto commentDto) {
        Result comment = commentService.updateComment(id, commentDto);
        return comment;
    }
    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Integer id) {
        Result comment = commentService.deleteComment(id);
        return comment;
    }
}
