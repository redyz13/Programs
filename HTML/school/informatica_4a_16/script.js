function isEmpty(entered, alertbox) {
    with(entered) {
        if (value==null || value=="") {
            if (alertbox!="")
                alert(alertbox);
            return false;
        }
        else {
            alert("Registrazione Effettuata");
            return true;
        }
    }
}

function formvalidation(ob) {
    with(ob) {
        if(isEmpty(Nome, "Compilare tutti i campi") == false) {
            Nome.focus();
            return false;
        }

        if(isEmpty(Email, "Compilare tutti i campi") == false) {
            Email.focus();
            return false;
        }

        if(isEmpty(Pass, "Compilare tutti i campi") == false) {
            Pass.focus();
            return false;
        }
    }
}
