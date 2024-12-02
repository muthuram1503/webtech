<?php
// Database connection parameters
$servername = "localhost";
$username = "root"; // Change this if your MySQL server has a different username
$password = "12345678";     // Enter your MySQL server password
$dbname = "my_database"; // Your database name

// Establish connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Retrieve form data
    $name = $conn->real_escape_string($_POST['name']);
    $email = $conn->real_escape_string($_POST['email']);
    $phone = $conn->real_escape_string($_POST['phone']);
}
    // Insert data into database
    $sql = "INSERT INTO users (name, email, phone) VALUES ('$name', '$email', '$phone')";

    if ($conn->query($sql) === TRUE) {
        echo "New record created successfully!";
    } 

// Close the connection
$conn->close();
?>
