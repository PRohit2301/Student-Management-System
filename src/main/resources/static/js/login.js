function login(role) {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch(`/api/auth/login?username=${username}&password=${password}`)
        .then(response => response.json())
        .then(data => {
            if (data.role === role) {
                if (role === "ADMIN") {
                    window.location.href = "/admin-dashboard.html";
                } else {
                    window.location.href = "/student-dashboard.html?username=" + username;
                }
            } else {
                document.getElementById("msg").innerText = "Unauthorized role";
            }
        })
        .catch(() => {
            document.getElementById("msg").innerText = "Invalid login";
        });
}
