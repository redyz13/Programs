let obj;

const xhttp = new XMLHttpRequest();

xhttp.open("GET", "../venditaAutoveicoli.json", true);
xhttp.send();

console.log(xhttp);

xhttp.onreadystatechange = function () {
  if (this.readyState === 4 && this.status === 200) {
    obj = JSON.parse(this.responseText);
    console.log(obj);
  }

  for (let i = 0; i < obj.auto.length; i++) {
    document.getElementById("auto").innerHTML +=
      `

                <div class="card">
                <img src="
                ` +
      obj.auto[i].immagine +
      `" alt="Avatar" style="width:100%">
                <div class="container">
                <h4><b>` +
      obj.auto[i].nome +
      `</b></h4>
                <p>Marca : ` +
      obj.auto[i].marca +
      `</p>
                    <p>Cilindrata : ` +
      obj.auto[i].cilindrata +
      `</p>
                    <p>tipo motore: ` +
      obj.auto[i].tipoMotore +
      `</p>
                    <p> alimentazione:` +
      obj.auto[i].alimentazione +
      `</p>
                    <p> cavalli: ` +
      obj.auto[i].cavalli +
      `</p>
                    <p> consumo: ` +
      obj.auto[i].consumo +
      `</p>
                    <p> a partire da: ` +
      obj.auto[i].prezzo +
      `</p>
                </div>
            </div>
            
            `;
  }
};
