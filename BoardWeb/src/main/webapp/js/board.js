/**
 * board.js
 */
console.log(bno);
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=' + bno);
xhtp.send();
xhtp.onload = function(){
	console.log(xhtp.responseText); // json 문자열
	let data = JSON.parse(xhtp.responseText);
	console.log(data); //object
	data.forEach(function(item){
		makeRow2(item);
	}) // end of forEach 
} // end of onload

// 댓글정보 -> 화면출력
function makeRow2(item) {
	let html = `<li>
	  <span class="col-sm-2">${item.replyNo}</span>
	  <span class="col-sm-5">${item.reply}</span>
	  <span class="col-sm-2">${item.replyer}</span>
	  <span class="col-sm-2"><button>삭제</button></span>
	</li>`;
	let templ = document.querySelector('div.content>ul');
	templ.insertAdjacentHTML('beforeend', html);
}

function makeRow(item) {
	// template 가져오기
	let templ = document.querySelector('div.content>ul>li').cloneNode(true); 
	//cloneNode 대상노드에 직접 값을 입력하는게 아닌 복사본을 만들어 값을 변경 / true 옵션은 하위 값도 변경인 듯
	
	console.log(templ);
	templ.querySelector('span:nth-of-type(1)').innerHTML = item.replyNo;
	templ.querySelector('span:nth-of-type(2)').innerHTML = item.reply;
	templ.querySelector('span:nth-of-type(3)').innerHTML = item.replyer;
	templ.querySelector('span:nth-of-type(4)').innerHTML = '<button>삭제</button>';
	
	document.querySelector('div.content>ul').appendChild(templ);		
}
