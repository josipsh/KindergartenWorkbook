package hr.kindergartenworkbook.data.dtos

data class GroupX(
    val Children: List<Children>,
    val Id: Int,
    val Kindergarten: KindergartenXX,
    val KindergartenId: Int,
    val Name: String,
    val Teachers: List<Teacher>
)