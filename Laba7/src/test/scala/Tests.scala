import Demo._
import org.scalatest.FunSuite

class Tests extends FunSuite{

  /*1.*/
  test("test1(chooser)"){
    assert(Demo.chooser(8) == 56)
  }
  test("test2(chooser)"){
    assert(Demo.chooser(7) == 56)
  }
  test("test3(chooser)"){
    assert(Demo.chooser(0) == 0)
  }
  test("test4(chooser)"){
    assert(Demo.chooser(-7) == 0)
  }
  test("test5(chooser)"){
    assert(Demo.chooser(2) ==14)
  }
  test("test6(chooser)"){
    assert(Demo.chooser(1) == 8)
  }

  /*2.*/
  val wiskas = Wiskas()
  val corn = Corn()
  val seaweed = Seaweed()
  test("test7(feedAnimal)"){
    assert(Demo.feedAnimal(wiskas) == Cat(wiskas) )
  }
  test("test8(feedAnimal)"){
    assert(Demo.feedAnimal(corn) == Bird(corn) )
  }
  test("test9(feedAnimal)"){
    assert(Demo.feedAnimal(seaweed) == Fish(seaweed) )
  }
  test("test10(feedAnimal)"){
    assert(Demo.feedAnimal(seaweed) == Fish(seaweed) )
  }
}
