
object Demo {
  /*1.Если остаток от деления числа на 3 равен 2, умножить число на 7,
   а если равен 1, то умножить на 8 (7 задание)*/

  def chooser(number:Int): Int = {
    number%3 match{
      case 2 => number*7
      case 1 => number*8
      case _ => 0
    }

  }
  /*2.Абстрактный класс Animal и три наследника:Fish, Cat, Bird.
      Абстрактный класс Food и три наследника: Seaweed, Wiskas, Corn.
      Функцию feedAnimal, в которой животному выдается еда, которую он ест (4 задание)*/
  abstract class Animal{
    val food:Food
  }
  case class Fish(food: Food) extends Animal
  case class Cat(food: Food) extends Animal
  case class Bird(food: Food) extends Animal

  abstract class Food

  case class Seaweed() extends Food
  case class Wiskas() extends Food
  case class Corn() extends Food

  def feedAnimal(food:Food):Animal={
    food match{
      case Seaweed() => Fish(food)
      case Wiskas() => Cat(food)
      case Corn() => Bird(food)
    }
  }
}
