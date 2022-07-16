package hr.kindergartenworkbook.data.dtos

data class Observation(
    val Activity: String,
    val ActivityId: Int,
    val Child: Child,
    val ChildId: Int,
    val Date: String,
    val Group: GroupX,
    val GroupId: Int,
    val Id: Int,
    val Mark: Mark,
    val MarkId: Int,
    val Note: String
)