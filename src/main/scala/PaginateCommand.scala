import Models._

/**
 * Represents a pagination command and encapsulates the parameters for
 * pagination and the pagination algorithm itself.
 *
 * @param page The case class which holds the pagination parameters
 * @param successor The next in the chain
 */
class PaginateCommand(val page: Paginate, val successor: Option[Command])
  extends RootCommand {

  /**
   * Return a page the size of the 'limit' from the 'offset' position, 
   * in the enclosed Paginate params.
   */
  override def handleData(data: List[Item]): List[Item] = {
    val paged = data
      .drop(page.offset)
      .dropRight(data.size - (page.offset + page.limit))
    println(s"PaginateCommand $paged")
    paged
  }
}