package xyz.bengel.hompsi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.bengel.hompsi.services.UserService

@RestController
@RequestMapping("/users")
class UserController(val service: UserService) {
    @GetMapping("/all")
    fun index() = service.getAllUsers()
}