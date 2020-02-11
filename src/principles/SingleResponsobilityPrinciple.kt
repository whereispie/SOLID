package principles

/** [Single responsibility principle]
A class should have one, and only one, reason to change.

This principle is based on the fact that a class or module should only be
concerned with one aspect of a program, or be responsible for one thing.

Requirements change and software evolves all the time. When this happens,
classes, modules and functions must reflect that change.

The more a class is concerned with, or more responsibilities it had, the more it must be changed.
Changing such classes can be time consuming and difficult, often lead to side affects.

Let’s have a look at some kotlin: */

class RobotMK1(val name: String, val type: String) {

    fun greet() {
        println("Hello my name is $name, and I am a $type robot")
    }
}

/**
Currently, this class is doing two things.
Firstly, it’s representing our Robot entity and holding state for a name and type,
and secondly, it’s concerned with how our robot is communicating.
In this case, our robot isn’t very advanced and just prints to communicate */

data class RobotMK2(val name: String, val type: String)

class RobotPrinter {
    fun greet(robot: RobotMK2) {
        val name = robot.name
        val type = robot.type
        println("Hello my name is $name and I am a $type robot")
    }
}

/**
Now, after some minor refactoring, we have two classes with more specific tasks.
We still have our Robot class, however, the functionality of greet has been moved to a separate class RobotPrinter.
Without writing too much more code we’ve managed to decouple our entity from its presentation logic,
which will benefit us in the long term. We’ve also been able to use a data class for our robot, a wonderful feature of kotlin. */