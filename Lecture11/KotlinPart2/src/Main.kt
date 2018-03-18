class Fruit (val ripe: Boolean = false) {
    var taste: String = "sweet"
    fun consume(): String {
        return "eat"
    }
}

class Animal (var sound: String) {

}


inline fun Fruit.x() {
    println("ran x")
}

fun <T> T.hello(): String {
    return "hello" + this.toString()
}

fun main(args: Array<String>) {
    var mango = Fruit(true)
    var kachchaAam = Fruit()

    println(mango.taste)
    println(mango.consume())

    fun Fruit.cook(): String {
        if (this.ripe) {
            return "nothing"
        } else {
            return "boil"
        }
    }



    println(mango.cook())
    println(kachchaAam.cook())
    mango.x()
    kachchaAam.x()

    var k = mango.apply {
        taste = "sour"
        println(cook())
    }
    println(k.taste)q

    println(mango.hello())

    var lion = Animal("roar")
    println(lion.hello())
}

