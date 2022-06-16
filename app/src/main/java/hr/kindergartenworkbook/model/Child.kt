package hr.kindergartenworkbook.model

data class Child (
    val id: String,
    val activityId: Int,
    val firstName: String,
    val lastName: String,
    val grade: Int,
    val note: String
)