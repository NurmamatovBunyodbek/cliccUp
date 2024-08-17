package org.example.clickup.service;

import org.example.clickup.dto.CommentDto;
import org.example.clickup.model.Comment;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.repository.CommentRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TaskRepository taskRepository;
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public Comment getCommentById(Integer id) {
        Optional<Comment> byId = commentRepository.findById(id);
        return byId.get();
    }
    public Result createComment(CommentDto commentDto) {
        Optional<Task> taskOptional = taskRepository.findById(commentDto.getTaskId());
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setTaskid(taskOptional.get());
        commentRepository.save(comment);
        return new Result(true, "Comment created successfully");
    }
    public Result updateComment(Integer id, CommentDto commentDto) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(commentDto.getTaskId());
            Comment comment = commentOptional.get();
            comment.setName(commentDto.getName());
            comment.setTaskid(taskOptional.get());
            commentRepository.save(comment);
            return new Result(true, "Comment updated successfully");
        }
        return new Result(false, "Comment not found");

    }
    public Result deleteComment(Integer id) {
        commentRepository.deleteById(id);
        return new Result(true, "Comment deleted successfully");

    }


}
