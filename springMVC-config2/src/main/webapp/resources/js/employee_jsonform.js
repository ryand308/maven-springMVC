import { app_rest_add , formSuccess} from './url_name.js'

document.getElementById("empForm").onsubmit = function(event) {

	event.preventDefault();

	const data = {
		name: document.getElementById("name").value,
		email: document.getElementById("email").value,
		salary: parseFloat(document.getElementById("salary").value)
	}

	fetch(app_rest_add, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(data)
	})
		// 資料送出後轉跳
		.then(result =>
			window.location.href = formSuccess			
			
		)
}