package jpa.configruration

import net.dhant.dto.ResultStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    /** invalid RequestBody */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(exception: MethodArgumentNotValidException, request: WebRequest) =
            ResponseEntity.status(HttpStatus.OK).body(ResultStatus("FAIL",
                    exception
                            .bindingResult
                            .allErrors
                            .firstOrNull()
                            ?.defaultMessage
                            ?.takeIf { it.isNotBlank() }
                            ?:"비정상적인 파라미터 호출입니다."
            ))

}
