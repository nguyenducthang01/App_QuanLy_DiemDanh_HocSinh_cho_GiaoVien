// main.js

document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const importForm = document.getElementById('importForm');

    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;
            loginUser(username, password);
        });
    }

    if (importForm) {
        importForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const fileInput = document.getElementById('fileInput');
            const file = fileInput.files[0];
            if (file) {
                uploadFile(file);
            } else {
                alert('Please select a file to upload.');
            }
        });
    }
});