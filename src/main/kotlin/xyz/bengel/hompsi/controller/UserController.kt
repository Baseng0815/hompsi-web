package xyz.bengel.hompsi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import xyz.bengel.hompsi.services.UserService
import java.time.OffsetDateTime

fun ByteArray.toHexString() = asUByteArray().joinToString("") {
    it.toString(16).padStart(2, '0')
}

@RestController
@RequestMapping("/users")
class UserController(val service: UserService) {
    @GetMapping("/all")
    fun getAllUsers() = service.getAllUsers()

    @GetMapping("/find/{name}")
    fun findUsers(@PathVariable name: String) = service.findUsersByName(name)

    @GetMapping("/info/{id}")
    fun getUserInfo(@PathVariable id: Int): ResponseEntity<GetUserInfoResponseBody> {
        val user = service.findUserById(id)
        return ResponseEntity<GetUserInfoResponseBody>(GetUserInfoResponseBody(
            user.uid, user.registeredAt, user.realName, user.birthday,
            user.avatarUri, user.customStatus, user.userName, user.mailAddress
        ), HttpStatus.OK)
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody rUser: RegisterUserRequestBody) = service.registerUser(rUser)

    data class GetUserInfoResponseBody(
        val uid: Int?, val registeredAt: OffsetDateTime, val realName: String?, val birthday: OffsetDateTime?,
        val avatarUri: String?, val customStatus: String?, val userName: String, val mailAddress: String
    )

    data class RegisterUserRequestBody(
        val realName: String?, val birthday: OffsetDateTime?, val avatarUri: String?, val customStatus: String?,
        val userName: String, val mailAddress: String, val password: String) }
