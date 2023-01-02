package xyz.bengel.hompsi.services

import org.springframework.stereotype.Service
import xyz.bengel.hompsi.repositories.UserRepository

@Service
class UserService(val db: UserRepository) {
    fun getAllUsers() = db.findAll().toList()
}