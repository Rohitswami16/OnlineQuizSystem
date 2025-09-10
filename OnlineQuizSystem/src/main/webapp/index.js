function updateOptions() {
	let num = parseInt(document.getElementById("admin-num-options").value);

	if (num >= 1 && num <= 6) {
		for (let i = 1; i <= 6; i++) {
			document.getElementById("admin-option-div-" + i).style.display = (i <= num) ? "block" : "none";
			document.getElementById("admin-option-" + i).required = (i <= num);
		}
		document.getElementById("admin-correct-answer").max = num;
	} else {
		alert("Please enter a number between 1 and 6.");
	}
}
