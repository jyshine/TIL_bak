package objectUtils.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import objectUtils.VO.UserVO;
import objectUtils.utils.ObjectUtils;

public class Test {
	public static void main(String[] args) {
		
		
		UserVO vo = new UserVO();
		UserVO vo2 = new UserVO();
		
		vo.setId("C00001");
		vo.setName("june");
		vo.setAddress("Korea");
		vo.setTel("031");
		vo.setPhone("010");
		vo.setNick("wolf");
		vo.setInfo("my information");

		vo.setHomeTown("Seoul");
		vo.setAge(29);
		vo.setDream("developer");
		
		vo2.setId("C00002");
		vo2.setName("May");
		vo2.setAddress("Korea");
		vo2.setTel("02");
		vo2.setPhone("010");
		vo2.setNick("OVE");
		vo2.setInfo("my information2");
		
		vo2.setHomeTown("Seoul2");
		vo2.setAge(30);
		vo2.setDream("developer2");
		
		ArrayList<UserVO> array = new ArrayList<UserVO>();
		array.add(vo);
		array.add(vo2);
		
		vo.setArraylist(array);
		vo.setArraylist(array);
		
		Map map = ObjectUtils.convertObjectToMap(vo);
		
	

		for(UserVO list:(ArrayList<UserVO>) map.get("arraylist")) {
			System.out.println(list);
		}
		
		Map<String, Object> toVO = new HashMap<>();
		
			toVO.put("id", "1");
			toVO.put("name", "2");
			toVO.put("address","3");
			toVO.put("tel", "4");
			toVO.put("phone","5");
			toVO.put("nick","6");
			toVO.put("info","7");
			toVO.put("arraylist",array);
		
		UserVO vo3 = new UserVO();
		
		ObjectUtils.convertMapToObject(toVO, vo3);
		System.out.println("맵을 VO로 변환 : " + vo3);
	
		for(UserVO list2:vo3.getArraylist()) {
			System.out.println("Map value ArrayList"+list2);
		}
	}
}
