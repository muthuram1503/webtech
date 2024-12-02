<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'];
    $year = $_POST['year'];
    $department = $_POST['department'];

    echo "Name: " . htmlspecialchars($name) . "<br>";
    echo "Year: " . htmlspecialchars($year). "<br>";
    echo "Department: " . htmlspecialchars($department);
}
?>
