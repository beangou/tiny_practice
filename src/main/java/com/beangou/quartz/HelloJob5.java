package com.beangou.quartz;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

import java.util.Date;

//@PersistJobDataAfterExecution
public class HelloJob5 implements InterruptableJob {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new Date() + "do5555 it =" + context.getJobDetail().getDescription());
//        dogInjectionService.hello();
//        JobDataMap dataMap = context.getMergedJobDataMap();
//        System.out.println("dataMap size=" + dataMap.size());
//        System.out.println("dataMap=" + dataMap.get("111"));
//        JobDetail jobDetail = context.getJobDetail();
//        dataMap = jobDetail.getJobDataMap();
//        System.out.println("dataMap size=" + dataMap.size());
//        System.out.println("dataMap=" + dataMap.get("111"));
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println(" interrupt  3333");
    }
}