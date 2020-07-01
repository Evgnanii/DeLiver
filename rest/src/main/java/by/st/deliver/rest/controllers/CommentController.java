package by.st.deliver.rest.controllers;


import dto.CommentDTO;
import dto.CommentRatingUpdateMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.CommentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> addClient(@RequestBody @Valid CommentDTO commentDTO) {
        commentService.addComment(commentDTO);
        return new ResponseEntity<>(commentDTO, new HttpHeaders(), HttpStatus.CREATED);

    }

    @GetMapping("/byproduct/{product_id}")
    public ResponseEntity<List<CommentDTO>> getCommentsByProduct(@PathVariable("product_id") Long productId) {
        List<CommentDTO> commentDTOS = commentService.getCommentByProductId(productId);
        return new ResponseEntity<>(commentDTOS, new HttpHeaders(), HttpStatus.OK);
    }



    @GetMapping("/byclient/{client_id}")
    public ResponseEntity<List<CommentDTO>> getCommentsByClient(@PathVariable("client_id") Long clientId) {
        List<CommentDTO> commentDTOS = commentService.getCommentByClientId(clientId);
        return new ResponseEntity<>(commentDTOS, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/byrestaurant/{restaurant_id}")
    public ResponseEntity<List<CommentDTO>> getCommentsByRestaurant(@PathVariable("restaurant_id") Long restaurantId) {
        List<CommentDTO> commentDTOS = commentService.getCommentByRestaurantId(restaurantId);
        return new ResponseEntity<>(commentDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{comment_id}")
    public ResponseEntity<CommentDTO> getCommentsById(@PathVariable("comment_id") Long commentId) {
        CommentDTO commentDTO = commentService.getCommentById(commentId);
        return new ResponseEntity<>(commentDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<CommentDTO> removeComment(@PathVariable("comment_id") Long commentId) {
        commentService.removeComment(commentId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<CommentDTO> removeComment(@RequestBody @Valid CommentRatingUpdateMessageDTO commentRatingUpdateMessageDTO) {
        commentService.updateCommentRating(commentRatingUpdateMessageDTO);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
