// Load students when page loads
window.onload = loadStudents;

/*
 ADD or UPDATE student
 */
function saveStudent() {
    const id = document.getElementById("studentId").value;

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        department: document.getElementById("department").value,
        year: document.getElementById("year").value
    };

    // ADD
    if (id === "") {
        fetch("/api/admin/students", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(student)
        }).then(() => {
            alert("Student added");
            resetForm();
            loadStudents();
        });
    }
    // UPDATE
    else {
        fetch(`/api/admin/students/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(student)
        }).then(() => {
            alert("Student updated");
            resetForm();
            loadStudents();
        });
    }
}

/*
 LOAD all students
 */
function loadStudents() {
    fetch("/api/admin/students")
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("studentTable");
            table.innerHTML = "";

            data.forEach(s => {
                table.innerHTML += `
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.email}</td>
                        <td>${s.password}</td>
                        <td>${s.department}</td>
                        <td>${s.year}</td>
                        <td>
                            <button onclick="editStudent(${s.id})">Edit</button>
                            <button onclick="deleteStudent(${s.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}

/*
 DELETE student
 */
function deleteStudent(id) {
    fetch(`/api/admin/students/${id}`, {
        method: "DELETE"
    }).then(() => {
        alert("Student deleted");
        loadStudents();
    });
}

/*
 EDIT student (fill SAME form)
 */
function editStudent(id) {
    fetch("/api/admin/students")
        .then(res => res.json())
        .then(students => {
            const s = students.find(st => st.id === id);

            document.getElementById("studentId").value = s.id;
            document.getElementById("name").value = s.name;
            document.getElementById("email").value = s.email;
            document.getElementById("department").value = s.department;
            document.getElementById("year").value = s.year;

            document.getElementById("submitBtn").innerText = "Update";
        });
}

/*
 RESET form back to ADD mode
 */
function resetForm() {
    document.getElementById("studentId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("department").value = "";
    document.getElementById("year").value = "";

    document.getElementById("submitBtn").innerText = "Add";
}

