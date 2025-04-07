/**
 * boardService.js
 */

const svc = {
	name: "홍길동",
	// 목록
	replyList: function(bno, successCallback, errorCall) {
		fetch('replyList.do?bno=' + bno)
			.then(result => result.json())
			.then(successCallback)
			.catch(errorCall)
	},
	// 삭제
	removeReply(rno, successCallback, errorCall) {
		fetch('removeReply.do?rno=' + rno)
			.then(result => result.json())
			.then(successCallback)
			.catch(errorCall)
	},
	//추가
	addReply(rvo = { bno, reply, replyer }, successCallback, errorCall) {
		// console.log("서비스 테스트 : " + bno, reply, replyer);
		fetch('addReply.do?bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer)
			.then(result => result.json())
			.then(successCallback)
			.catch(errorCall)
	}
}
