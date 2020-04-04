import { xhr } from './xhr.js';



function getValidJson() {

	const json = sessionStorage.getItem('json.valid');
	
	if(json == null) {
		setValidJson();
	}
	
	return JSON.parse(json);
}

function setValidJson() {

	xhr('json.valid', null, result => { 
		sessionStorage.setItem('json.valid', result);			
	});

}



export { getValidJson }