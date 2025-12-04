document.addEventListener('DOMContentLoaded', () => {

    // Nếu cần hiển thị danh sách học sinh, bạn có thể gọi thêm:
    loadStudentData();
});

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

    // Adjust column widths based on the content
    const columnWidths = Object.keys(studentData[0]).map(key => {
        const maxLength = Math.max(
            key.length, // Header length
            ...studentData.map(row => (row[key] ? row[key].toString().length : 0)) // Data length
        );
        return { wch: maxLength + 2 }; // Add padding for better readability
    });
    worksheet['!cols'] = columnWidths;

    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Students');
    XLSX.writeFile(workbook, 'StudentData.xlsx');
}

document.querySelector('#exportStudentBtn').addEventListener('click', (event) => {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
    exportStudentData();
});