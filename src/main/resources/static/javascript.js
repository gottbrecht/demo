const SERVER_URL = 'http://localhost:8080/api';

document.getElementById('btn-get-song').addEventListener('click', getSong);

async function getSong() {
    const topicInput = document.getElementById('topicInput').value.trim();
    console.log('Topic Input:', topicInput);

    const songSpinner = document.getElementById('songSpinner');
    const songResult = document.getElementById('songResult'); // Corrected variable name
    songResult.style.color = 'black';

    try {
        songSpinner.style.display = 'block';

        const apiUrl = `${SERVER_URL}/song?topic=${encodeURIComponent(topicInput)}`; // Corrected string interpolation
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ topic: topicInput }),
        }).then(response => response.json());

        songResult.innerText = `Recommended Song: ${response.answer}`; // Corrected string interpolation
        document.getElementById('topicInput').value = '';
    } catch (e) {
        songResult.style.color = 'red';
        songResult.innerText = `Error fetching song recommendation: ${e.message}`; // Corrected string interpolation
    } finally {
        songSpinner.style.display = 'none';
    }
}

