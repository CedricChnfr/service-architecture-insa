document.addEventListener('DOMContentLoaded', function () {
    // Charger les utilisateurs pour le menu déroulant
    loadUsers();

    // Gestion de la soumission du formulaire
    document.getElementById('requestForm').addEventListener('submit', function (event) {
        event.preventDefault();  // Empêcher la soumission du formulaire classique

        const userId = document.getElementById('userSelect').value;  // Récupérer l'ID de l'utilisateur sélectionné
        const requestDescription = document.getElementById('requestDescription').value.trim();  // Description de la requête

        // Vérifier si un utilisateur a été sélectionné
        if (!userId) {
            document.getElementById('errorMessage').style.display = 'block';
            return;
        }

        // Créer la requête avec l'ID de l'utilisateur et la description
        const newRequest = {
            userId: userId,
            description: requestDescription
        };

        // Envoyer la requête POST pour créer la nouvelle requête
        fetch('http://localhost:8091/api/requests', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newRequest)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to create request');
            }
            alert('Request created successfully!');
            // Rafraîchir la liste des requêtes après la création
            loadRequests();
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to create request.');
        });
    });

    // Fonction pour récupérer et afficher toutes les requêtes
    document.getElementById('getRequestsButton').addEventListener('click', function () {
        loadRequests();
    });

    // Fonction pour charger les utilisateurs dans le menu déroulant
    function loadUsers() {
        fetch('http://localhost:8091/api/users')
            .then(response => response.json())
            .then(users => {
                const userSelect = document.getElementById('userSelect');
                users.forEach(user => {
                    const option = document.createElement('option');
                    option.value = user.id;  // Utilise l'ID comme valeur de l'option
                    option.textContent = user.firstName;  // Affiche le prénom dans la liste
                    userSelect.appendChild(option);
                });
            })
            .catch(error => {
                console.error('Error loading users:', error);
                alert('Failed to load users.');
            });
    }

    // Fonction pour charger les requêtes existantes
    function loadRequests() {
        fetch('http://localhost:8091/api/requests')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                const requestList = document.getElementById('requestList');
                requestList.innerHTML = '';  // Vider la liste existante

                data.forEach(request => {
                    const listItem = document.createElement('li');
                    listItem.textContent = `Request ID: ${request.id}, User ID: ${request.userId}, Description: ${request.description}`;
                    requestList.appendChild(listItem);
                });
            })
            .catch(error => {
                console.error('Il y a eu une erreur lors de la récupération des requêtes:', error);
            });
    }
});
