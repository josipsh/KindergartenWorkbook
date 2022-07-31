package hr.kindergartenworkbook.data.dtos

data class GroupReadDto(
    val Children: List<ChildReadDto>,
    val Id: Int,
    val Kindergarten: Any,
    val KindergartenId: Int,
    val Name: String,
    val Teachers: List<TeacherReadDto>
)