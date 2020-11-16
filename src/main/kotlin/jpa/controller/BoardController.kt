package jpa.controller

import jpa.service.BoardService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/board")
class BoardController(
        private val boardService: BoardService
) {

}