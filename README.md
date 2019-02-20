# TIL Today I Learned 





2018.07.13 <br>
이클립에서 서버 tomcat이 실행되어 있지 않은데 충돌날 경우,<br>
강제로 서버를 내려준 후 다시 실행해본다.<br>
netstat -a -n -o -p tcp <br>
taskkill /f /pid [실행중인 tomcat 포트번호 입력] <br>


2018.07.17 <br>
JAVA Pattern과 Matcher 이용하여 CK edtor로 저장된 정보의 
이미지 태그만 축출하여 메인화면 리스트로 뿌려줌.

2018.07.20 <이클립스 디버그><br> 
[이클립스 디버그](https://github.com/jyshine/TIL/blob/master/Debug/eclipse/debug)

2018.07.22 <git 내용 정리><br>
[온라인교육 생활코딩 지옥에서 온 Git 내용 정리](https://github.com/jyshine/TIL/blob/master/git/gitfth)

2018.07.31 <ck Editor 사용법><br>
[ck editor 사용방법](https://github.com/jyshine/TIL/blob/master/ckEditor/ckeditor.txt)


2018.08.16 Design pattern with Java


2018.08.22 JPA
Java Persistence Api


2018.08.27 개발 관련 TIP

2018.08.27 Jquery API Selector 정리를 어떻게 할지 구상.

2018.09.04 Lombok Java 라이브러리 getter/setter 기타 메소드들을 annotation으로 생성할 수 있음.<br>
2018.09.04 ObjectUtil Map to Object , Object to Map <br>
2018.09.04 개발자 도구에서 css color를 확인할 수 있다. <br>
개발자 도구에서 아무 색이나 클릭한 후에 그 색을 클릭 후  네모박스에 칼라를 클릭하면 확인가능.
2018.09.05 java에서 리스트간 비교할 때 CollectionUtils 또는 ListUtils사용하면 

2018.09.07 한글파일,PDF 다운로드 시 깨지는 현상
    <mime-mapping>
      <extension>zip</extension>
      <mime-type>application/zip</mime-type>
    </mime-mapping>
    
 <mime-mapping>
     <extension>hwp</extension>
      <mime-type>application/unknown</mime-type>
   </mime-mapping>

<mime-mapping>
<extension>pdf</extension>
<mime-type>application/pdf</mime-type>
</mime-mapping>

2018.09.14 Oracle View 테이블 사용 <br>
http://www.oracletutorial.com/oracle-view/oracle-create-view/<br>

2018.09.19 console 로그 안짤리게 하는 방법. <br>
이클립스 window > Preferences > Run/Debug > Console : Limit console output 체크해제.

2018.09.19 input tag 안에는 title 혹은 lable 필수 (웹표준 기준) <br>
시각장애인 전용으로 웹 소개시 필요. table 만들 시 caption도 필요.<br>

2018.09.19 IE11 에서 DOM7009 에러 <br>
http://hyunchang88.tistory.com/151

2018.09.20 이클립스 DevStyle Theme Eclipse Marketplace

2018.09.27 카카오 코딩 테스트 

2018.10.11 게시판 이전글 다음글 가져오는 쿼리 


jsp의 jstl 의 값을 javascript의 변수로 넣는 방법
프로그래밍/JavaScript 2014.11.19 09:45
<c:set var="checkDate" var='${request.getParameter("Date")}' />

이렇게 받아온 CheckDate를

 

javascript의 변수인

var chDate 라는 변수가 있을 때

checkDate값을 chDate에 넣어주고 싶습니다.



이런질문이있었다 



답은



var chDate = '<c:out value="${checkDate}"/>';  이렇게 하면된다.



출처: http://adgw.tistory.com/entry/jsp의-jstl-의-값을-javascript의-변수로-넣는-방법 [앗뜨거워

2018.10.31 JqGrid Document <br>
http://www.guriddo.net/documentation/guriddo/javascript/



json list

log

2018.12.03 <br>

 netstat -antl 
 서버 접속자 확인
 top  
cpu%  시스템 사용량 확인

ps -ef | grep java 
프로세스를 확인 | 자바 


2019.01.07 XSS 공격 방지  <br>
http://openeg.co.kr/383 참고
<br>
	web.xml
//    <filter>
//		<filter-name>xssFilter</filter-name>
//		<filter-class>com.pack1.pack2.XSSFilter</filter-class>
//	</filter>
//	<filter-mapping>
//		<filter-name>xssFilter</filter-name>
//		<url-pattern>/*</url-pattern>
//	</filter-mapping>
<br>------------------------------------------------------------------------------   
    import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class XSSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//Logger.debug("xss filter running...");
		
		chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);

	}
}
    
    
<br>------------------------------------------------------------------------------


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * XSS
 * @author exD984
 *
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

//	private static final Pattern[] patterns = new Pattern[] {
//			Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
//			Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
//			Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
//			Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
//			Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
//			Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
//			Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
//			Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
//			Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
//			Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
//	};
	
	public XSSRequestWrapper(HttpServletRequest servletRequest) {

		super(servletRequest);

	}

	@Override
	public String[] getParameterValues(String parameter) {
        //System.out.println("getParameterValues");
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}

		int count = values.length;

		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}

		return encodedValues;

	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		
		value = stripXSS(value);
		
		//System.out.println("[" + parameter + "]=" + value);

		return value;

	}

	@Override
	public String getHeader(String name) {
		//System.out.println("getHeader");
		String value = super.getHeader(name);
		return stripXSS(value);

	}

	/**
	 * XSS Filter   
	 * @param value
	 * @return
	 */
	public static String stripXSS(String value) {
		if(!StringUtil.isEmpty(value) && isStripXSS(value)) {
			//value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");	
			//value = "XSS Filtered";
			
			// XXX
//			value = value.replaceAll("<", "&lt;");
//			value = value.replaceAll(">", "&gt;;");
//			value = value.replaceAll("\\(", "&#40;");
//			value = value.replaceAll("\\)", "#41;");
//			value = value.replaceAll("#", "#35;");
//			value = value.replaceAll("&", "#38;");
//			value = value.replaceAll("\"", "&quot;");
//			value = value.replaceAll("'", "&apos;");
			
			value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
	        //value = value.replaceAll("\"", "&quot;");
	        //value = value.replaceAll("'", "&#39;");
			//value = value.replaceAll("#", "#35;");
			//value = value.replaceAll("&", "#38;");
	        
//	        value = value.replaceAll("eval\\((.*)\\)", "");
//	        value = value.replaceAll("expression\\((.*)\\)", "");
//	        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
//	        value = value.replaceAll("[\\\"\\\'][\\s]*vbscript:(.*)[\\\"\\\']", "\"\"");
	        //value = value.replaceAll("script", "");
		}
		return value;
	}
	
	public static String unstripXSS(String value) {
		if(!StringUtil.isEmpty(value) && isUnStripXSS(value)) {
			value = value.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	        value = value.replaceAll("&#40;", "\\(").replaceAll("&#41;", "\\)");
		}
		return value;
	}
	
	/**
	 * StripXSS
	 * @param value
	 * @return
	 */
	public static boolean isStripXSS(String value) {
		boolean isStripXSS = StringUtil.isEmpty(value) ? false : true;
		
		return isStripXSS;
	}
	
	public static boolean isUnStripXSS(String value) {
		boolean isStripXSS = StringUtil.isEmpty(value) ? false : 
			value.indexOf("&lt;") != -1 || value.indexOf("&gt;") != -1 || value.indexOf("&#40;") != -1 || value.indexOf("&#41;") != -1;
		
		return isStripXSS;
	}
	
//	public static boolean isStripXSS(String value) {
//		boolean isStripXSS = false;
//		
//		if (value != null) {
//
//			for (Pattern scriptPattern : patterns) {
//				if ( scriptPattern.matcher(value).matches() ) {
//					isStripXSS = true;
//					break;
//				}
//			}
//		}
//		return isStripXSS;
//	}
	
	public static void main(String[] args) {
		String value = "";
		//String value = "<script>alert('test')</script>";
		
		boolean isStrip = isUnStripXSS(value);
		String newValue = unstripXSS(value);
		
		System.out.println(isStrip);
		System.out.println(value+"|"+newValue);
		
		System.exit(0);
	}
}






--2019.02.20
copy from userid/pw@000.000.00.00:1521/orcl insert INDUK_TMENTORHISTORY using select * from INDUK_TMENTORHISTORY;
