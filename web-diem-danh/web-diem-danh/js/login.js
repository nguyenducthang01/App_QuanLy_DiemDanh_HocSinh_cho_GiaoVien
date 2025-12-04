
async function login(username, password) {
    const apiUrl = 'http://192.168.43.109/PHP_API/getuser.php'; // Replace with your API endpoint


    try {
        const formData = new FormData();
        formData.append('username', username);
        formData.append('password', password);

        const response = await fetch(apiUrl, {
            method: 'POST',
            body: formData,
        });

        if (!response.ok) {
            throw new Error('Login failed. Please check your credentials.');
        }

        const data = await response.json();
        console.log('Login successful:', data);

        // Handle successful login (e.g., save token, redirect user)
        localStorage.setItem('authToken', data.token);
        window.location.href = '/web-diem-danh/home.html'; // Redirect to dashboard
    } catch (error) {
        console.error('Error during login:', error.message);
        alert('Login failed. Please try again.');
    }
}

// Example usage
document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    login(username, password);
});