export function xhr(url, data, callback){
	
	const xhr = new XMLHttpRequest();

	if( !xhr ){	
		console.log('XMLHttpRequest failed');
		return callback(null);
	}

	xhr.onload = function() {
		
		if( this.readyState === XMLHttpRequest.DONE && this.status === 200 ){
			
			try {
				
				callback(this.responseText);
				
			} catch(error){
				console.error(error.message);
				callback(null);
			}
			
		} else {
			callback(null);
		}
		
	};

	xhr.open('POST', url, true);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(data);

}