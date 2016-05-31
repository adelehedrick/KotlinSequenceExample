package ca.hedrick.sequenceexample

import java.util.*

class MyIter<T>(my_fun: () -> T): Iterator<T> {

    val my_fun = my_fun
    override fun next(): T = my_fun()
    override fun hasNext(): Boolean = true
}

fun main(args: Array<String>) {

    val rand_gen = Random()
    val rand_fun = { rand_gen.nextInt(100) }

    val randSeq = Sequence(iterator = { MyIter( rand_fun ) } )

    for (i in 1..10)
        println(randSeq.first())

}

