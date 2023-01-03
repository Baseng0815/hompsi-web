package xyz.bengel.hompsi.services

import org.springframework.stereotype.Service
import xyz.bengel.hompsi.controller.UserController
import xyz.bengel.hompsi.exceptions.MailAlreadyInUseException
import xyz.bengel.hompsi.exceptions.UserNotFoundException
import xyz.bengel.hompsi.exceptions.UsernameAlreadyInUseException
import xyz.bengel.hompsi.models.User
import xyz.bengel.hompsi.repositories.UserRepository
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import kotlin.random.Random

@Service
class UserService(val db: UserRepository) {
    fun getAllUsers() = db.findAll().toList()
    fun findUsersByName(name: String) = db.findByUserNameIgnoreCaseContaining(name)

    @OptIn(ExperimentalStdlibApi::class)
    fun findUserById(id: Int): User {
        return db.findById(id).getOrNull() ?: throw UserNotFoundException("User with id $id not found.")
    }

    fun registerUser(rUser: UserController.RegisterUserRequestBody): User {
        if (db.existsByUserName(rUser.userName)) {
            throw UsernameAlreadyInUseException("The username ${rUser.userName} is already in use.")
        }

        if (db.existsByMailAddress(rUser.mailAddress)) {
            throw MailAlreadyInUseException("The mail address ${rUser.mailAddress} is already in use.")
        }

        val passwordDigest  = java.security.MessageDigest.getInstance("SHA-256")
        val passwordHashed  = passwordDigest.digest(rUser.password.encodeToByteArray())
        val passwordSalt    = Random.Default.nextBytes(16)
        val passwordSalted  = passwordHashed + passwordSalt

        val user = User(
            null, OffsetDateTime.now(),
            rUser.realName, rUser.birthday, rUser.avatarUri, rUser.customStatus,
            rUser.userName, rUser.mailAddress.lowercase(), passwordSalted, passwordSalt
        )

        db.save(user)
        return user
    }
}