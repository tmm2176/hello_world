/**
 * ajax.js
 */

const xhtp = new XMLHttpRequest();
xhtp.open('get', 'boardList.do'); // 경로지정
xhtp.send();
xhtp.onload = function() { // load 이벤트 발생 시 실행
	// 화면출력
    
}