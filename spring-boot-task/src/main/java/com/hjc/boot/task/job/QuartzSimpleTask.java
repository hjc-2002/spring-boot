package com.hjc.boot.task.job;

import com.hjc.boot.task.utils.CreateUtils;
import jakarta.annotation.Resource;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzSimpleTask extends QuartzJobBean {

    @Resource
    private CreateUtils createUtils;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行备份任务");
        createUtils.get();
    }
}