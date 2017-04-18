package com.tistory.lky1001.akkaexample.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

/**
 * Created by kai.1001 on 2017. 4. 18..
 */
public class PingActor extends AbstractActor {

    private LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    private ActorRef pong;

    @Override
    public void preStart() {
        this.pong = context().actorOf(Props.create(PongActor.class, getSelf()), "pongActor");
    }

    @Override
    public Receive createReceive() {
        return new ReceiveBuilder()
                .matchEquals("pong", s -> {
                    logger.info("Ping received : {}", s);
                    getSender().tell("ping", getSelf());
                })
                .matchEquals("start", s -> {
                    logger.info("Ping received : {}", s);
                    pong.tell("ping", getSelf());
                })
                .matchAny(s -> {
                    logger.info("Unknown message : {}", s);
                }).build();
    }
}
