package hr.kindergartenworkbook.data.dtos

data class TeacherReadDto(
    val Address: Any,
    val City: Any,
    val CityId: Any,
    val Email: String,
    val FirstName: String,
    val Group: GroupReadDto,
    val GroupId: Int,
    val Id: String,
    val Kindergarten: Any,
    val KindergartenId: Int,
    val LastName: String,
    val Password: Any,
    val PhoneNo: Any,
    val Username: String
)