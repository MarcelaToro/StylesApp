//Validación JS para Email
document.getElementById("emailForm").addEventListener("submit", function(event) {
    const email = document.getElementById("email").value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!emailRegex.test(email)) {
        alert("Por favor, introduce un correo válido.");
        event.preventDefault(); // Prevenir envío del formulario
    }
});
//Muestra mensajes instantáneos para mejorar la experiencia de usuario, 
//como cuando un formulario se está procesando o cuando un campo tiene un error
function showLoader() {
    document.getElementById("loader").style.display = "block";
}

function hideLoader() {
    document.getElementById("loader").style.display = "none";
}

document.getElementById("submitBtn").addEventListener("click", showLoader);

//Medidor de Fortaleza de Contraseña
const passwordInput = document.getElementById("password");
const strengthMeter = document.getElementById("strengthMeter");

passwordInput.addEventListener("input", function() {
    const strength = getPasswordStrength(passwordInput.value);
    strengthMeter.value = strength;
});

function getPasswordStrength(password) {
    let strength = 0;
    if (password.length > 6) strength++;
    if (password.match(/[a-z]/)) strength++;
    if (password.match(/[A-Z]/)) strength++;
    if (password.match(/[0-9]/)) strength++;
    if (password.match(/[@$!%*?&#]/)) strength++;
    return strength;
}

//Modal de confirmación
function showModal() {
    document.getElementById("modal").style.display = "block";
}

function closeModal() {
    document.getElementById("modal").style.display = "none";
}





