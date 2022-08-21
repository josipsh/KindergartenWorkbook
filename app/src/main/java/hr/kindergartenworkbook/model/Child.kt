package hr.kindergartenworkbook.model

// grade 1-plus | 2-minus | 3-izmedu
data class Child (
    val id: Int,
    val activityId: Int,
    val firstName: String,
    val lastName: String,
    var grade: Int,
    var note: String
){
    override fun toString(): String {
        return "$firstName $lastName"
    }
}