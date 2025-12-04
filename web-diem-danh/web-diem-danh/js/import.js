// API để thêm file danh sách giáo viên

function uploadTeacherList(file) {
    if (!file || !(file instanceof File)) {
        return Promise.reject(new Error('Please provide a valid file'));
    }

    const formData = new FormData();
    formData.append('file', file);

    return fetch('http://192.168.43.109/PHP_API/Upload/data/upload-teacher.php', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(`Upload failed: ${text}`);
                });
            }
            return { status: 'success', message: 'File uploaded successfully' };
        })
        .catch(error => {
            console.error('Error uploading teacher list:', error);
            throw error;
        });
}

document.getElementById('uploadForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    const fileInput = document.getElementById('fileInput');
    const message = document.getElementById('message');

    try {
        const file = fileInput.files[0];
        const result = await uploadTeacherList(file);
        message.textContent = result.message;
    } catch (error) {
        message.textContent = 'Upload failed: ' + error.message;
    }
});


// API để thêm file danh sách sinh viên
function uploadStudentList(file) {
    const formData = new FormData();
    formData.append('file', file);
    // console.log('http://192.168.43.109/PHP_API/Upload/data/upload-student.php');

    return fetch('http://192.168.43.109/PHP_API/Upload/data/upload-student.php', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => {
                throw new Error(`Upload failed: ${text}`);
            });
        }
        return { status: 'success', message: 'File uploaded successfully' };
    })
    .catch(error => {
        console.error('Error uploading teacher list:', error);
        throw error;
    });
}

document.getElementById('importForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    const fileInput = document.getElementById('fileInput');
    const message = document.getElementById('message');

    try {
        const file = fileInput.files[0];
        const result = await uploadStudentList(file);
        message.textContent = result.message;
    } catch (error) {
        message.textContent = 'Upload failed: ' + error.message;
    }
});


