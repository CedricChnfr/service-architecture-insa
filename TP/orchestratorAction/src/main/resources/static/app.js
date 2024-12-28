function updateActionneur() {
    // Récupérer les valeurs des inputs
    let presence = document.getElementById("presence").checked ? 1 : 0;  // 1 pour présence, 0 sinon
    let indoorTemperature = document.getElementById("temperature").value;
    let outdoorTemperature = document.getElementById("outdoorTemperature").value;

    // Construire l'URL pour envoyer les données en GET
    let url = `http://localhost:8090/api/orchestrator/manage?presence=${presence}&indoorTemperature=${indoorTemperature}&outdoorTemperature=${outdoorTemperature}`;

    // Effectuer la requête HTTP GET
    fetch(url, {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        // Mettre à jour les états des capteurs après la réponse de l'API
        document.getElementById("window").innerHTML = `Fenêtre : ${data.isWindowOpen ? 'Ouverte' : 'Fermée'}`;
        document.getElementById("door").innerHTML = `Porte : ${data.isDoorClosed ? 'Fermée' : 'Ouverte'}`;
        document.getElementById("light").innerHTML = `Lumière : ${data.isLightOn ? 'Allumée' : 'Éteinte'}`;
        document.getElementById("alarm").innerHTML = `Alarme : ${data.isAlarmTriggered ? 'Activée' : 'Désactivée'}`;
    })
    .catch(error => {
        console.error('Erreur:', error);
    });
}
