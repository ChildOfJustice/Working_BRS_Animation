package myTest

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.event.Logging
import akka.event.LoggingAdapter

internal class PrintMyActorRefActor : AbstractActor() {
    //private val log = Logging.getLogger(getContext().getSystem(), this)


    override
    fun createReceive(): Receive {
        return receiveBuilder()
                .matchEquals(
                        "startAnim",
                        { p ->
                            println("Starting...")
                            First2D.goAnim.go()
                            println("going!!!!")
                            //ActorRef secondRef = getContext().actorOf(Props.empty(), "second-actor");
                            //System.out.println("Second: " + secondRef);

                        })
                .matchEquals(
                        "hi",
                        { p ->
                            println("Hello")
                            //                  while(true) {
                            //                	  Thread.sleep(3000);
                            //                	  System.out.println("----");
                            //                  }
                        })
                .match(String::class.java, { s -> println("Received String message: {} $s") })
                .matchAny({ o -> println("received unknown message") })
                .build()
    }

    companion object {

        fun props(): Props {
            return Props.create(PrintMyActorRefActor::class.java, ({ PrintMyActorRefActor() }))
        }
    }
}

object test2 {//pachem????
    val actorSystem = ActorSystem.create("testSystem")
    @Throws(java.io.IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {


        val firstRef = actorSystem.actorOf(PrintMyActorRefActor.props(), "first-actor")
        firstRef.tell("printit", ActorRef.noSender())

        firstRef.tell("hi", ActorRef.noSender())

        firstRef.tell(1, ActorRef.noSender())




        try {

        } finally {
            actorSystem.terminate()
        }
    }

}
