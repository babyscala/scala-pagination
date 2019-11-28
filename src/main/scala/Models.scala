object Models {
  case class Sort(field: Option[String], isAscending: Boolean = true)
  case class Paginate (offset: Int, limit: Int)
  case class Item (key: Int, value: String)
}
