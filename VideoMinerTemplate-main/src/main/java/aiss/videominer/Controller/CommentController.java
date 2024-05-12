package aiss.videominer.Controller;

import aiss.videominer.model.Caption;
import aiss.videominer.model.Comment;
import aiss.videominer.repository.CaptionRepository;
import aiss.videominer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("VideoMiner")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> getvideos(){
        List<Comment> comments = commentRepository.findAll();
        return comments;
    }

    @GetMapping("/comments/{id}")
    public Comment findOne(@PathVariable String id){
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.get();
    }

}
