package xyz.bengel.hompsi.exceptions

class UserNotFoundException(override val message: String?) : Exception(message)
class UsernameAlreadyInUseException(override val message: String?) : Exception(message)
class MailAlreadyInUseException(override val message: String?) : Exception(message)
