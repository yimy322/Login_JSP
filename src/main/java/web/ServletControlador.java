package web;

import datos.UsuarioDaoJDBC;
import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author yimy
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String user = request.getParameter("usuario");
        String contra = request.getParameter("contraseña");
        HttpSession sesion = request.getSession();
        List<Usuario> usuarios = new UsuarioDaoJDBC().select();
        
        for (Usuario usuario:usuarios) {
            
            if (user.equals(usuario.getUsuario()) && contra.equals(usuario.getContraseña())) {
                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/WEB-INF/paginas/usuarios.jsp").forward(request, response);
            }else{
                response.sendRedirect("index.jsp");
            }
            
        }
        
    }
    
}
