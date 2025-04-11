/**
 * js/array2.js
 */
const numAry = [10, 17, 23, 26, 49];
let filterAry = numAry.filter(function(item, idx, ary){
	return item % 2 == 0;
});
console.log(filterAry);

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

const jsonAry = JSON.parse(jsonStr);
// {id, first_name, ...}

filterAry = jsonAry.filter(item => item.gender == "Male" && item.salary >= 5000);
console.log(filterAry);

// reduce()
console.clear();
let result = [10, 23, 34, 48, 51].reduce(function(acc, item){
	console.log(acc, item);
	if (item > 30){
		acc.push(item);
	}
	return acc; // acc값으로 활용
}, []); // 초기값
console.log('result: ', result);
console.clear();

let list = document.querySelector('#list'); // <ul id="list" />
[10, 23, 34, 48, 51].reduce((acc, item) => {
	let li = document.createElement('li');
	li.innerHTML = item; // <li>10</li>
	acc.appendChild(li);
	
	return acc;
}, list);
console.clear();

const ary = [
	{name: "홍길동", phone:"010-1111-2222"},
	{name: "최길동", phone:"010-1111-3333"},
	{name: "박길동", phone:"010-1111-4444"},
	{name: "김길동", phone:"010-1111-5555"},
	{name: "서길동", phone:"010-1111-6666"}
]
// ul의 요소로 이름- 연락처 출력
ary.reduce((acc, item) => {
	let li = document.createElement('li');
	li.innerHTML = "이름 : " + item.name + " - 전화번호 : " + item.phone; // <li>10</li>
	acc.appendChild(li);
	return acc;
}, list);
