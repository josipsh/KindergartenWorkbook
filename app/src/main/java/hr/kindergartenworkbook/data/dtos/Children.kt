package hr.kindergartenworkbook.data.dtos

data class Children(
    val FirstName: String,
    val Group: String,
    val GroupId: Int,
    val Id: Int,
    val Kindergarten: KindergartenXX,
    val KindergartenId: Int,
    val LastName: String,
    val Parent: Parent,
    val ParentId: String
)