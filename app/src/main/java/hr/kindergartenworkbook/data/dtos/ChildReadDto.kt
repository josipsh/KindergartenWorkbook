package hr.kindergartenworkbook.data.dtos

import hr.kindergartenworkbook.model.Child

data class ChildReadDto(
    val FirstName: String,
    val Group: Any,
    val GroupId: Int,
    val Id: Int,
    val Kindergarten: Any,
    val KindergartenId: Int,
    val LastName: String,
    val Parent: ParentReadDto,
    val ParentId: String
) {
    fun toModel(): Child {
        return Child(
            Id,
            0,
            FirstName,
            LastName,
            0,
            ""
        )
    }
}