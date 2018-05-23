import org.scalatest.FunSuite

class Tests extends  FunSuite {

  /*Запись в List всех целых между двумя числами (обычная рекурсия)*/
  test("checkInt should return Nil, if start number more than finish number") {
    assert(Demo.checkInt(9,8) == Nil)
  }
  test("checkInt should return Nil, if start number equal finish number") {
    assert(Demo.checkInt(8,8) == Nil)
  }
  test("checkInt should return List(6,7) if start = 5, finish = 8") {
    assert(Demo.checkInt(5,8) == 6::7::Nil)
  }
  test("checkInt.last should return 5 if start = 2, finish = 6") {
    assert(Demo.checkInt(2,6).last == 5)
  }


  /*Запись в List всех целых между двумя числами (хвостовая рекурсия)*/
  test("checkTailInt should return Nil, if start number more than finish number") {
    assert(Demo.checkTailInt(5,1) == Nil)
  }
  test("checkTailInt should return Nil, if start number equal finish number") {
    assert(Demo.checkTailInt(8,8) == Nil)
  }
  test("checkTailInt should return List(-1,0,1), if start = -2, finish = 2") {
    assert(Demo.checkTailInt(-2,2) == -1::0::1::Nil)
  }
  test("checkTailInt should return 100, if start = 1, finish = 101") {
    assert(Demo.checkTailInt(1,101).last == 100)
  }


  /*Поиск локальных экстремумов ряда (обычная рекурсия)*/
  test("findExtremums: should return 'Nil' if List() is provided ") {
    assert(Demo.findExtremums(List()) == Nil)
  }
  test("findExtremums: should return 'Nil' if List(1) is provided ") {
    assert(Demo.findExtremums(List(1)) == Nil)
  }
  test("findExtremums: should return 'Nil' if List(1,0) is provided ") {
    assert(Demo.findExtremums(List(1,0)) == Nil)
  }
  test("findExtremums: should return List(4) if List(1,4,1) is provided ") {
    assert(Demo.findExtremums(List(1,4,1)) == List(4))
  }
  test("findExtremums: should return List(0) if List(4,0,1) is provided ") {
    assert(Demo.findExtremums(List(4,0,1)) == List(0))
  }
  test("findExtremums: should return 'Nil' if List(1,2,3) is provided ") {
    assert(Demo.findExtremums(List(1,2,3)) == Nil)
  }
  test("findExtremums: should return 'Nil' if List(-2,-1,0) is provided ") {
    assert(Demo.findExtremums(List(-2,-1,0)) == Nil)
  }
  test("findExtremums: should return List(5,4,8) if List(1,2,3,5,4,6,8,2) is provided ") {
    assert(Demo.findExtremums(List(1,2,3,5,4,6,8,2)) == List(5,4,8))
  }


  /*Поиск локальных экстремумов ряда (хвостовая рекурсия)*/
  test("findExtremumsTail: should return 'Nil' if List() is provided ") {
    assert(Demo.findExtremumsTail(List()) == Nil)
  }
  test("findExtremumsTail: should return 'Nil' if List(1) is provided ") {
    assert(Demo.findExtremumsTail(List(1)) == Nil)
  }
  test("findExtremumsTail: should return 'Nil' if List(1,0) is provided ") {
    assert(Demo.findExtremumsTail(List(1,0)) == Nil)
  }
  test("findExtremumsTail: should return List(4) if List(1,4,1) is provided ") {
    assert(Demo.findExtremumsTail(List(1,4,1)) == List(4))
  }
  test("findExtremumsTail: should return List(0) if List(4,0,1) is provided ") {
    assert(Demo.findExtremumsTail(List(4,0,1)) == List(0))
  }
  test("findExtremumsTail: should return 'Nil' if List(1,2,3) is provided ") {
    assert(Demo.findExtremumsTail(List(1,2,3)) == Nil)
  }
  test("findExtremumsTail: should return 'Nil' if List(-2,-1,0) is provided ") {
    assert(Demo.findExtremumsTail(List(-2,-1,0)) == Nil)
  }
  test("findExtremumsTail: should return List(5,4,8) if List(1,2,3,5,4,6,8,2) is provided ") {
    assert(Demo.findExtremumsTail(List(1,2,3,5,4,6,8,2)) == List(5,4,8))
  }
}
