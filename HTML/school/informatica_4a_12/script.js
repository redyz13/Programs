function changeText(button) {
  switch(button.id) {
    case "1": document.getElementById("p1").innerHTML =
      ("Questo è il nuovo testo del paragrafo 1"); break;
    case "2": document.getElementById("p2").innerHTML =
      ("Questo è il nuovo testo del paragrafo 2"); break;
    case "3": document.getElementById("p3").innerHTML =
      ("Questo è il nuovo testo del paragrafo 3"); break;
  }
}
