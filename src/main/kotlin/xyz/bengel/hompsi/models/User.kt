package xyz.bengel.hompsi.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime

@Table("users")
data class User(
    @Id var uid: Int?,
    val registeredAt: OffsetDateTime,
    val realName: String?,
    val birthday: OffsetDateTime?,
    val avatarUri: String?,
    val customStatus: String?,
    val userName: String,
    val mailAddress: String,
    val saltedPassword: ByteArray,
    val salt: ByteArray
)

