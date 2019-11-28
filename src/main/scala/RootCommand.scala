
import Models._

trait RootCommand extends Command{
  abstract override def handleData(data: List[Item]): List[Item] = super.handleData(data: List[Item]) ++ handleData(data: List[Item])
}
