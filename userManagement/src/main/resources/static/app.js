const apiBaseUrl = "http://localhost:8090/users";

// Ajouter un utilisateur
document.getElementById("addUserForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const role = document.getElementById("role").value;

    try {
        const response = await fetch(apiBaseUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                role: role,
            }),
        });

        if (response.ok) {
            alert("User added successfully!");
            document.getElementById("addUserForm").reset();
            //fetchUsers(); // Rafraîchit la liste des utilisateurs
        } else {
            const error = await response.json();
            alert(`Error: ${error.message}`);
        }
    } catch (err) {
        alert("Error adding user: " + err.message);
    }
});

// Récupérer tous les utilisateurs
async function fetchUsers() {
    try {
        const response = await fetch(apiBaseUrl);

        if (response.ok) {
            const users = await response.json();
            const userList = document.getElementById("userList");
            userList.innerHTML = ""; // Vide la liste avant de la remplir

            users.forEach((user) => {
                const listItem = document.createElement("li");
                listItem.textContent = `${user.id}: ${user.firstName} ${user.lastName} (${user.role})`;

                // Bouton pour supprimer un utilisateur
                const deleteButton = document.createElement("button");
                deleteButton.textContent = "✖"; // Symbole de croix
                deleteButton.style.marginLeft = "10px";
                deleteButton.style.color = "red";
                deleteButton.style.border = "none";
                deleteButton.style.cursor = "pointer";
                deleteButton.onclick = () => deleteUser(user.id);

                listItem.appendChild(deleteButton);
                userList.appendChild(listItem);
            });
        } else {
            alert("Error fetching users.");
        }
    } catch (err) {
        alert("Error: " + err.message);
    }
}

// Supprimer un utilisateur
async function deleteUser(userId) {
    try {
        const response = await fetch(`${apiBaseUrl}/${userId}`, {
            method: "DELETE",
        });

        if (response.ok) {
            alert("User deleted successfully!");
            fetchUsers(); // Rafraîchit la liste des utilisateurs après suppression
        } else {
            alert("Error deleting user.");
        }
    } catch (err) {
        alert("Error: " + err.message);
    }
}

// Initialiser la liste des utilisateurs au chargement de la page
document.getElementById("getUsersButton").addEventListener("click", fetchUsers);
