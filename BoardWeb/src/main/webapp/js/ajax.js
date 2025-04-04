/**
 * ajax.js
 */
let dataAry = [];
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json'); // 경로지정
xhtp.send();
xhtp.onload = function() { // load 이벤트 발생 시 실행
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	dataAry = obj; // 대입
	// 화면출력
	obj.forEach(function(item){ // function(item, idx, ary)에서 idx, ary를 사용하지 않는 경우 적지않아도 괜찮음
		let tr = makeRow(item);
		document.querySelector('tbody#target').appendChild(tr);
	})
}

// 한 건 데이터를 매개값으로 tr을 생성하는 함수
function makeRow(emp = {id, first_name, last_name, email, gender, salary}) {
	const fields = ['id', 'first_name', 'last_name', 'gender'];
	let tr = document.createElement('tr'); // <tr></tr>을 생성
	
	// checkbox 만들기
	let tdc = document.createElement('td'); // <td></td>
	let cbox = document.createElement('input');
	cbox.setAttribute('type', 'checkbox');
		
	tdc.appendChild(cbox);
	tr.appendChild(tdc);
	// td 생성
	for(let i=0; i<fields.length; i++){
		let td = document.createElement('td'); // <td></td>
		td.innerHTML = emp[fields[i]]; // <td>i</td>
		tr.appendChild(td); // <tr><td>1</td><td>first_name[i]<td></tr>
	} // end of loop
	// button 생성
	let td = document.createElement('td');
    let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger');
	btn.innerText = "삭제";
	btn.addEventListener('click', deleteRow);
	// 상속관계
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
} // end of makeRow

// btn의 이벤트핸들러
function deleteRow(e) {
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
} // end of deleteRow()

// thead의 checkbox에 이벤트(change) 등록
document.querySelector('thead input[type="checkbox"]').addEventListener('change',function(e) {
	// tbody 영역의 checkbox 값 변경
	let checked = e.target.checked;
	document.querySelectorAll('tbody input[type="checkbox"]').forEach(function(item){
		item.checked = checked;
	})
}) 

// select의 change 이벤트
document.querySelector('select#searchGender').addEventListener('change', function(e) {
	let genderValue = e.target.value
	console.log(genderValue);
	// dataAry의 배열을 활용해서 출력
	// dataArt의 gender 속성을 비교화하여 출력 (출력 전에 목록 초기화)
	document.querySelector('tbody#target').innerHTML = "";
	dataAry.forEach(function(item) {
		// console.log(item);
		// 옵션과 같은 값만 출력
		if(genderValue == 'all' || item.gender == genderValue){
	    	let tr = makeRow(item);
			document.querySelector('tbody#target').appendChild(tr); // appendChild는 계속 누적되는 값이라 초기화가 필요
		}
	});
})

// end