package xyz.bengel.hompsi.repositories

import org.springframework.data.repository.CrudRepository
import xyz.bengel.hompsi.models.User

interface UserRepository : CrudRepository<User, Int> {
    fun findByUserNameIgnoreCaseContaining(name: String): List<User>
    fun existsByUserName(name: String): Boolean
    fun existsByMailAddress(mail: String): Boolean
}