package hr.kindergartenworkbook.data.dtos

import hr.kindergartenworkbook.model.Activity

data class ActivityReadDto(
    val Category: CategoryReadDto,
    val CategoryId: Int,
    val Date: String,
    val Description: Any,
    val DevSubCategory: DevSubCategory,
    val Group: Any,
    val GroupId: Int,
    val Id: Int,
    val Observations: Any,
    val SubCategoryId: Int
) {
    fun toModel(): Activity {
        return Activity(
            Id,
            Id.toString()
        )
    }
}