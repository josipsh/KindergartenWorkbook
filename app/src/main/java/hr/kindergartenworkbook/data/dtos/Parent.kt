package hr.kindergartenworkbook.data.dtos

data class Parent(
    val Address: String,
    val City: City,
    val CityId: Int,
    val Email: String,
    val FirstName: String,
    val Group: String,
    val GroupId: Int,
    val Id: String,
    val Kindergarten: KindergartenXX,
    val KindergartenId: Int,
    val LastName: String,
    val Password: String,
    val PhoneNo: String,
    val Username: String
)