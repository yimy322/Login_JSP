function mostrarContrasena() {
    var tipo = document.getElementById("password");
    var span = document.getElementById("icon");
    if (tipo.type == "password") {
        tipo.type = "text";
        span.className = "fa-solid fa-eye-slash";
    } else {
        tipo.type = "password";
        span.className = "fa-solid fa-eye";
    }
}
function mensajeError() {
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
    })
}

