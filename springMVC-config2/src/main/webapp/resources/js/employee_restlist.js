import {app_rest_list, app_rest_object, app_rest_update, app_rest_delete} from './url_name.js'

let table = document.getElementById('emptable');
let list = document.getElementById('emplist');
let form = document.getElementById('empform');

let desc = ``;

fetch(app_rest_list)
	.then(resp => resp.json())
	.then(data => {
		
		data.forEach(emp => {
			// return console.log(emp);
			desc += `
				<tr>		
					<td>${emp.empId}</td>
					<td>${emp.name}</td>
					<td>${emp.email}</td>
					<td>${emp.salary}</td>
					<td>${emp.date}</td>
					<td><button onclick="updateEmp(${emp.empId})" >⬆️</button></td>					 
					<td><button onclick="deleteEmp(${emp.empId})" >🗑️</button></td>
				</tr>				
			`
		});

		list.innerHTML = desc;
	})

// 全域函式 (window.updateEmp) ;fetch 使用下的function
window.updateEmp = function(id) {
	
	table.style.display = 'none'; // 隱藏
	
	fetch(app_rest_object + id)
	.then(resp => resp.json())
	.then(emp => {		
		
		desc = `			
				<label for="name">Name:</label><br>
				<input type="text" id="name" name="name"  value="${emp.name}" required><br/>
				<label for="email">email:</label><br>
				<input type="email" id="email" name="email" value="${emp.email}" required><br>
				<label for="salary">salary:</label><br>
				<input type="number" id="salary" name="salary" value="${emp.salary}" required><br>
				<input type="hidden" id="empId" name="empId" value="${emp.empId}" />
				<input type="submit" value="送出" />
			
		`
		
		form.innerHTML = desc
		
		form.onsubmit = function(event) {				
			
			event.preventDefault();
			const data = {
				empId: parseInt(document.getElementById("empId").value),
				name: document.getElementById("name").value,
				email: document.getElementById("email").value,
				salary: parseFloat(document.getElementById("salary").value)
			}

			fetch(app_rest_update, {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(data)
			})
				// 資料送出後轉跳
				.then(result => window.location.reload() )
				
		}
	})
}

window.deleteEmp = function(id) {
	
	fetch(app_rest_delete, {
					method: "POST",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(id)
				})
					// 資料送出後轉跳
					.then(result => window.location.reload() )
}

