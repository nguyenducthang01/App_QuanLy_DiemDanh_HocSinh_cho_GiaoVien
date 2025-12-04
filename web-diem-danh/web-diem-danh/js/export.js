document.addEventListener('DOMContentLoaded', () => {
    // Gọi API để hiển thị danh sách giáo viên ngay khi tải trang
    loadTeacherData();

    // Nếu cần hiển thị danh sách học sinh, bạn có thể gọi thêm:
    loadStudentData();
});

// Hiển thị danh sách giáo viên và xuất file dưới dạng Excel
async function loadTeacherData() {
    try {
        const response = await fetch('http://192.168.43.109/PHP_API/Export/teacherPush.php');
        if (!response.ok) {
            throw new Error('Failed to fetch teacher data');
        }
        const teacherData = await response.json();

        // Thay thế dữ liệu vào tbody
        const tbody = document.querySelector('.teachertable tbody');
        tbody.innerHTML = ''; // Xóa nội dung cũ

        teacherData.forEach((teacher, index) => {
            const row = `
                <tr>
                    <td>${index + 1}</td>
                    <td>${teacher.teacher_id}</td>
                    <td>${teacher.teacher_name}</td>
                    <td>${teacher.teacher_birth}</td>
                    <td>${teacher.teacher_gender}</td>
                    <td>${teacher.teacher_mail}</td>
                    <td>${teacher.teacher_phone}</td>
                    <td>${teacher.status}</td>
                </tr>
            `;
            tbody.insertAdjacentHTML('beforeend', row);
        });

        // Store data for export use later (optional)
        window.cachedTeacherData = teacherData;
    } catch (error) {
        console.error('Error exporting teacher data:', error);
    }
}

function exportTeacherData() {
    const teacherData = window.cachedTeacherData; // Use cached data
    if (!teacherData || teacherData.length === 0) {
        alert('No teacher data available to export.');
        return;
    }

    const worksheet = XLSX.utils.json_to_sheet(teacherData);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Teachers');
    XLSX.writeFile(workbook, 'TeacherData.xlsx');
}


// xuất dữ liệu sinh viên
async function loadStudentData() {
    try {
        // const response = await fetch('/api/students');
        const response = await fetch('http://192.168.43.109/PHP_API/Export/studentPush.php');
        if (!response.ok) {
            throw new Error('Failed to fetch student data');
        }
        const studentData = await response.json();

        // Thay thế dữ liệu vào tbody
        const tbody = document.querySelector('.studenttable tbody');
        tbody.innerHTML = ''; // Xóa nội dung cũ

        studentData.forEach((student, index) => {
            const row = `
                <tr>
                    <td>${index + 1}</td>
                    <td>${student.student_id}</td>
                    <td>${student.student_name}</td>
                    <td>${student.student_birth}</td>
                    <td>${student.student_gender}</td>
                    <td>${student.student_mail}</td>
                    <td>${student.student_phone}</td>
                    <td>${student.status}</td>
                </tr>
            `;
            tbody.insertAdjacentHTML('beforeend', row);
        });

        // Cache for exporting later
        window.cachedStudentData = studentData;
    } catch (error) {
        console.error('Error exporting student data:', error);
    }
}

function exportStudentData() {
    const studentData = window.cachedStudentData;
    if (!studentData || studentData.length === 0) {
        alert('No student data available to export.');
        return;
    }

    const worksheet = XLSX.utils.json_to_sheet(studentData);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Students');
    XLSX.writeFile(workbook, 'StudentData.xlsx');
}


// Gọi hàm xuất file khi nhấn vào thẻ <a>
document.querySelector('#exportTeacherBtn').addEventListener('click', (event) => {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
    exportTeacherData();
});

document.querySelector('#exportStudentBtn').addEventListener('click', (event) => {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
    exportStudentData();
});