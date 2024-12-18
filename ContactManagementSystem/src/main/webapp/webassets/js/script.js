function openForm(id) {
	document.getElementById(id).style.display = "block";
}

function closeForm(id) {
	document.getElementById(id).style.display = "none";
}

function fill(event, elementId, inputId1, inputId2, inputId3) {
	let row = event.target.closest("tr");

	let name = row.cells[0].innerText;
	let email = row.cells[1].innerText;
	let contact = row.cells[2].innerText;

	document.getElementById(inputId1).value = email;
	document.getElementById(inputId2).value = contact;
	document.getElementById(inputId3).value = name;

	openForm(elementId);
}

function showAlert(msg) {
	if (msg !== undefined && msg != "") {
		alert(msg);
	}
}

function copyToClipboard() {
    let textElement = document.getElementById('url');
	let popup =  document.getElementById("share-popup")
    let text = textElement.value || textElement.innerText;

    navigator.clipboard.writeText(text)
        .then(() => {
           popup.style.display="block";
        })
        .catch(err => {
            console.error("Failed to copy text: ", err);
        });
}

function searchContact() {

	let input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("search");
	filter = input.value.toUpperCase();
	table = document.getElementById("table");
	tr = table.getElementsByTagName("tr");


	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		if (td.length > 0) {

			for (j = 0; j < td.length; j++) {
				txtValue = td[j].textContent || td[j].innerText
				if (txtValue.toUpperCase().indexOf(filter) > -1 || txtValue.indexOf(input.value) > -1) {
					tr[i].style.display = "";
					break
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}
}