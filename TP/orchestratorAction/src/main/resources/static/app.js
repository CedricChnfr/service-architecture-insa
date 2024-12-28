function sendSensorData() {
    // Récupérer les valeurs des inputs
    let presence = document.getElementById("presence").checked ? 1 : 0;
    let indoorTemperature = document.getElementById("indoorTemp").value;
    let outdoorTemperature = document.getElementById("outdoorTemp").value;
    let currentTime = document.getElementById("currentTime").value;

    // Construire les données à envoyer
    let data = {
        indoorTemperature: parseFloat(indoorTemperature),
        outdoorTemperature: parseFloat(outdoorTemperature),
        presence: presence,
        currentTime: currentTime
    };

    // Effectuer la requête HTTP POST
    fetch('http://localhost:8090/api/orchestrator/manage', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        // Mettre à jour les états des capteurs après la réponse de l'API
        document.getElementById("windowState").innerHTML = data.isWindowOpen ? 'Ouverte' : 'Fermée';
        document.getElementById("doorState").innerHTML = data.isDoorClosed ? 'Fermée' : 'Ouverte';
        document.getElementById("lightState").innerHTML = data.isLightOn ? 'Allumée' : 'Éteinte';
        document.getElementById("alarmState").innerHTML = data.isAlarmTriggered ? 'Activée' : 'Désactivée';
    })
    .catch(error => {
        console.error('Erreur:', error);
    });
}

function getDeviceStatus() {
    // Effectuer la requête HTTP GET
    fetch('http://localhost:8090/api/orchestrator/status', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        // Mettre à jour les états des capteurs après la réponse de l'API
        document.getElementById("windowState").innerHTML = data.isWindowOpen ? 'Ouverte' : 'Fermée';
        document.getElementById("doorState").innerHTML = data.isDoorClosed ? 'Fermée' : 'Ouverte';
        document.getElementById("lightState").innerHTML = data.isLightOn ? 'Allumée' : 'Éteinte';
        document.getElementById("alarmState").innerHTML = data.isAlarmTriggered ? 'Activée' : 'Désactivée';
    })
    .catch(error => {
        console.error('Erreur:', error);
    });
}

function sendPostRequest(url) {
    fetch(url, {
        method: 'POST'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        console.log('Success:', data);
        getDeviceStatus(); // Mettre à jour l'état des capteurs après l'action
    })
    .catch(error => {
        console.error('Erreur:', error);
    });
}

// Appeler la fonction pour obtenir l'état des capteurs au chargement de la page
window.onload = getDeviceStatus;