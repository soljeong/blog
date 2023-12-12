package com.example.blog.comment;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.blog.board.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public void create(Board board, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreatedDate(LocalDateTime.now());
        comment.setBoard(board);
        this.commentRepository.save(comment);
    }

}
