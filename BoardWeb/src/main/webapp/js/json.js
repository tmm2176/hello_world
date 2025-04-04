/**
 * json.js
 */

const jsonStr=`[{"id":1,"first_name":"Petronella","last_name":"Crouch","email":"pcrouch0@yellowpages.com","gender":"Female","salary":4093},
{"id":2,"first_name":"Doreen","last_name":"Halls","email":"dhalls1@dyndns.org","gender":"Polygender","salary":4265},
{"id":3,"first_name":"Marguerite","last_name":"Plitz","email":"mplitz2@ezinearticles.com","gender":"Female","salary":8424},
{"id":4,"first_name":"Conrade","last_name":"Neilands","email":"cneilands3@ask.com","gender":"Male","salary":1340},
{"id":5,"first_name":"Brandi","last_name":"Scotcher","email":"bscotcher4@google.nl","gender":"Female","salary":2713},
{"id":6,"first_name":"Madlen","last_name":"Sharkey","email":"msharkey5@vinaora.com","gender":"Genderfluid","salary":2637},
{"id":7,"first_name":"Martyn","last_name":"Life","email":"mlife6@epa.gov","gender":"Male","salary":7686},
{"id":8,"first_name":"Christye","last_name":"Babar","email":"cbabar7@hp.com","gender":"Female","salary":6058},
{"id":9,"first_name":"Sharity","last_name":"Ripley","email":"sripley8@theglobeandmail.com","gender":"Female","salary":2644},
{"id":10,"first_name":"Eyde","last_name":"Sollett","email":"esollett9@wikia.com","gender":"Genderfluid","salary":9821},
{"id":11,"first_name":"Town","last_name":"Goldster","email":"tgoldstera@diigo.com","gender":"Male","salary":4369},
{"id":12,"first_name":"Isidoro","last_name":"Ronisch","email":"ironischb@yahoo.com","gender":"Male","salary":9296},
{"id":13,"first_name":"Trever","last_name":"Adderson","email":"taddersonc@washington.edu","gender":"Male","salary":1169},
{"id":14,"first_name":"Peggi","last_name":"Baylay","email":"pbaylayd@skype.com","gender":"Polygender","salary":5703},
{"id":15,"first_name":"Shermie","last_name":"Jackes","email":"sjackese@de.vu","gender":"Male","salary":9881}]`;

let obj = JSON.parse(jsonStr); // json문자열 -> object 변경
let str = JSON.stringify(obj); // object -> json 문자열 변경

// console.log(obj);

// 한 건 데이터를 매개값으로 tr을 생성하는 함수
function makeRow(emp = {id, first_name, last_name, email, gender, salary}) {
	const fields = ['id', 'first_name', 'last_name', 'email'];
	let tr = document.createElement('tr'); // <tr></tr>을 생성
	for(let i=0; i<fields.length; i++){
		let td = document.createElement('td'); // <td></td>
		td.innerHTML = emp[fields[i]]; // <td>i</td>
		tr.appendChild(td); // <tr><td>1</td><td>first_name[i]<td></tr>
	} // end of loop
	return tr;
} // end of makeRow

// 화면출력
obj.forEach(function(item, idx, ary){
	let tr = makeRow(item);
	document.querySelector('tbody#target').appendChild(tr);
})


