
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

    def findExtremums(list: List[Int]): (Int,Int) =  {             //(max,min)
      if (list.isEmpty) (-1,1)
      else {
        if (list.tail == Nil) (list.head, list.head)
        else {
          if (list.head < findExtremums(list.tail)._2) (findExtremums(list.tail)._1, list.head)
          else {
            if (list.head > findExtremums(list.tail)._1) (list.head, findExtremums(list.tail)._2)
            else (findExtremums(list.tail)._1, findExtremums(list.tail)._2)
          }
        }
      }
    }

  def findExtremumsTail(list: List[Int]): (Int,Int)= { //(max,min)
    def run(list: List[Int], maximum: Int, minimum: Int): (Int, Int) = {
      if (list.tail == Nil) (maximum, minimum)
      else {
        if (list.head < minimum) run(list.tail, maximum, list.head)
        else {
         if (list.head > maximum) run(list.tail, list.head, minimum)
         else run(list.tail, maximum, minimum)
        }
      }
    }
    if (list.isEmpty) (-1,1)
    else run(list, list.head, list.head)
  }
}
