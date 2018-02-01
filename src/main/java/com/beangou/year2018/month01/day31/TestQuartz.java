package com.beangou.year2018.month01.day31;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashSet;
import java.util.Set;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author 小彬
 * @version V1.0 2018/1/31 下午3:13
 * @since V1.0
 */
public class TestQuartz {

    private Scheduler scheduler = null;

    @Test
    public void seeCluster() {
        try {
            System.out.println("seeCluster.");
//            Trigger trigger = scheduler.getTrigger(new TriggerKey("trigger8", "group5"));
//            Trigger newTrigger = newTrigger().withIdentity("trigger8", "group8").startNow()
//                    .withSchedule(cronSchedule("0 * * * * ?"))
//                    .build();
////            Trigger trigger2 = newTrigger().withIdentity("trigger5", "group5")
////                    .startNow().withSchedule(cronSchedule("0 02,04,05,06,5,6,07,08,09,10 * * * ?")).build();
////            scheduler.addJob(jobDetail, true);
//            Set<Trigger> triggerSet = new HashSet();
//            triggerSet.add(trigger);
////            triggerSet.add(trigger2);
//
//            JobDetail jobDetail = newJob(HelloJob5.class)
//                    .withIdentity("HelloJob8", "group8").storeDurably()
//                    .build();
//
//            scheduler.scheduleJob(jobDetail, newTrigger);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void before() {
        System.out.println("before.");
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        System.out.println("after.");
        try {
            Thread.sleep(1000L * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
