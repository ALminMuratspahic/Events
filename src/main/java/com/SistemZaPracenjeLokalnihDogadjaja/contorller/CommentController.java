package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Comment;
import com.SistemZaPracenjeLokalnihDogadjaja.model.Events;
import com.SistemZaPracenjeLokalnihDogadjaja.model.User;
import com.SistemZaPracenjeLokalnihDogadjaja.services.CommentService;
import com.SistemZaPracenjeLokalnihDogadjaja.services.EventService;
import com.SistemZaPracenjeLokalnihDogadjaja.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final EventService eventService;
    private final UserService userService;
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
        commentService.deleteCommentById(id);;
        //commentService.deleteComment(comment);
        return "redirect:/comments/" + eventId;
    }

    @PostMapping("/{eventId}")
    public String postComment(@ModelAttribute(name = "comment") Comment comment, @PathVariable int eventId) {
        Events event = eventService.findById(eventId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByEmail = userService.findUserByEmail(authentication.getName());
        comment.setEvents(event);
        comment.setUser(userByEmail);
        event.getComments().add(comment);
        eventService.saveEvents(event);
        return "redirect:/events";
    }

    @GetMapping("/event/{eventId}")
    public String makeComment(Model model, @PathVariable(name = "eventId") int eventId) {
        Comment comment = new Comment();
        Events event = eventService.findById(eventId);
        model.addAttribute("comment", comment);
        model.addAttribute("event", event);
        return "make_comment";
    }

}
