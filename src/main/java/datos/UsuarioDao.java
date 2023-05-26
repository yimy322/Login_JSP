/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author yimy
 */
public interface UsuarioDao {
    
    int insert(Usuario usuario);
    int update(Usuario usuario);
    int delete(Usuario usuario);
    List<Usuario> select();
    Usuario selectById(Usuario usuario);
    
}
