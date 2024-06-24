fetch('http://localhost:8000/api/users')
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });


    var element = document.getElementById('');
    console.log(element);

function showDescription(serviceID) {
    var descriptions = document.getElementsByClassName('description');
    for (var i = 0; i < descriptions.length; i++) {
        descriptions[i].classList.remove('is-hidden');
    }
    
    var description = document.getElementById(serviceID);
    description.classList.add('is-hidden@xs', 'is-visible@sm');
}


