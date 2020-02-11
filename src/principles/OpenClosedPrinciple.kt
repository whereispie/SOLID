package principles

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/** [Open-Closed Principle]
You should be able to extend a classes behavior, without modifying it.

The second SOLID Principle is the Open-Closed Principle.

This means that classes, modules and methods should be open for extension but closed for modification.
We do this by creating abstractions, in languages such as kotlin we can use interfaces,
this abstraction should then be injected where needed.

The aim of this is to drive a modular design. Let's look at an example. */

class OldNetwork {
    private val uri = URI("https://robot-hq.com")

    fun broadcast(message: String) {
        val httpClient = HttpClient.newHttpClient()
        val body = HttpRequest.BodyPublishers.ofString(message)
        val request = HttpRequest.newBuilder(uri).POST(body).build()
        httpClient.send(request, HttpResponse.BodyHandlers.discarding())
    }
}


/** So looking at the above class, if we ever wanted to change how our Network broadcasts messages,
we’ll have to change this class. What if we want to introduce a different means of communication,
such as RPC? Or what if we want to format the message in a particular way? Let's try and clean this up.  */

interface NewNetwork {
    fun broadcast(message: String)
}

class HttpNetwork : NewNetwork {
    private val uri = URI("https://robot-hq.com")

    override fun broadcast(message: String) {
        val httpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(message)).build()
        httpClient.send(request, HttpResponse.BodyHandlers.discarding())
    }
}

/**
With only a small refactor we’ve made the code more modular.
If we want to add WebSockets, that easy, just write a new class that implements Network.
What if we want to use RPC or some other method? No problem, just write a new class.
This means that any class dependant on Network will not need to change when we create new classes derived from Network. */