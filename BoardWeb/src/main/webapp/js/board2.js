/**
 * board2.js
 */

const table = new DataTable('#example', {
    ajax: 'replyListDataTable.do?bno='+bno ,
    columns: [
        { data: 'REPLY_NO' },
        { data: 'REPLY' },
        { data: 'REPLYER' },
        { data: 'REPLY_DATE' }
    ],
	lengthMenu: [
	    [5, 10, 25, 50, -1],
	    [5, 10, 25, 50, 'All']
	],
	order: [[0, 'desc']]
});

// 1. 등록
function addNewRow() {
	let reply = document.querySelector('#reply').value;

	// control을 통해서 db 한 건 생성
	fetch('addReply.do?bno=' + bno + '&replyer=' + replyer + "&reply=" + reply)
		.then(result => result.json())
		.then(result => {
			console.log(result);
			// 화면에 출력
			if (result.retCode == 'OK') {
				let item = result.retVal;
				alert('댓글등록성공!');
				table.row
					.add({
						REPLY_NO: item.replyNo,
						REPLY: item.reply,
						REPLYER: item.replyer,
						REPLY_DATE: item.replyDate
					})
					.draw(false);
					document.querySelector('#reply').value='';
			} else {
				alert('댓글등록실패!');
			}
		})
		.catch(err => console.error(err));
}
document.querySelector('#addRow').addEventListener('click', addNewRow);

// 2. 삭제
let selectRow = null; // 전역 변수로 선택된 행 저장 / 추가
table.on('click', 'tbody tr', (e) => {
	console.log(e.currentTarget.children[0].innerHTML);
	// 삭제할 댓글을 선택하는 이벤트
	
	selectRow = e.currentTarget; // 클릭한 tr을 저장 / 추가
	
    let classList = e.currentTarget.classList; // class 목록
	
	// classList에 추가 add('클래스명'), 포함? contains('클래스명'), 제거 remove('클래스명')
    if (classList.contains('selected')) {
        classList.remove('selected');
    }
	else {
		table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
		classList.add('selected');
	}
});

// 삭제한 영역을 "화면에서" 지우는 코드
document.querySelector('#delRow').addEventListener('click', function () {
    if (!selectRow) {
        alert('삭제할 댓글을 선택하세요.');
        return;
	}
    let rno = selectRow.children[0].innerHTML;

	fetch('removeReply.do?rno=' + rno)
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert("삭제성공!!");
				// id 속성
				table.row('.selected').remove().draw(false); // 화면에서도 삭제
				selectRow = null; // 삭제 완료 후 선택 해제 / 추가
			} else {
				console.error(err);
				alert('삭제 실패!');
			}
		})
		.catch(err => console.error(err));
});


//end of file