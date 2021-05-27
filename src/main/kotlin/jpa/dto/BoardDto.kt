package jpa.dto

import jpa.domain.Board
import java.time.LocalDateTime

data class BoardDto (
    var name: String = "",
    var content: String = "",
    var ip: String = "",
    var regDt: LocalDateTime = LocalDateTime.now()
) {
    constructor(board: Board): this() {
        this.content = board.content
        this.name = board.name
        this.ip = board.ip
        this.regDt = board.regDt
    }
}