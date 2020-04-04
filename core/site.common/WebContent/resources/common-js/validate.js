import * as session from './sessionStorage.js';



const valid = session.getValidJson();

export function validate($data, callback) {
	
	const id = $data.hasOwnProperty('adminId') ? 'adminId' : 'userId';
	const pwd = $data.hasOwnProperty('adminPwd') ? 'adminPwd' : 'userPwd';

	Object.defineProperties(
		$data, {
			'id' : Object.getOwnPropertyDescriptor($data, id),
			'pwd' : Object.getOwnPropertyDescriptor($data, pwd)
		}
	);
	
	delete $data[id];
	delete $data[pwd];


	
	for(let key in $data){
		
		switch(key){
			case 'id' :
				if( !$data[key] || $data[key].length == 0 ){
					return callback(`아이디를 입력하세요.`);
				
				} else if( $data[key].length < valid.id.min ){
					return callback(`아이디는 ${valid.id.min} 자리 이상 입력하세요.`);
				
				} else if( RegExp(valid.id.pattern).test($data[key]) == false ){
					return callback(`아이디는 영문 및 숫자만 입력 가능합니다.`);
				}
			break;
			
			case 'pwd' :
				if( !$data[key] || $data[key].length == 0 ){
					return callback(`비밀번호를 입력하세요.`);
				
				} else if( $data[key].length < valid.pwd.min ){
					return callback(`비밀번호는 ${valid.pwd.min} 자리 이상 입력하세요.`);
				}
			break;
				
			case 'email' :
				if( !$data[key] || $data[key].length == 0 ){
					return callback(`이메일을 입력하세요.`);
					
				} else if( $data[key].length < valid.email.min ){
					return callback(`이메일은 ${valid.email.min} 자리 이상 입력하세요.`);
				
				} else if( RegExp(valid.email.pattern).test($data[key]) == false ){
					return callback(`이메일 형식에 맞지 않습니다.`);
				}
			break;
			
			// 게시판 
			case 'title' :
				if( !$data[key] || $data[key].length == 0 ){
					return callback(`제목을 입력하세요.`);
				} 
			break;
			
			case 'content' :
				if( !$data[key] || $data[key].length == 0 ){
					return callback(`내용을 입력하세요.`);
				}
			break;
			
			// 검색
			case 'keyword' :
				if( !$data[key] || $data[key].length == 0 ){
					return callback(`검색어 입력하세요.`);
					
				} else if( $data[key].length < valid.keyword.min ){
					return callback(`검색어는 ${valid.keyword.min} 자리 이상 입력하세요.`);
				}
			break;
		} 
		
	}

	return callback(true);
}