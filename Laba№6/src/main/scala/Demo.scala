object Demo {

  /*1.Переворачиваем все слова в коллекции, оставив неизменным их порядок*/
  def reverseElementsOfListString(list:List[String]):List[String]={
    list.map(_.reverse)
  }

  /*2.List[Int] преобразуем в List[String] */
  def listIntToListString(list:List[Int]):List[String]={
    list.foldRight(List[String]()) ((currentElement, newList ) => currentElement.toString :: newList)
  }

  /*3.Находим произведение четных строк матрицы*/
  def productEvenRowInMatrix(listOfNumbers: List[List[Int]]): List[Int] = {
    val listWithIndexOfElements = listOfNumbers.zipWithIndex //((List(1,3,4),0),(List(1,3,6),1),(List(1),2)...)
    val listWithEvenRows = listWithIndexOfElements.filter(_._2 % 2 == 0).map(_._1.product)
    listWithEvenRows
  }
/*
  def main(args:Array[String]): Unit ={
    val list = List[(List[Int],Int)]((List(1,2,3),0), (List(4,5),1), (List(6),2), (List(7,8),3))
    //productEvenRowInMatrix(list.)
    println(list.map(_._1))

  }
  def myProduct(currentRow: List[Int]): Int = {
    def step(currentRow: List[Int], acc: Int): Int = {
      println(currentRow.toString() + acc)
      currentRow match {
        case Nil => acc
        case x :: xs => step(xs, x * acc)
        case _ => 0
      }
    }
    print(1)
    step(currentRow, 1)
  }*/
}
