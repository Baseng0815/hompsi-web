package xyz.bengel.hompsi.repositories

import org.springframework.data.repository.CrudRepository
import xyz.bengel.hompsi.models.User

interface UserRepository : CrudRepository<User, Int> {
    fun findByUserNameIgnoreCaseContaining(place: String): List<User>
}