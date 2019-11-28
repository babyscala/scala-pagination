/**
 * credit to : https://gist.github.com/betandr/315e466f2e85b3363da0581ac8b8928d
 */

import Models._
object Main {
  def main(args: Array[String]): Unit = {

    // the parameters to sort and page; will return items 6, 7, and 8
    // sorted by key, descending
    val page = Paginate(offset = 0, limit = 3) //=> page 1= 3; page 2= 3 (offset = 3, limit= 3)
    val sort = Sort(field = Some("key")) //default isAscending = true

    // the commands are defined in reverse order as we want the
    // sorting to take place first
    val pagination = new PaginateCommand(page, None)

    val sorting = new SortCommand(sort, Some(pagination))

    // some data to sort and page
    val data = List(
      Item(3, "foo"),
      Item(8, "bar"),
      Item(10, "baz"),
      Item(2, "qux"),
      Item(1, "quux"),
      Item(11, "corge"),
      Item(4, "grault"),
      Item(6, "garply"),
      Item(13, "waldo"),
      Item(7, "fred"),
      Item(5, "plugh"),
      Item(9, "xyzzy"),
      Item(12, "thud")
    )

    val processed = sorting.handleData(data)
    val paginate=  pagination.handleData(processed)
    println("page: " + processed + "\n" + paginate)
  }
}
