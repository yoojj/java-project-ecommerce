import { xhr } from '../../common-js/xhr.js';



function getAdminSessionConstant() {
	
	let key = sessionStorage.getItem('admin.session.key');
	
	if(key == null){
		setAdminSessionConstant();
		key = sessionStorage.getItem('admin.session.key');
	}
	
	return key;
}

function setAdminSessionConstant() {
	
	xhr('ajax.adminSessionConstant', null, server => { 
		sessionStorage.setItem('admin.session.key', server);			
	});

}



export { getAdminSessionConstant }