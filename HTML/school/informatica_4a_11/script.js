function printTable() {
  var a = 10;
  for(i = 1; i <= 10; i++)
    document.write("<tr><td>" + a + " * " + i + " = " + "</td><td>" + a * i + "</td></tr>");
}

function showTable() {
  document.getElementById("table").style.display = "";
}

function hideTable() {
  document.getElementById("table").style.display = "none";
}
