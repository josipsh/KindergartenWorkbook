package hr.kindergartenworkbook.data.dtos

data class ObservationRequestDto(
    val Date: String,
    val ChildId: Int,
    val ActivityId: Int,
    val MarkId: Int,
    val GroupIdId: Int,
    val Note: String
)