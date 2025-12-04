<?php
    require "dbCon.php";
	if(isset($_POST['class_id']) && isset($_POST['student_id']) && isset($_POST['attendance_time']) && isset($_POST['status']))
	{	
		$class_id= $_POST['class_id'];
		$student_id = $_POST['student_id'];
		$attendance_time = $_POST['attendance_time'];
		$status = $_POST['status'];
        // Get du lieu ve
		$query1 = "SELECT class_name, teacher_id FROM class WHERE class_id= '$class_id'";
		$data = mysqli_query($connect, $query1);
		while ($row = mysqli_fetch_assoc($data)) {
			$class_name = $row['class_name'];
			$teacher_id = $row['teacher_id'];
		};
		//check data student in class
		$query3 = "SELECT * FROM student_class WHERE class_id = '$class_id' and student_id = '$student_id'";
		$data3 = mysqli_query($connect, $query3);
		while ($row = mysqli_fetch_assoc($data3)) {
			$check_student = $row['student_id'];
		};
		if(!empty($check_student))
		{
			// add data attendance
			$query2 = "INSERT INTO attendance (class_id, class_name,teacher_id,student_id,attendance_time,status) VALUES ('$class_id','$class_name','$teacher_id','$student_id','$attendance_time','$status')";
			$datachange = mysqli_query($connect, $query2);
			echo "Done";
		} else
		{
			echo "Error";
		}
	};
?>