package jpa.service

import jpa.domain.Board
import jpa.dto.BoardDto
import jpa.dto.BoardRequest
import jpa.misc.logger
import jpa.repository.BoardRepository
import net.dhant.dto.ResultStatus
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

@Service
class BoardService(
        private val boardRepository: BoardRepository,
        private val request: HttpServletRequest
) {
    val log = logger<BoardService>()

    fun getList() = boardRepository.findAllByOrderByIdDesc().map { BoardDto(it) }

    fun addArticle(r: BoardRequest): ResultStatus {
        boardRepository.save(Board(name=r.name, password = r.password, content = r.content, ip = request.remoteAddr))
        return ResultStatus("OK")
    }
}
