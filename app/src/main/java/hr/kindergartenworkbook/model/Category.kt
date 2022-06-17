package hr.kindergartenworkbook.model

data class Category(
    val id: Int,
    val name: String,
    val code: String
){
    override fun toString(): String {
        return name
    }
}