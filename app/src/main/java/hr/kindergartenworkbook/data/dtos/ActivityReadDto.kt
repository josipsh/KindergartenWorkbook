package hr.kindergartenworkbook.data.dtos

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
)