package org.project.actors

import akka.actor._

object BasicActor{

}

final class BasicActor(val args:List[String]) extends Actor{
    
    def receive: Receive = ???

}