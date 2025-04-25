document.getElementById('emailForm').addEventListener('submit', function(event) {
    event.preventDefault();  // Evita que el formulario se envíe normalmente

    const emailType = document.getElementById('emailType').value;
    const email = document.getElementById('emailAddress').value;

    // Validación básica
    if (!email || !emailType) {
        alert('Por favor, completa todos los campos');
        return;
    }

    const baseUrl = 'http://localhost:8080';  // Cambia esto si tu backend corre en otro puerto
    let url = '';

    switch (emailType) {
        case 'newAccount':
            url = `${baseUrl}/sendNewAccountEmail/${email}`;
            break;
        case 'forgotPassword':
            url = `${baseUrl}/sendForgotPassword/${email}`;
            break;
        case 'codeVerification':
            url = `${baseUrl}/sendCodeEmail/${email}`;
            break;
        case 'changedPassword':
            url = `${baseUrl}/sendChangedPassword/${email}`;
            break;
        case 'stockUpdate':
            url = `${baseUrl}/sendStockEmail/${email}`;
            break;
        case 'shopping':
            url = `${baseUrl}/sendShoppingEmail/${email}`;
            break;
        default:
            alert("Tipo de correo no válido.");
            return;
    }

    // Realiza la solicitud fetch al backend
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al enviar el correo'); 
            }
            return response.text(); // Tu backend responde con texto plano
        })
        .then(data => {
            console.log('Correo enviado:', data);
            mostrarMensaje('✅ Correo enviado con éxito!');
        })
        .catch(error => {
            console.error('Error:', error);
            mostrarMensaje('❌ Error al enviar el correo. Revisa la consola.');
        });
});

function mostrarMensaje(mensaje) {
    let msgDiv = document.getElementById('statusMessage');
    if (!msgDiv) {
        msgDiv = document.createElement('div');
        msgDiv.id = 'statusMessage';
        msgDiv.style.marginTop = '15px';
        msgDiv.style.fontWeight = 'bold';
        document.querySelector('.form-container').appendChild(msgDiv);
    }
    msgDiv.textContent = mensaje;
}
