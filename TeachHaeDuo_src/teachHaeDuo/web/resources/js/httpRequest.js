/**
 * 
 */
var httpReq = null; 
	// 브라우저마다 다르게 생성해야하므로 함수를 만들어서 객체를 return 받는 것으로 하겠습니다.
	function getXMLHttpRequest(){
		//IE에서 
		if(window.ActiveXObject)  {
			try{
				return new activeXOjbect("Msxml2.XML");
			} catch (e){
				try{
					return new ActiveXObeject("Microsoft.XMLHTTP");
				} catch(e1){
					//못만듬
					return null;
				}
			}
		} else if(window.XMLHttpRequest) {
			return new XMLHttpRequest(); 
		} else {
			return null;
		}
	}
	
	function sendRequest(method, url, params, callback){
		//1. 객체 생성 : script문에 요청을 위한 XMLHttpRequest객체 생성
		httpReq = getXMLHttpRequest()
		// 2. 서버 응답 처리 함수 생성 및 지정(onreadystatechange에 함수 지정)
		httpReq.onreadystatechange = callback;

		
	/* 	responseText / responseXML
		3. open()메소드 호출하여 요청 방식, 대상(서버), 동기/비동기 지정
		4. send()메소드 호출하여 대상(서버)에 전송 */
		httpReq.open(method, url, true);
		httpReq.send(params);
		
	}
