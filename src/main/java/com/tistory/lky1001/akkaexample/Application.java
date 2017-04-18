package com.tistory.lky1001.akkaexample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.tistory.lky1001.akkaexample.actors.PingActor;

/**
 * Created by kai.1001 on 2017. 4. 18..
 */
public class Application {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("TestSystem");
        ActorRef ping = actorSystem.actorOf(Props.create(PingActor.class), "pingActor");

        ping.tell("start", ActorRef.noSender());

        System.out.println("started");
    }
}
