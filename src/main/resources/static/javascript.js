window.onload = function() {
    const SERVER_URL = 'http://localhost:8080/api/song';

    document.getElementById('btn-get-song').addEventListener('click', getSong);

    async function getSong() {
        const topicInput = document.getElementById('topicInput').value.trim();
        console.log('Topic Input:', topicInput);

        const songSpinner = document.getElementById('songSpinner');
        const songOutput = document.getElementById('songOutput');
        const counter = document.getElementById('counter');

        songOutput.style.color = 'black';

        try {
            songSpinner.style.display = 'block';
            counter.innerText = '20';

            const apiUrl = `${SERVER_URL}?topic=${encodeURIComponent(topicInput)}`;
            const response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({topic: topicInput}),
            }).then(response => response.json());

            songOutput.innerText = `Recommended Song: ${response.answer}`;
            document.getElementById('topicInput').value = '';
        } catch (e) {
            songOutput.style.color = 'red';
            songOutput.innerText = `Error fetching song recommendation: ${e.message}`;
        } finally {
            songSpinner.style.display = 'none';
        }
    }

    let countdown = 20; // Initial countdown value
    function startCountdown() {
        countdown = 20;
        const countdownInterval = setInterval(function () {
            if (countdown > 0) {
                countdown--;
                document.getElementById('counter').innerText = countdown;
            } else {
                clearInterval(countdownInterval);
            }
        }, 1000);
    }
    document.getElementById('btn-get-song').addEventListener('click', startCountdown)

};
