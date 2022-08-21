package hr.kindergartenworkbook.data.dtos

data class ObservationCreateDto(
    val ActivityId: Int,
    val ChildId: Int,
    val Date: String,
    val GroupId: Int,
    val MarkId: Int,
    val Note: String
)