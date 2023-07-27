<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Page Title</title>
</head>
<body>
	<div>
		<button class="myBtn" type="button" id="minusBtn">감소</button>
		<p id="num">0</p>
		<button class="myBtn" type="button" id="plusBtn">증가</button>
	</div>
</body>
<script>
        let num = document.getElementById("num");
        let myBtn = document.querySelectorAll(".myBtn");

        let number = 0;
        minusBtn.disabled = true;

        for (let elem of myBtn) {
            elem.addEventListener("click", numChange);
        }

        function numChange(x) {
            if (x.target == minusBtn) {
                number--;
            } else if (x.target == plusBtn) {
                number++;
            }
            nuberZero()
            num.innerText = number;
        }

        function nuberZero() {
            if (number > 0) {
                minusBtn.disabled = false;
            } else {
                minusBtn.disabled = true;
            }
        }
    </script>
</html>
