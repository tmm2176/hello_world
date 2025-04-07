/**
 * board1.js
 * XMLHttpRequest, fetch => 실행순서
 */


// 함수표현식
let successCallback = function successCallback(result) {
	console.log(result);
	result.forEach(item => {
		makeRow2(item);
	});
}

// 에러 콜백
function errorCallback(err) {
	console.log(err);
}

// 삭제함수
function deleteFnc(rno = 21) {
	let deleteOK = confirm("삭제하겠습니까?")
	if (!deleteOK) {
		return;
	}
	svc.removeReply(rno// 삭제할 댓글번호
		, function(result) {
			console.log(result); // {retCode: 'OK/NG'}
			if (result.retCode == 'OK') {
				alert("삭제성공!!");
				// id 속성
				document.querySelector('#rno_' + rno).remove();
			}
		}
		, errorCallback);
}

// 이벤트                 버튼 태그 중 클래스 이름이 addReply인 것을 불러오기
document.querySelector('button.addReply').addEventListener('click', function(e) {
	// 등록
	if (replyer == '') {
		alert('로그인하세요');
		return;
	}
	// bno, replyer, reply: #reply.value 속성
	let reply = document.querySelector('#reply').value;
	if (reply == '') {
		alert('댓글을 등록하세요');
		return;
	}
	//	console.log("이벤트 test :" + bno, reply, replyer); // 이건 잘나옴
	svc.addReply({ bno, reply, replyer } // 등록을 위한 첫번째 매개변수
		, function(result) {
			//console.log(result)
			if (result.retCode == 'OK') {
				alert('등록성공!');
				let item = result.retVal; // 반환결과값 활용
				makeRow2(item);
			} else {
				alert('등록실패!');
			}
		}, errorCallback);
})

// 목록보여주기
svc.replyList(bno, successCallback, errorCallback);

// 함수선언식
//function successCallback(result){
//    console.log(result);
//	result.forEach(item => {
//		makeRow2(item);
//	});
//}

// 댓글정보 -> 화면에 출력
function makeRow2(item) {
	let html = `<li data-rno="${item.replyNo}" id="rno_${item.replyNo}">
	    <span class="col-sm-2">${item.replyNo}</span>
	    <span class="col-sm-5">${item.reply}</span>
	    <span class="col-sm-2">${item.replyer}</span>
	    <span class="col-sm-2"><button onclick="deleteFnc(${item.replyNo})">삭제</button></span>
	</li>`;
	let templ = document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend', html);
}
// 동기, 비동기(Asynchronous Javascript And Xml -> AJAX)
setTimeout(function() {
	console.log('1');

	setTimeout(function() {
		console.log('2');

		setTimeout(function() {
			console.log('3');
		}, 1000);
	}, 1000);
}, 1000);
// setTimeout(실행할 함수, 처리시간) => 대표적인 비동기 함수


