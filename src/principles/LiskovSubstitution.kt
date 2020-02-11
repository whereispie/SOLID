package principles

/** Liskov Substitution Principle
 * If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S
without altering any of the desirable properties of that program.

Essentially, we should be able to replace any instance of a parent class
with that of a child class without anything breaking.
When getting started with object-orientated programming, referring to the phrase “is a”
to help determine relationships between classes can be helpful.
This SOLID Principle helps us ensure we do this properly.

Let’s we have the following code. Someone has decided to follow the Open-Closed Principle
in order to make the code more modular, we can add as many different robots as we like with easy
(Hurray for the Open-Closed Principle). */

abstract class RobotScout {
    abstract fun goToLocation(lat: Double, long: Double)
    abstract fun jump()
}

/** However, later on, we decide to start shipping heavy robots(to deal with larger tasks). So we have this kotlin class: */

class HeavyRobot : RobotScout() {
    override fun goToLocation(lat: Double, long: Double) {
    }

    override fun jump() {
    }
}

/**
Can you see the issue? The method doesn’t do anything as this is a heavy robot,
when we follow the Open-Closed Principle, we want our derived classes to work the same.
So when our developer wants the robots to jump, we’d be left with a set of robots just sitting around,
not doing much. This is what happens when we fail to follow the Liskov Substitution Principle,
things stop working as we expect. Let’s see how we’d fix this. */

abstract class RobotScoutMK2 {
    abstract fun spyAtLocation(lat: Double, long: Double)
}

abstract class LightweightRobot : RobotScoutMK2() {
    abstract fun fly()
}

/**
What we’ve done is moved the jump method into another derived class.
Now, our HeavyRobot can inherit from Robot and we will have a much
easier time getting the robots to where they need to be. */

/** */
/** */