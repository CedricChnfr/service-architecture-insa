const usersApiUrl = "http://localhost:8090/users";  // URL pour récupérer les utilisateurs
const requestsApiUrl = "http://localhost:8091/api/requests";  // URL pour créer des requêtes

// Récupérer tous les utilisateurs et les afficher dans un select
async function fetchUsers() {
    try {
        const response = await fetch(usersApiUrl);
        if (response.ok) {
            const users = await response.json();
            const userSelect = document.getElementById("userSelect");
            userSelect.innerHTML = ""; // Vide le select avant de le remplir

            // Ajoute une option vide pour inciter à choisir un utilisateur
            const defaultOption = document.createElement("option");
            defaultOption.value = "";
            defaultOption.textContent = "Select a user";
            userSelect.appendChild(defaultOption);

            // Ajoute un utilisateur pour chaque élément dans le tableau des utilisateurs
            users.forEach(user => {
                const option = document.createElement("option");
                option.value = user.id;
                option.textContent = `${user.firstName} ${user.lastName} (${user.role})`;
                userSelect.appendChild(option);
            });
        } else {
            alert("Error fetching users.");
        }
    } catch (err) {
        alert("Error: " + err.message);
    }
}

// Soumettre la requête à l'API
document.getElementById("requestForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const userId = document.getElementById("userSelect").value;
    const description = document.getElementById("requestDescription").value;

    if (!userId) {
        alert("Please select a user.");
        return;
    }

    try {
        const response = await fetch(requestsApiUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                description: description
            }),
        });

        if (response.ok) {
            alert("Request submitted successfully!");
            document.getElementById("requestForm").reset();
        } else {
            const error = await response.json();
            alert(`Error: ${error.message}`);
        }
    } catch (err) {
        alert("Error submitting request: " + err.message);
    }
});

// Récupérer toutes les requêtes et les afficher
document.getElementById("getRequestsButton").addEventListener("click", async () => {
    try {
        const response = await fetch(requestsApiUrl);
        if (response.ok) {
            const requests = await response.json();
            const requestList = document.getElementById("requestList");
            requestList.innerHTML = "";

            requests.forEach(request => {
                const listItem = document.createElement("li");
                listItem.textContent = `${request.id}: ${request.description} (Status: ${request.status})`;
                requestList.appendChild(listItem);
            });
        } else {
            alert("Error fetching requests.");
        }
    } catch (err) {
        alert("Error: " + err.message);
    }
});

// Initialiser la liste des utilisateurs au chargement de la page
document.addEventListener("DOMContentLoaded", fetchUsers);
