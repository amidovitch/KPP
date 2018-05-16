import org.scalatest.FunSuite
class Tests extends  FunSuite {

  test("checkInt should return Nil, if start number more than finish number") {
    assert(Demo.checkInt(9,8) == Nil)
  }

  test("checkInt should return List(6,7) if start = 5, finish = 8") {
    assert(Demo.checkInt(5,8) == 6::7::Nil)
  }

  test("checkInt.last should return 5 if start = 2, finish = 6") {
    assert(Demo.checkInt(2,6).last == 5)
  }


  test("checkTailInt should return Nil, if start number more than finish number") {
    assert(Demo.checkTailInt(1,1) == Nil)
  }
  test("checkTailInt should return List(-1,0,1), if start = -2, finish = 2") {
    assert(Demo.checkTailInt(-2,2) == -1::0::1::Nil)
  }
  test("checkTailInt should return 100, if start = 1, finish = 101") {
    assert(Demo.checkTailInt(1,101).last == 100)
  }


  test("findExtremums should return '(0,0)' if empty List  is provided") {
    assert(Demo.findExtremums(List()) == (-1,1))
  }
  test("findExtremums should return '1' if List(1)' is provided") {
    assert(Demo.findExtremums(List(1)) == (1,1))
  }
  test("findExtremums should return '(55,-1)' if List(-1,55,6,55,2,33,0,5,3,22) is provided") {
    assert(Demo.findExtremums(List(-1,55,6,55,2,33,0,5,3,22)) == (55,-1))
  }


  test("findExtremumsTail should return '(0,0)' if empty List  is provided") {

    assert(Demo.findExtremumsTail(List()) == (-1,1))
  }
  test("findExtremumsTail should return '1' if if List(1)' is provided") {

    assert(Demo.findExtremumsTail(List(1)) == (1,1))
  }
  test("findExtremumsTail should return '(55,-1)' if List(-1,55,6,55,2,33,0,5,3,22) is provided") {

    assert(Demo.findExtremumsTail(List(-2,55,6,56,2,33,0,5,4,22)) == (56,-2))
  }

}
