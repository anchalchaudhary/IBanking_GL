/*jslint devel: true */
/* jshint browser: true */
/* jshint -W041:false */

//function validate() {
//    "use strict";
//    if (document.forms.empReg.fname.value == "" || document.forms.empReg.lname.value == "" || document.forms.empReg.age.value == 0 || document.forms.empReg.gender.checked == false) {
//        document.getElementById("error").style.display = "block";
//        alert("Error");
//    }
//    return false;
//}

function validateEmpRegForm() {
    'use strict';
    var validationStatus = true;
    var fname = document.forms["empregistration"]["fname"].value;
    var lname = document.forms["empregistration"]["lname"].value;
    var age = document.forms["empregistration"]["age"].value;
    var radios = document.getElementsByName("gender");
    if(fname == "") {
        validationStatus = false;
    } else if(lname == "") {
        validationStatus = false;
    } else if(age == "") {
        validationStatus = false;
    }
    var len = radios.length;
    var chosen = "";
    for(var i = 0; i < len; i++) {
        var gen = false;
        if(radios[i].checked) {
            gen = true;
            chosen = radios[i].value;
            break;
        }
    }
    if(!gen) {
        validationStatus = false;
    }
    if(!validationStatus) {
        alert("Form validation fails");
    } else{
        alert("Success");
    }
    return validationStatus;
}