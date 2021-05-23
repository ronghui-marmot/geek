package cn.git.zrh;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import io.github.kimmking.gateway.router.HttpEndpointRouter;

public class Week3_4_MarmotHttpRouter implements MarmotHttpRouter{

	@Override
	public String route(List<String> urls) {
		// TODO Auto-generated method stub
		int size = urls.size();
//		if(Calendar.DAY_OF_WEEK%2==0) {
//			System.out.println("-------偶数天路由到-------");
//			return urls.get(0);
//		}else {
//			System.out.println("-------奇数天路由到-------");
//			return urls.get(1);
//		}
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
	}
	
}
