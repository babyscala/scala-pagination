import Models._
/**
 * Represents a sorting command and encapsulates the parameters for sorting
 * and the sorting algorithm itself.
 *
 * @param sort The case class which holds the sorting parameters
 * @param successor The next in the chain
 */
class SortCommand(val sort: Sort, val successor: Option[Command])
  extends RootCommand {

  /**
   * Sorts data by 'key' or 'value' either ascending or descending order
   *
   * @param data
   * @return
   */
  override def handleData(data: List[Item]): List[Item] = {
    val sorted = sort.field.getOrElse("none") match {
      case "key" => data.sortWith(_.key > _.key)
      case "value" => data.sortWith(_.value > _.value)
      case "none" => data.sortWith(_.key > _.key)
    }

    val ordered = sort.isAscending match {
      case true => sorted.reverse
      case false => sorted
    }
    ordered
  }
}