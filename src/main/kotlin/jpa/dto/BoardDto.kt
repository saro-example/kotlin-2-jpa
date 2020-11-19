package jpa.dto

import jpa.domain.Board
import java.time.LocalDateTime

data class BoardDto (
    var id: Long = 0,
    var content: String = "",
    var name: String = "",
    var ip: String = "",
    var voteUp: Int = 0,
    var voteDown: Int = 0,
    var regDt: LocalDateTime = LocalDateTime.now()
) {
    constructor(board: Board): this() {
        this.id = board.id
        this.content = board.content
        this.name = board.name
        this.ip = board.ip
        this.voteUp = board.voteUp
        this.voteDown = board.voteDown
        this.regDt = board.regDt
    }
}