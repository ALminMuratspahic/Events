package com.SistemZaPracenjeLokalnihDogadjaja.services;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Comment;
import com.SistemZaPracenjeLokalnihDogadjaja.model.Events;
import com.SistemZaPracenjeLokalnihDogadjaja.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final EventService eventService;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Comment with id " + id + " not found"));
    }

    public List<Comment> findCommentByEventId(int id) {
        Events event = eventService.findById(id);
        List<Comment> comments = event.getComments();
        return comments;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
