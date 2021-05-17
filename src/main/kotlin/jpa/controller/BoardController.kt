package jpa.controller

import jpa.dto.BoardRequest
import jpa.service.BoardService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/board")
class BoardController(
        private val boardService: BoardService
) {

    @GetMapping
    fun getList() = boardService.getList()

    @PostMapping
    fun createArticle(@Valid @RequestBody boardRequest: BoardRequest) = boardService.createArticle(boardRequest)
}