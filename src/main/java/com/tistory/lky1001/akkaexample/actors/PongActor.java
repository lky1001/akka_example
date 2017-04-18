package com.tistory.lky1001.akkaexample.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by kai.1001 on 2017. 4. 18..
 */
public class PongActor extends AbstractActor {

    private LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
    private ActorRef ping;

    public PongActor(ActorRef ping) {
        this.ping = ping;
    }

    @Override
    public Receive createReceive() {
        return new ReceiveBuilder()
                .matchEquals("ping", s -> {
                    logger.info("Pong received : {}", s);
                    Thread.sleep(1000);
                    getSender().tell("pong", getSelf());
                })
                .matchAny(s -> {
                    logger.info("Unknown message : {}", s);
                }).build();
    }
}
