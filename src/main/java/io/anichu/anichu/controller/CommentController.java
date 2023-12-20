package io.anichu.anichu.controller;

import io.anichu.anichu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@RequestMapping("/comment")
@Controller
public class CommentController {
    private final CommentService commentService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> getCommentListAPI(@RequestParam("seq") Long seq,
                                               @PageableDefault(sort = {"createDate"}) Pageable pageable) {
        return ResponseEntity.ok(commentService.getComments(seq, pageable));
    }
}
