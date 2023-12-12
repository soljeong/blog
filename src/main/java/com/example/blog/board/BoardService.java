package com.example.blog.board;

import org.springframework.stereotype.Service;

import com.example.blog.DataNotFoundException;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList(){
        return this.boardRepository.findAll();
    }

    public Board getBoard(Integer id){
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            return board.get();
        } else {
            throw new DataNotFoundException("board not found");
        }
    }

}
