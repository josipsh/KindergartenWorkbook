package hr.kindergartenworkbook.data.dtos

data class ObservationResponseDto(
    val Activity: Any,
    val ActivityId: Int,
    val Child: Any,
    val ChildId: Int,
    val Date: String,
    val Group: Any,
    val GroupId: Int,
    val Id: Int,
    val Mark: Any,
    val MarkId: Int,
    val Note: String
)