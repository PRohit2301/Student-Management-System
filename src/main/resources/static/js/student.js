// Load student details when the page loads
document.addEventListener("DOMContentLoaded", loadMyDetails);

function loadMyDetails() {
    fetch("/api/student/profile")
        .then(res => {
            if (!res.ok) throw new Error("Unauthorized");
            return res.json();
        })
        .then(student => {
            document.getElementById("id").innerText = student.id;
            document.getElementById("name").innerText = student.name;
            document.getElementById("email").innerText = student.email;
            document.getElementById("department").innerText = student.department;
            document.getElementById("year").innerText = student.year;
        })
        .catch(() => {
            alert("Session expired. Please login again.");
            window.location.href = "/student-login.html";
        });
}


// Logout function
function logout() {
    fetch("/logout", { method: "POST" })
        .then(() => window.location.href = "/index.html")
        .catch(() => window.location.href = "/index.html");
}

