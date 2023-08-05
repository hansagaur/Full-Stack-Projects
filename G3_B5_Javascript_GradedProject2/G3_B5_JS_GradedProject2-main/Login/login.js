document.querySelector('.resume').onclick = () => {

    let user = document.querySelector('#user').value;
    let password = document.querySelector('#password').value;
    let userName = localStorage.getItem('user name');
    let checkPassword = localStorage.getItem('enter password');

    if (user != userName || password != checkPassword) {
        alert("Invalid Cridential");
        return false;
    }
    return true;
};

function preventback() { window.history.forward(); }
setTimeout("preventback()", 0);
window.onunload = function() { null };