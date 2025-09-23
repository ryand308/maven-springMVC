
let paramForm = document.getElementById("paramForm");
let describe = "";

describe = `
	<form action="http://localhost:8080/maven-springMVC-config/app/gener/paraValue" method="get">
		<label for="id">ID:</label><br>
		<input type="number" id="id" name="value1" required><br>
		<label for="name">Name:</label><br>
		<input type="text" id="name" name="value2"><br/>
		<input type="submit" value="送出" />
	</form>
`

paramForm.innerHTML = describe;