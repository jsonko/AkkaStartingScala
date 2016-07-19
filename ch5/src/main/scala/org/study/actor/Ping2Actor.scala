package org.study.actor

import akka.actor.Actor
import akka.event.Logging


class Ping2Actor extends Actor {
  val log = Logging(context.system, this)

  override def receive = {
    case msg : String =>
      log.info(s"Ping2Actor received $msg")
      work
      sender ! "done"
  }

  private def work = {
    Thread.sleep(1000) // 실전에서는 절대 금물!!!
    log.info("Ping2Actor working...")
  }
}
