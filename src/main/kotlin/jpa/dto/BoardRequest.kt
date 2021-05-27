package jpa.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class BoardRequest (
        @field:NotBlank(message = "이름을 입력해주세요.")
        @field:Size(max = 16, message = "이름은 16자 이하로 입력해주세요.")
        var name: String = "",

        @field:Size(max = 120, message = "내용은 120자 이하로 입력해주세요.")
        @field:NotBlank(message = "내용을 입력해주세요.")
        var content: String = ""
)