package com.example.blog.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog.comment.CommentForm;



@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board/list")
    public String list(Model model) {
        List<Board> boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList);
        return "board_list";

    }

    @GetMapping("/")
    public String root() {
        return "redirect:/board/list";
    }

    @GetMapping(value = "/board/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm) {
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board_detail";
    }

    @GetMapping("/board/create")
    public String boardCreate(BoardForm boardForm) {
        return "board_form";
    }

    @PostMapping("/board/create")
    public String boardCreate(@Valid BoardForm boardForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "board_form";
        }

        this.boardService.create(boardForm.getTitle(), boardForm.getContent());
        return "redirect:/board/list";
    }
    
    
}
