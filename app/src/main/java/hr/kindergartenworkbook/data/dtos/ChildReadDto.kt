package hr.kindergartenworkbook.data.dtos

data class ChildReadDto(
    val FirstName: String,
    val Group: Any,
    val GroupId: Int,
    val Id: Int,
    val Kindergarten: Any,
    val KindergartenId: Int,
    val LastName: String,
    val Parent: ParentReadDto,
    val ParentId: String
)