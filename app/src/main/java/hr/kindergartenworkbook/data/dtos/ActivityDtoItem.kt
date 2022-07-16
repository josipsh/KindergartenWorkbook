package hr.kindergartenworkbook.data.dtos

data class ActivityDtoItem(
    val Category: Category,
    val CategoryId: Int,
    val Date: String,
    val Description: String,
    val DevSubCategory: DevSubCategory,
    val Group: Group,
    val GroupId: Int,
    val Id: Int,
    val Observations: List<Observation>,
    val SubCategoryId: Int
)