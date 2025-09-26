<resource> 폴더
여러 리소스 파일들을 보관하는 곳이다.
src/main/resource 라는 경로로 클래스 패스가 자동으로 포함이 된다.

클래스 패스란, JVM이 필요한 클래스 파일이나 리소스 파일을 찾는 경로를 말한다.
쉽게 말하자면, 클래스 패스란 '서재 목록'과 같다.
JVM은 요구되는 바이트 코드나, 리소스를 찾을때 '클래스 파일'을 먼저 찾을 것이다.



<resource/static> 폴더
static 폴더같은 경우에는, '정적'인 '자원'을 의미한다.

여기서 '정적'이라는 말은, 프로그램이 실행되기 이전에 결정된다는 의미이다.
그리고 '자원'이라는 말은 서버에서 클라이언트에게 보내는 데이터라는 의미이다.
이때 static 폴더에 있는 여러 html파일 또한, '정적'인 '자원'을 의미한다.

정적인 자원은 html,css,javaScript,이미지 파일... 등을 의미한다.

java spring으로 웹 서버를 run할때,
static 폴더에 있는 자원에 접근하는 방식은,
(URL : localhost:8080/hello-static.html)와 같은 방식으로 접근한다.

[index.html]
index.html같은 경우에는 URL이 localhost:8080인 경우에,
바로 나오는 welcome page에 해당한다.



<resource/templates> 폴더
templates 폴더같은 경우에는, Thymeleaf나 FreeMarker과 같은 템플릿 엔진의
템플릿 파일들을 보관한다.

만약에 controller의 method의 String을 return한다면,
해당 String은 html문서 파일의 이름을 의미한다.
곧바로 controller는 resource/template폴더에서 해당하는 html 템플릿 문서를 찾을 것이다.
이후 dependency로 추가한 템플릿 엔진(해당 프로젝트에서는 Thymeleaf)에 의해서,
데이터 + html 템플릿 -> html 문서가 클라이언트의 웹 브라우저로 전송되어, 렌더링된다.





