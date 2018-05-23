
object Demo {

    def checkInt(start: Int , finish : Int): List[Int] = {
      def run(start: Int, finish: Int): List[Int] = {
        if (start >= finish) List()
        else start :: run(start + 1, finish)
      }
      run(start + 1, finish)
    }

    def checkTailInt(start: Int, finish: Int):List[Int] = {
        def run(start: Int, finish: Int, list: List[Int]): List[Int] = {
            if( start >= finish) list
            else run(start+1, finish, list :+ start)
        }
        run(start + 1, finish, List())
    }


  def findExtremums(list: List[Int]): List[Int]= {
    def run(previous: Int, currentList: List[Int], nextList: List[Int]): List[Int] = {
      if (nextList.isEmpty) Nil
      else if ((currentList.head > previous && currentList.head > nextList.head) ||)
        currentList.head :: run(currentList.head, nextList, nextList.tail)
      else if (currentList.head < previous && currentList.head < nextList.head)
        currentList.head:: run(currentList.head, nextList, nextList.tail)
      else run(currentList.head, nextList, nextList.tail)
    }

    list match {
      case Nil => Nil
      case x :: Nil => Nil
      case x :: xs :: Nil => Nil
      case _ => run(list.head, list.tail, list.tail.tail)
    }
  }

  def findExtremumsTail(list: List[Int]): List[Int]= {
    def run(previous: Int, currentList: List[Int], nextList: List[Int], extremums: List[Int]): List[Int] = {
      if (nextList.isEmpty) extremums
      else if (currentList.head > previous && currentList.head > nextList.head)
        run(currentList.head, nextList, nextList.tail, extremums :+ currentList.head)
      else if (currentList.head < previous && currentList.head < nextList.head)
        run(currentList.head, nextList, nextList.tail, extremums :+ currentList.head )
      else run(currentList.head, nextList, nextList.tail, extremums)
    }

    list match {
      case Nil => Nil
      case x :: Nil => Nil
      case x :: xs :: Nil => Nil
      case _ => run(list.head, list.tail, list.tail.tail, List())
    }
  }
}
