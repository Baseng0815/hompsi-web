package xyz.bengel.hompsi.repositories

import org.springframework.data.repository.CrudRepository
import xyz.bengel.hompsi.models.User

interface UserRepository : CrudRepository<User, String> {
}