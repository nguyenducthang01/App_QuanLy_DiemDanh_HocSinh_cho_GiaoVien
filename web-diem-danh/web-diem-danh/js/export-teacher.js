document.addEventListener('DOMContentLoaded', () => {
    // Gọi API để hiển thị danh sách giáo viên ngay khi tải trang
    loadTeacherData();
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
    
    // Adjust column widths based on the content
    const columnWidths = Object.keys(teacherData[0]).map(key => {
        const maxLength = Math.max(
            key.length, // Header length
            ...teacherData.map(row => (row[key] ? row[key].toString().length : 0)) // Data length
        );
        return { wch: maxLength + 2 }; // Add padding for better readability
    });
    worksheet['!cols'] = columnWidths;

    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, 'Teachers');
    XLSX.writeFile(workbook, 'TeacherData.xlsx');
}

// Gọi hàm xuất file khi nhấn vào thẻ <a>
document.querySelector('#exportTeacherBtn').addEventListener('click', (event) => {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
    exportTeacherData();
});
