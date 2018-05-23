import org.scalatest.FunSuite

class Tests extends FunSuite{
  /*Реверс всех элементов в List[String]*/
  test("test1(reverseElementsOfListString)") {
    val list = List[String]("Dima")
    assert(Demo.reverseElementsOfListString(list) == List("amiD"))
  }
  test("test2(reverseElementsOfListString)") {
    val list = List[String]()
    assert(Demo.reverseElementsOfListString(list) == Nil)
  }
  test("test3(reverseElementsOfListString)") {
    val list = List[String]("123-","321","asd","dsa","ASD123")
    assert(Demo.reverseElementsOfListString(list) == List("-321","123","dsa","asd","321DSA"))
  }

  /*List[Int] преобразуем в List[String] */
  test("test4(listIntToListString)") {
    val list = List[Int](-12, 14, 17, 0)
    assert(Demo.listIntToListString(list) == List("-12", "14", "17", "0"))
  }

  test("test5(listIntToListString)") {
    val list = List[Int]()
    assert(Demo.listIntToListString(list) == Nil)
  }

  test("test6(listIntToListString)") {
    val list = List[Int](12)
    assert(Demo.listIntToListString(list) == List("12"))
  }

  /*Произведение четных строк в матрице */
  test("test7(productEvenRowInMatrix)") {
    val matrixOfNumbers = List[List[Int]](List(12, 14), List(17, 14), List(22, 18), List(22, 100))
    assert(Demo.productEvenRowInMatrix(matrixOfNumbers) == List(168, 396))
  }

  test("test8(productEvenRowInMatrix)") {
    val matrixOfNumbers = List[List[Int]]()
    assert(Demo.productEvenRowInMatrix(matrixOfNumbers) == List())
  }

  test("test9(productEvenRowInMatrix)") {
    val matrixOfNumbers = List[List[Int]](List(12, 14), List(17, 14))
    assert(Demo.productEvenRowInMatrix(matrixOfNumbers) == List(168))
  }
}
