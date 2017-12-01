package com.my.myconfigure;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.my.mytimer.SpringQuartzJob;

@Configuration
public class MyTimerConfigure {
	// <!-- 定时任务bean,任务执行类 -->
	// <bean name="springQuartzJob"
	// class="org.springframework.scheduling.quartz.JobDetailFactoryBean" >
	// <property name="jobClass" value="org.my.SpringQuartz.SpringQuartzJob" />
	// <!-- 任务类的属性map,可以设置参数，我这里没有属性 -->
	// <!-- <property name="jobDataAsMap">
	// <map>
	// <entry key="timeout" value="0" />
	// </map>
	// </property> -->
	// </bean>
	// <!-- 任务执行类对应的触发器：第一种（按照一定的时间间隔触发） -->
	// <bean name="springQuartzJobTrigger1"
	// class="org.springframework.scheduling.quartz.SimpleTriggerFactoryBean">
	// <property name="jobDetail" ref="springQuartzJob" />
	// <property name="startDelay" value="0" /><!-- 调度工厂实例化后，经过0秒开始执行调度 -->
	// <property name="repeatInterval" value="30000" /><!-- 每30秒调度一次 -->
	// </bean>

	// <!-- 调度工厂 -->
	// <bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
	// <property name="triggers">
	// <list>
	// <ref bean="springQuartzJobTrigger1" />
	// <ref bean="springQuartzJobTrigger2" />
	// </list>
	// </property>
	// </bean>

	@Bean(name = "springQuartzJob")
	public JobDetailFactoryBean myJobDetailFactoryBean() {

		JobDetailFactoryBean jobBean = new JobDetailFactoryBean();

		SpringQuartzJob springQuartzJob = new SpringQuartzJob();
		// <!--
		// 参考源码，我们可以看到属性jobClass为Class类型，所以不能使用ref来引用一个bean，否则就会因为不能将bean转换为Class类型而出现异常。
		// <property name="jobClass" ref="simpleJob"/>
		// 必须使用value对jobClass赋值。
		// <property name="jobClass"
		// value="com.earl.quartz.spring.job.SimpleJob"/>
		// -->
		jobBean.setJobClass(springQuartzJob.getClass());

		return jobBean;

	}

	@Bean(name = "springQuartzJobTrigger1")
	public SimpleTriggerFactoryBean mySimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		SimpleTriggerFactoryBean trigerFactoryBean = new SimpleTriggerFactoryBean();
		trigerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
		trigerFactoryBean.setStartDelay(0);
		trigerFactoryBean.setRepeatInterval(3000);
		return trigerFactoryBean;
	}

	@Bean(name = "schedulerFactoryBean")
	public SchedulerFactoryBean mySchedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		Trigger trigger = mySimpleTriggerFactoryBean(jobDetailFactoryBean).getObject();
		Trigger triggers[] = new Trigger[] { trigger };
		schedulerFactoryBean.setTriggers(triggers);
		return schedulerFactoryBean;
	}
}
