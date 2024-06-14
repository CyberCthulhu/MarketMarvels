// fetch('http://localhost:8000/api/users')
//     .then(response => response.json())
//     .then(data => {
//         data.forEach(user => {
//             console.log(user);
//         });
//     })
//     .catch(error => {
//         console.error('Error:', error);
//     });

function showDesription(serviceID){
    // hide all descriptions
    var descriptions = document.getElementsByClassName('description');
    for (var i=0; i<descriptions.length; i++){
        descriptions[i].style.display = 'none';
    }
    // show the selected description
    document.getElementById(serviceID).style.display = 'block';
}