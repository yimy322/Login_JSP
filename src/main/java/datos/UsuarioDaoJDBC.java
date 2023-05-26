/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yimy
 */
public class UsuarioDaoJDBC implements UsuarioDao{
    
    private static final String SQL_SELECT = "SELECT * FROM usuarios";
    private static final String SQL_SELECT_BY_DATOS = "SELECT * FROM usuarios WHERE usuario=? and contraseña=?";
    private static final String SQL_INSERT = "INSERT INTO usuarios(usuario, contraseña) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?,contraseña = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario =?";

    @Override
    public int insert(Usuario usuario) {
        
        Connection conn = null;

        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContraseña());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return rows;
    }

    @Override
    public int update(Usuario usuario) {
        Connection conn = null;

        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContraseña());
            stmt.setInt(3, usuario.getIdUsuario());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return rows;
    }

    @Override
    public int delete(Usuario usuario) {
        Connection conn = null;

        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return rows;
    }

    @Override
    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario1 = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int idUsuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");

                usuario1 = new Usuario(idUsuario, usuario, contraseña);

                usuarios.add(usuario1);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return usuarios;
    }

    @Override
    public Usuario selectById(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_DATOS);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getContraseña());
            rs = stmt.executeQuery();
            rs.next();//Nos posicionamos en el primer registro devuelto
            String usuario1 = rs.getString("usuario");
            String contraseña = rs.getString("contraseña");
            
            usuario.setUsuario(usuario1);
            usuario.setContraseña(contraseña);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return usuario;
    }
    
}
