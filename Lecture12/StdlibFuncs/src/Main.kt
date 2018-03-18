class Vehicle(var wheel: Int = 2) {
    fun getAxles() = wheel / 2
}
fun main(args: Array<String>) {
    var car: Vehicle? = Vehicle(4)

    car?.let {
        car.wheel = 6
        println("axles = ${car.getAxles()}")
    }


    var l = car?.let {
        println(it.getAxles())
    }
    println(l)

    var a = car?.apply {
        wheel = 4
        println(getAxles())
    }
    println("a = ${a}")
    println(car?.wheel)

    var c = car?.also {
        it.wheel = 8
        println(it.getAxles())
    }
    println(c)

    var x: Boolean = true

    with(car!!) {
        wheel = 2
    }

    car.run {
        wheel
    }
    run {

    }

    fun doAwesomeThing () {
        TODO()
    }
}