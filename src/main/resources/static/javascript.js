const SERVER_URL = 'http://localhost:8080/api';

document.getElementById('btn-get-song').addEventListener('click', getSong);
async function getSong() {
    const topicInput = document.getElementById('topicInput').value.trim();
    const songSpinner = document.getElementById('songSpinner');
    const songResult = document.getElementById('songResult');
    songResult.style.color = 'black';

    try {
        songSpinner.style.display = 'block';
        const apiURL = '${SERVER_URL}/song?topic=${encodeURIComponent(topicInput)}';
        const response = await fetch(apiUrl).then(handleHttpErrors);
        songResult.innerText = 'Recommended Song: ${response.song}';
        document.getElementById('topicInput').value = '';
    } catch (e) {
        songResult.style.color = 'red';
        songResult.innerText = 'Error fetcing song recommendation: ${e.message}';
    } finally {
        songSpinner.style.display = 'none';
    }
}


function handleHttpErrors(response) {
    if(!response.ok) {
        throw new Error('HTTP error! Status: ${response.status}');
    }
    return response.json();
}

