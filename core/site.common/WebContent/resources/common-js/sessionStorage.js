import { xhr } from './xhr.js';



function getValidJson() {

	const json = sessionStorage.getItem('valid.json');
	
	if(json) {
		setValidJson();
	}
	
	return JSON.parse(json);
}

function setValidJson() {

	xhr('valid.json', null, result => { 
		sessionStorage.setItem('valid.json', result);			
	});

}



export { getValidJson }