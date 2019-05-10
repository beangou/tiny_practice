package com.beangou.year2019.month03.day04;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class GetTime {


    @Test
    public void add() throws InterruptedException {
        Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                String id = getGuid();
                System.out.println("id="+id);
                if (set.contains(id)) {
                    System.out.println("contains id=" + id);
                }
                set.add(id);
            }).start();
        }
        Thread.sleep(100000L);
    }
		
		/**
		 * 20位末尾的数字id
		 */
		public static volatile int Guid=100;
 
		public static String getGuid() {
			
			GetTime.Guid+=1;
 
			long now = System.currentTimeMillis();  
			//获取4位年份数字  
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
			//获取时间戳  
			String time=dateFormat.format(now);
			String info=now+"";
			//获取三位随机数  
			//int ran=(int) ((Math.random()*9+1)*100); 
			//要是一段时间内的数据连过大会有重复的情况，所以做以下修改
			int ran=0;
			if(GetTime.Guid>999){
				GetTime.Guid=100;    	
			}
			ran=GetTime.Guid;
					
			return time+info.substring(2)+ran;
		}
}
