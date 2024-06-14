fetch('http://localhost:8000/api/users')
    .then(response => response.json())
    .then(data => {
        data.forEach(user => {
            console.log(user);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });