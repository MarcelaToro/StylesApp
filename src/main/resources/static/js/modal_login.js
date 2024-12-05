// Mostrar el modal al cargar la página
document.addEventListener("DOMContentLoaded", function () {
    const modal = document.getElementById("promoModal");
    const closeBtn = document.querySelector(".close");
    const tryNowBtn = document.getElementById("tryNowBtn");
    const tryLaterBtn = document.getElementById("tryLaterBtn");

    // Mostrar el modal
    modal.style.display = "block";

    // Cerrar el modal al hacer clic en la 'x'
    closeBtn.onclick = function () {
        modal.style.display = "none";
    };

    // Botón "Probar ahora" lleva a la página de registro de peluquería
    tryNowBtn.onclick = function () {
        window.location.href = "/formularioPeluqueria"; // Ajusta esta URL a la de tu página de registro
    
    };

    // Botón "Probar más tarde" solo cierra el modal
    tryLaterBtn.onclick = function () {
        modal.style.display = "none";
    };

    // Cerrar el modal al hacer clic fuera de él
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };
});
