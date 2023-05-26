<%-- 
    Document   : index
    Created on : 26 may. 2023, 01:26:06
    Author     : yimy
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"
        ></script>
        <link rel="stylesheet" href="css/estilos.css">
        <title>Login con JSP</title>
    </head>
    <body class="img js-fullheight" style="background-image: url('imagenes/fondo.jpg'); background-size: cover; background-repeat: no-repeat;font-family: monospace;">
        <section class="ftco-section">
            <div class="container">

                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h1>Login con java</h1>  
                    </div>       
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h3 class="mb-4 text-center">Iniciar sesion</h3>
                            <hr>
                            <form action="${pageContext.request.contextPath}/ServletControlador" class="signin-form was-validated" method="post">
                                <div class="form-group" id="form">
                                    <input type="text text-light" class="form-control" name="usuario" id="" placeholder="Usuario" required>
                                </div> 
                                <div class="form-group" id="form">
                                    <input type="password" class="form-control" name="contraseña" id="password" placeholder="Contraseña" required>
                                    <span toggle="#password-field" class="fa-solid fa-eye" id="icon" onclick="mostrarContrasena()"></span>
                                </div>  
                                <hr>
                                <div class="form-group" id="form">
                                    <input type="submit" class="form-control btn btn-primary" name="" id="" value="Ingresar">
                                </div>           
                            </form>    
                        </div>
                    </div>
                </div>

            </div>
        </section>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <<script src="js/app.js"></script>
</html>
