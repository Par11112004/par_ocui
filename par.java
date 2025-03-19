const apiKey = 'YOUR_API_KEY'; // Replace with your OpenWeatherMap API key

async function getWeather() {
    const city = document.getElementById("city-input").value;
    if (!city) {
        alert("Please enter a city.");
        return;
    }

    const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`;
    
    try {
        const response = await fetch(url);
        const data = await response.json();
        
        if (data.cod !== 200) {
            alert("City not found!");
            return;
        }

        document.getElementById("city-name").innerText = data.name;
        document.getElementById("temperature").innerText = `Temperature: ${data.main.temp}°C`;
        document.getElementById("description").innerText = `Description: ${data.weather[0].description}`;
        document.getElementById("humidity").innerText = `Humidity: ${data.main.humidity}%`;
        document.getElementById("wind-speed").innerText = `Wind Speed: ${data.wind.speed} m/s`;
    } catch (error) {
        alert("Error fetching weather data.");
        console.error(error);
    }
}
