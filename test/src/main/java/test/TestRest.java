package test;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class TestRest {
	public static void main(String[] args) throws URISyntaxException {
		long startTime = System.currentTimeMillis();
		RestTemplate rest=new RestTemplate();
		String url="http://api.data.cma.cn:8090/api?userId=529546707913HeZ4h&pwd=FkP5jOH&dataFormat=json&interfaceId=getSurfEleByTimeRangeAndStaID&timeRange=[20180621020000,20180621020000]&staIDs=57760&elements=TEM,TEM_Max,TEM_Min,PRS,RHU,WIN_S_Avg_2mi,PRE_1h,WEP_Now,Station_Id_C,Year,Mon,Day,Hour&dataCode=SURF_CHN_MUL_HOR";
		ResponseEntity<String> responseEntity;
		try {
			responseEntity = rest.getForEntity(new URI(url), String.class);
			System.out.println(responseEntity.getBody());
			long endTime = System.currentTimeMillis();
			System.out.println("运行时间:" + (endTime - startTime) + "ms");
		} catch (RestClientException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
}
