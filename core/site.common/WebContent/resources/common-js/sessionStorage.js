import { xhr } from './xhr.js';



function getValidJson() {

	let valid = sessionStorage.getItem('valid.json');

	if(valid == null) {
		setValidJson();
		valid = sessionStorage.getItem('valid.json');
	}

	return JSON.parse(valid);
}



function setValidJson() {

	xhr('ajax.valid.json', null, server => { 
		sessionStorage.setItem('valid.json', server);			
	});

}



export { getValidJson }