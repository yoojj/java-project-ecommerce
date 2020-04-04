export function fetchInit(url, data) { 

	let contentType = 'application/json';

	if((typeof data) != 'object'){
		contentType = 'multipart/form-data';
	}
	
	const init = {
		headers: new Headers({
			'charset': 'utf-8',
			'content-type': contentType,
			'accept': contentType
		}),
		method: 'POST',
		mode: 'cors',
		cache: 'default',
		body: JSON.stringify(data),
	}
	
	return fetch(url, init).then( res => { 
		
			if(res.ok){
				
				let result = res.json();
				
				if(result == null){
					// 확인 필요
					result = res.blob().then( blob => { URL.createObjectURL(blob); });
				}
				
				return result;
			}

		}).catch( error => {
			console.log(`fetch error :: ${error}`);
			return error.message;
		});

}