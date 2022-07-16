package hr.kindergartenworkbook.data.dtos

data class UserLoginRequest(
    val userName: String,
    val password: String
)