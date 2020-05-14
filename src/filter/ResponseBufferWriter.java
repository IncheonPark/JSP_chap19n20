package filter;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ResponseBufferWriter extends PrintWriter{
	
	public ResponseBufferWriter() {
		super(new StringWriter(4096)); //이 super가 의미 하는 것은 PrintWriter.PrintWriter(Writer out)생성자이다.
		//new StringWriter는 StringWriter 객체를 생성하면서 기본 객체인 out의 데이터를 끌어온다. 애초에 out의 정보를 가져오는 코드를 작성할 필요가 없다.
	}
	//out은 기본객체로 JSP가 실행되는 시점에 이미 out기본 객체로 모든 데이터를 넘김. out엔 이미 데이터가 들어가 있는 상태
	
	//가정1 Writer out = new StringWriter(4096); 조상 타입 Writer 자손객체 new StringWriter  
	//가정2 new로 만든 StringWriter객체를 Writer타입으로 받기 떄문에 밑에서 다시 StringWriter로 캐스팅 하는게 아닐까?
	
	//사실은 Writer out 안에 StringWriter객체가 들어간다. out의 타입은 변하지 않은 상태로 자손 객체 보관.
	//out이 Writer이기 때문에 toString을 쓰는 시점에서 StringWriter로 형변환 해 준다.
	public String toString() {
		return ((StringWriter)super.out).toString();
	}

}
