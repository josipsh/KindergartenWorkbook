package hr.kindergartenworkbook.data.dtos

data class LoginResponseDto(
    val ErrorMessage: Any,
    val IsAuthSuccessful: Boolean,
    val Token: String,
    val User: UserDto
)