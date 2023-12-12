package com.example.blog.board;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList(){
        return this.boardRepository.findAll();
    }

}
