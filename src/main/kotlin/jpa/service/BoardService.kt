package jpa.service

import jpa.misc.logger
import jpa.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
        private val boardRepository: BoardRepository
) {
    val log = logger<BoardService>()

}
