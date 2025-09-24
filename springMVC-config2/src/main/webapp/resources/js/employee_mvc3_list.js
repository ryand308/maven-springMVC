import {projectName} from "../../resources/js/url_name.js"

let list_url = projectName + '/app3/mvc/list'

//-----------------------------------------------------------------------
window.deleteEmp = function(id) {
	
	let delete_url = projectName + '/app3/mvc/delete/' + id
	
	fetch(delete_url, {method: 'DELETE'})
	.then(result => {
		if (result.ok) {
	                window.location.href = list_url;
	            } else {
	                console.error("刪除失敗", result.status);
	            }
			})
				.catch(err => console.error("錯誤:", err));
}

//-----------------------------------------------------------------------
window.infoEmp = function(id) {
		
	let info_url = projectName + '/app3/mvc/' + id + '/object'
	window.location.href = info_url;
	
}

//-----------------------------------------------------------------------
window.updateEmp = function(id) {
	
	let update_url = projectName + '/app3/mvc/update/' + id 
//	let formData = new FormData().append("empId", id)
	window.location.href = update_url;
	
}