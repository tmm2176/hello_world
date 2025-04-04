/**
 * array.js
 * push -> 마지막위치에 추가 / unshift 처음위치에 추가
 * pop -> 마지막위치를 삭제 / shift 처음 위치를 제거
 * splice 추가, 수정, 삭제 전부 가능
 * forEach()
 */
const ary = [];
// push, unshift
ary.push('홍길동'); 
ary.push('김길동');
ary.unshift('최길동');

// ary.pop(); 
// ary.shift();

// ary.splice(0, 0, '박길동', '황길동'); // splice(index=>시작 인덱스, deleteCount=> 제거할 요소 수, item=>대체값)
// deleteCount를 0으로 하면 추가, item을 입력하지 않으면 삭제

ary.forEach(function(item, idx, ary) {
	console.log(`item=> ${item}, index=> ${idx}, array=> ${ary}`);
});

// 배열에 요소 추가 함수
function addElement(elem = "noElem") {
	ary.push(elem);
} // end of addElement()

// 화면에서 요소를 제거하는 함수
function deleteElement(e){
	//alert('삭제버튼클릭됨');
	console.log(e.target.parentElement);
	e.target.parentElement.remove();
} // end of deleteElement

// 추가버튼에 클릭이벤트
document.querySelector('button#addBtn').addEventListener('click', function(){
	// input의 값
	let val = document.querySelector('input#userInput').value;
	addElement(val); // ary 배열에 추가
	// 화면에 출력
	let html='';
	ary.forEach(function(item, idx, ary){
		html += '<li>' +item+ '<button onclick="deleteElement(event)">삭제</button></li>';
	});
	// ul태그의 영역
	document.querySelector('ul#list').innerHTML = html;
});