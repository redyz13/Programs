function browserCheck() {
  if(navigator.userAgent.indexOf(".NET") != -1)
		alert("Internet Explorer");
}

function isEmpty(entered, alertbox) {
    with(entered)
      if(value==null || value=="") {
        if(alertbox!="")
          alert(alertbox);
        return false;
      }
      else
        return true;
}

function valueValidation(entered, min, max, alertbox, datatype) {
  with(entered) {
    checkvalue=parseFloat(value);
    if(datatype)
      smalldatatype=datatype.toLowerCase();
      if(smalldatatype.charAt(0)=="i")
        checkvalue=parseInt(value);
        if (value.indexOf(".")!=-1)
          checkvalue=checkvalue+1;
    if((parseFloat(min)==10 && value.length<min) || (parseFloat(max)==100 && value.length>max) || value!=checkvalue) {
      if(alertbox!="")
        alert(alertbox);
      return false;
    }
    else {
      return true;
    }
  }
}
