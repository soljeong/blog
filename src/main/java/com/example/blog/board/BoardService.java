package com.example.blog.board;

import org.springframework.stereotype.Service;

import com.example.blog.DataNotFoundException;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
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

    public void create(String title, String content) {
        Board b = new Board();
        b.setTitle(title);
        b.setContent(content);
        b.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(b);
    }

}
