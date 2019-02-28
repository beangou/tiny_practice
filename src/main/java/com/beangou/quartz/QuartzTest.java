package com.beangou.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @author 小彬
 * @version V1.0 2019-02-20 11:57
 * @since V1.0
 */
public class QuartzTest {

    public static void main(String[] args) {

        Scheduler scheduler;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
