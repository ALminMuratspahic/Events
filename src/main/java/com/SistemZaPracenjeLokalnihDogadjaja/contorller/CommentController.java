package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Comment;
import com.SistemZaPracenjeLokalnihDogadjaja.model.Events;
import com.SistemZaPracenjeLokalnihDogadjaja.services.CommentService;
import com.SistemZaPracenjeLokalnihDogadjaja.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final EventService eventService;

    @GetMapping("/{id}")
    public String getCommentByEvent(@PathVariable(name = "id") int id, Model model) {
        List<Comment> commentByEvent = commentService.findCommentByEventId(id);
        model.addAttribute("comments", commentByEvent);
        return "comment";
    }

    @GetMapping("/del/{id}")
    public String deleteComment(@PathVariable(name = "id") Long id) {
        Comment comment = commentService.findById(id);
        int eventId = comment.getEvents().getId();
        commentService.deleteComment(comment);
        return "redirect:/comments/" + eventId;
    }


}
