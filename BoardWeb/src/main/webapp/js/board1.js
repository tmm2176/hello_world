/**
 * board1.js
 * XMLHttpRequest, fetch => 실행순서
 */

let page = 1;

// 함수표현식
let successCallback = function successCallback(result) {
	console.log(result);
	// 기존목록 화면에서 지우기
	document.querySelectorAll('div.reply div.content ul>li').forEach(function(item, idx) {
		if (idx) { // truthy, falsy(0, null, '', undefined)
			item.remove();
		}
	});
	// 새로운 목록 출력
	result.forEach(item => {
		makeRow2(item);
	});
}

// 에러 콜백
function errorCallback(err) {
	console.log(err);
}

// 페이징 콜백
function pagingCallback(result) {
	// 페이지 목록 지우기
	document.querySelector('nav>ul.pagination').innerHTML = "";
	//console.log(result.totalCnt);
	let totalCnt = result.totalCnt;
	// 첫 페이지, 마지막 페이지 => 현재 페이지를 기준으로 계산\
	let startPage, endPage;
	// 이전페이지, 이후페이지
	let prev, next;
	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = endPage > realEnd ? realEnd : endPage;
	prev = startPage == 1 ? false : true;
	next = endPage < realEnd ? true : false;

	let html1;
	// 이전 페이지
	if (!prev) {
		html1 = `<li class="page-item disabled">`
		html1 += `<span class="page-link">Previous</span></li>`		
	} else {
		html1 = `<li class="page-item">`
		html1 += `<a class="page-link" data-page="${startPage - 1}">Previous</a></li>`
	}
	let target1 = document.querySelector('nav>ul.pagination')
	target1.insertAdjacentHTML('beforeend', html1);
	// 페이지 갯수
	let html2;
	for (let p = startPage; p <= endPage; p++) {
		if (p == page) {
			html2 = `<li class="page-item active" aria-current="page">
				  <span class="page-link">${p}</span></li>`
		} else {
			html2 = `<li class="page-item"><a class="page-link" data-page="${p}">${p}</a></li>`
		}
		let target3 = document.querySelector('nav>ul.pagination')
		target3.insertAdjacentHTML('beforeend', html2);
	} // end of loop

	// 이후 페이지
	let html3;
	if (!next) {
		html3 = `<li class="page-item disabled">`
		html3 += `<span class="page-link">Next</span></li>`
	} else {
		html3 = `<li class="page-item">`
		html3 += `<a class="page-link" data-page="${endPage + 1}">Next</a></li>`
	}
	let target5 = document.querySelector('nav>ul.pagination')
	target5.insertAdjacentHTML('beforeend', html3);
	// 링크이벤트
	pageLink(); // 요소가 만들어진 다음 이벤트를 걸어야 한다
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
				// 댓글목록
				svc.replyList({ bno, page }, successCallback, errorCallback);
				// 페이징목록
				svc.pagingList(bno, pagingCallback, errorCallback);
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
				// 댓글목록
				svc.replyList({ bno, page }, successCallback, errorCallback);
				// 페이징목록
				svc.pagingList(bno, pagingCallback, errorCallback);
			} else {
				alert('등록실패!');
			}
		}, errorCallback);
})

// 페이지 링크 이벤트 등록
function pageLink() {
	document.querySelectorAll('div.reply ul a').forEach(function(atag) {
		atag.addEventListener('click', function(e) {
			e.preventDefault(); // 이벤트의 기본기능 차단
			page = atag.dataset.page; // <a>3</a>
			// 댓글목록
			svc.replyList({ bno, page }, successCallback, errorCallback);
			// 페이징목록
			svc.pagingList(bno, pagingCallback, errorCallback);
		})
	});
}

// 목록보여주기
svc.replyList({ bno, page }, successCallback, errorCallback);
// 페이징 목록 보여주기
svc.pagingList(bno, pagingCallback, errorCallback);

// {bno:bno, page:page}처럼 같을 경우 위와 같이 한 번에 입력 가능
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


