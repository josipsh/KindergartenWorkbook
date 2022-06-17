package hr.kindergartenworkbook.model

data class Child (
    val id: Int,
    val activityId: Int,
    val firstName: String,
    val lastName: String,
    val grade: Int,
    val note: String
){
    override fun toString(): String {
        return "$firstName $lastName"
    }
}