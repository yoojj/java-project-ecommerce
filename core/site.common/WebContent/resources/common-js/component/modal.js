const $modalContent = document.querySelector('template').content;
const $el = document.importNode($modalContent, true);

const $modalOverlay = document.createElement('div');
$modalOverlay.setAttribute('id', 'modalOverlay');

const $modalContainer = document.createElement('div');
$modalContainer.setAttribute('id', 'modalContainer');
$modalContainer.appendChild($modalOverlay);



export function toggleModal(){

	let modalContainer = document.querySelector('#modalContainer');
	
	if( modalContainer == null ){
		
		$modalContainer.removeAttribute('class', 'modal-close');

		document.body.appendChild($modalContainer);
		
		addModalListener();

	} else {
		
		$modalContainer.setAttribute('class', 'modal-close');
		
		setTimeout(function(){
			document.body.removeChild($modalContainer);
		}, 500);

		removeModalListener(modalContainer);
		
	}

}



function addModalListener(){
	
	let modalContainer = document.querySelector('#modalContainer');
	
	if(modalContainer){
		modalContent(modalContainer);
		modalContainer.querySelector('#modalOverlay').addEventListener('click', toggleModal);
		modalContainer.querySelector('#btnCloseModal').addEventListener('click', toggleModal);
	}
}



function removeModalListener(modalContainer){
	if(modalContainer){
		modalContent(modalContainer);
		modalContainer.querySelector('#modalOverlay').removeEventListener('click', toggleModal);
		modalContainer.querySelector('#btnCloseModal').removeEventListener('click', toggleModal);
	}
}



function modalContent(modalContainer){

	if(modalContainer){
		modalContainer.appendChild( $el );
	}
	
}