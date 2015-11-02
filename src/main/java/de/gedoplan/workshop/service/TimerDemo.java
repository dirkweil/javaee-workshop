package de.gedoplan.workshop.service;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TimerService;

@Stateless
public class TimerDemo
{
  @Resource
  TimerService timerService;

  @Schedule(hour = "*", minute = "*", second = "0/10")
  public void tick()
  {
    System.out.println("##################");
  }

}
