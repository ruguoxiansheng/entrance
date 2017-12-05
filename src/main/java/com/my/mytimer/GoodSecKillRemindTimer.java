package com.my.mytimer;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class GoodSecKillRemindTimer extends QuartzJobBean
{
    /**
     * logback
     */
    private Logger logger = LoggerFactory.getLogger(GoodSecKillRemindTimer.class);

    /**
     * 任务指定逻辑
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取任务详情内的数据集合
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        //获取商品编号
        Long goodId = dataMap.getLong("goodId");

        logger.info("分布式节点quartz-cluster-node-first，开始处理秒杀商品：{}，关注用户推送消息.",goodId);

        //.../
    }
}