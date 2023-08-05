document.querySelector('.match').onclick = () => {

    let pass1 = document.querySelector('#pass1').value;
    let pass2 = document.querySelector('#pass2').value;

    if (pass1 != pass2) {
        alert("Password Not Match");
        return false;
    }
    return true;
};

let name, user;
document.querySelector('#username').addEventListener('input', function() {
    //store your user id in local device
    name = this.value;
    localStorage.setItem('user name', name);
});

document.querySelector('#pass1').addEventListener('input', function() {
    //store your password in local device
    password = this.value;
    localStorage.setItem('enter password', password);
});

function preventback() { window.history.forward(); }
setTimeout("preventback()", 0);
window.onunload = function() { null };