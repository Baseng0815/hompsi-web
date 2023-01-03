package xyz.bengel.hompsi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleUserNotFoundException(e: UserNotFoundException) = ResponseEntity<String>(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler
    fun handleUsernameAlreadyInUseException(e: UsernameAlreadyInUseException) = ResponseEntity<String>(e.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler
    fun handleMailAlreadyInUseException(e: MailAlreadyInUseException) = ResponseEntity<String>(e.message, HttpStatus.BAD_REQUEST)
}