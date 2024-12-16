// app.js

document.addEventListener('DOMContentLoaded', function () {
    // Gestion de la soumission du formulaire
    document.getElementById('volunteerForm').addEventListener('submit', function (event) {
        event.preventDefault();  // Empêcher la soumission du formulaire classique

        // Récupérer les informations saisies par le volontaire
        const firstName = document.getElementById('firstName').value.trim();
        const lastName = document.getElementById('lastName').value.trim();
        const skills = document.getElementById('skills').value.trim();
        
        // Récupérer les disponibilités (valeurs des boutons radio)
        const availability = {
            monday: document.querySelector('input[name="monday"]:checked')?.value,
            tuesday: document.querySelector('input[name="tuesday"]:checked')?.value,
            wednesday: document.querySelector('input[name="wednesday"]:checked')?.value,
            thursday: document.querySelector('input[name="thursday"]:checked')?.value,
            friday: document.querySelector('input[name="friday"]:checked')?.value,
            saturday: document.querySelector('input[name="saturday"]:checked')?.value,
            sunday: document.querySelector('input[name="sunday"]:checked')?.value
        };

        // Vérifier que tous les champs sont remplis
        if (!firstName || !lastName || !skills || Object.values(availability).includes(undefined)) {
            document.getElementById('errorMessage').style.display = 'block';
            document.getElementById('successMessage').style.display = 'none';
            return;
        }

        // Créer l'objet de données à envoyer
        const volunteerData = {
            firstName: firstName,
            lastName: lastName,
            skills: skills,
            availability: availability
        };

        // Envoyer les données à l'API via une requête POST
        fetch('http://localhost:8092/volunteers', {  // Remplacer l'URL par l'API correspondante
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(volunteerData)  // Convertir les données en JSON
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to submit volunteer data');
            }
            document.getElementById('errorMessage').style.display = 'none';
            document.getElementById('successMessage').style.display = 'block';
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to submit volunteer data.');
        });
    });
});
