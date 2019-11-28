import Models.Item

/**
 * Represents a Chain-of-Responsibility 'command'
 */
abstract class Command {
  /**
   * The next command in the chain
   */
  val successor: Option[Command]

  /**
   * Receives the data from the previous command in the chain and processes
   * it according to its own implementation, then passes that data to the next
   * command in the chain, or returns the data if no further successors.
   */
  def handleData(data: List[Item]): List[Item] = {
    successor match {
      case Some(x: Command) => x.handleData(data)
      case None => data
    }
  }
}
