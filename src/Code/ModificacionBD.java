/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import ComandosSQL.sql.Producto;
import ComandosSQL.sql.Usuario;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author HOME
 */
public class ModificacionBD {

    EntityManagerFactory emf; // Comprobar nombre de la PU
    EntityManager em;

    public ModificacionBD() {
        emf = Persistence.createEntityManagerFactory("SmartBusinessPU"); // Comprobar nombre de la PU
        em = emf.createEntityManager();
    }

    public String createUser(String nombre, String email, String apellido, String cedula, String telefono, String contraseña) {

        String parameter = "exito";
        List<Usuario> listUsuarios;
        Query queryEmailUsuario = em.createNamedQuery("Usuario.findByEmail");
        queryEmailUsuario.setParameter("email", email);
        listUsuarios = queryEmailUsuario.getResultList();
        for (Usuario usuario : listUsuarios) {
            if (usuario.getEmail().equals(email)) {
                parameter = "Correo electrónico en uso";
            }
        }
        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = patronEmail.matcher(email);
        if (mather.find() == false){
           parameter = "Correo electrónico inválido";
        }
        else if (contraseña.length() < 5){
            parameter = "La contraseña debe ser mayor a 5 carácteres";
        }
        else if (nombre.length() < 2 || apellido.length() < 2 || apellido.equals("") || apellido.equals(" ") || nombre.equals("") || nombre.equals(" ")){
            parameter = "Coloque su nombre y apellido reales";
        }
        else if (telefono.equals("") || telefono.equals(" ")){
            parameter = "El campo de teléfono es obligatorio";
        }
        else if (cedula.equals("") || cedula.equals(" ")){
            parameter = "El campo de cédula es obligatorio";
        }
        else if (parameter.equals("exito")) {

            Usuario usuarioNuevo = new Usuario(email, nombre, apellido, contraseña, cedula, telefono);
            em.getTransaction().begin();
            em.persist(usuarioNuevo);
            em.getTransaction().commit();
        }
        return parameter;
    }

    public String loginUser(String email, String password) {
        String parameter = "exito";
        Usuario verUsuario = em.find(Usuario.class, 1);
        if (!verUsuario.getEmail().equals(email)) {
            parameter = "Correo electrónico inválido";
        } else if (!verUsuario.getContraseña().equals(password)) {
            parameter = "Contraseña inválida";
        }
        return parameter;
    }

    public void mostrarUsuarios() {
        Query queryUsuarios = em.createNamedQuery("Usuario.findAll");
        List<Usuario> listUsuario = queryUsuarios.getResultList();
        for (int i = 0; i < listUsuario.size(); i++) {
            Usuario verUsuario = listUsuario.get(i);
            if (verUsuario != null) {
                System.out.println(verUsuario.getId() + ")Nombre " + verUsuario.getNombres() + "Email " + verUsuario.getEmail());
            }
        }
    }

    public boolean productNameExists(String name) {
        boolean result = false;
        Query queryProductos = em.createNamedQuery("Producto.findAll");
        List<Producto> listProductos = queryProductos.getResultList();
        for (int i = 0; i < listProductos.size(); i++) {
            Producto producto = listProductos.get(i);
            if (producto != null) {
                if(producto.getNombre().equals(name)){
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
    
    public String replaceProduct(String type, String nombre, String descripcion, String codigo, int cantidad, double precio, double costo, String rutaImagen) {
        String result = "notfound";
        Query queryProductos = em.createNamedQuery("Producto.findAll");
        List<Producto> listProductos = queryProductos.getResultList();
        if(type.equals("codigo")) {
            for (int i = 0; i < listProductos.size(); i++) {
                Producto producto = listProductos.get(i);
                if (producto != null) {
                    if(producto.getCodigo().equals(codigo)){
                        
                        int id = producto.getId();
                        borrarProducto(id);
                        Producto productoNuevo = new Producto(nombre, descripcion, codigo, cantidad, precio, costo, rutaImagen);
                        productoNuevo.setId(id);
                        em.getTransaction().begin();
                        em.persist(productoNuevo);
                        em.getTransaction().commit();
                        result = "modified";
                        return result;
                    }
                }
            }
        } else {
            
            for (int i = 0; i < listProductos.size(); i++) {
                Producto producto = listProductos.get(i);
                if (producto != null) {
                    if(producto.getNombre().equals(nombre)){
                        
                        int id = producto.getId();
                        borrarProducto(id);
                        Producto productoNuevo = new Producto(nombre, descripcion, codigo, cantidad, precio, costo, rutaImagen);
                        productoNuevo.setId(id);
                        em.getTransaction().begin();
                        em.persist(productoNuevo);
                        em.getTransaction().commit();
                        result = "modified";
                        return result;
                    }
                }
            }
        }
        return result;
    }
    
    public boolean productCodeExists(String code){
        boolean result = false;
        Query queryProductos = em.createNamedQuery("Producto.findAll");
        List<Producto> listProductos = queryProductos.getResultList();
        for (int i = 0; i < listProductos.size(); i++) {
            Producto producto = listProductos.get(i);
            if (producto != null){
                if(producto.getCodigo().equals(code)){
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
    
    public EntityManager getEntityManager() {
        return em;
    }

    public List<Usuario> getListaUsuarios() {
        Query queryUsuarios = em.createNamedQuery("Usuario.findAll");
        List<Usuario> listUsuario = queryUsuarios.getResultList();
        return listUsuario;
    }
    
    public int sizeProducts(){
        Query queryProductos = em.createNamedQuery("Producto.findAll");
        List<Producto> listProductos = queryProductos.getResultList();
        return listProductos.size();
    }
    
    public List<Producto> getListaProductos() {
        Query queryProductos = em.createNamedQuery("Producto.findAll");
        List<Producto> listProductos = queryProductos.getResultList();
        return listProductos;
    }

    public Usuario getUsuario(int id) {
        Usuario verUsuario = em.find(Usuario.class, id);
        return verUsuario;
    }

    public boolean UsersEmpty() {
        Query queryUsuarios = em.createNamedQuery("Usuario.findAll");
        List<Usuario> listUsuario = queryUsuarios.getResultList();
        return listUsuario.isEmpty();
    }
    
    public String addToInventory(String nombre, String descripcion, String codigo, int cantidad, double precio, double costo, String rutaImagen) {
        
        Query queryProductos = em.createNamedQuery("Producto.findAll");
        List<Producto> listProductos = queryProductos.getResultList();
        for (int i = 0; i < listProductos.size(); i++) {
            Producto producto = listProductos.get(i);
            System.out.println("nombre "+producto.getNombre()+" codigo "+producto.getCodigo());
            if(producto.getCodigo().equals(codigo)){
                return "codigo";
            } else if(producto.getNombre().equals(nombre)){
                return "nombre";
            }
        }
        Producto productoNuevo = new Producto(nombre, descripcion, codigo, cantidad, precio, costo, rutaImagen);
        em.getTransaction().begin();
        em.persist(productoNuevo);
        em.getTransaction().commit();
        return "accepted";
    }
    
    public void putRemember(boolean remember){
        Usuario verUsuario = em.find(Usuario.class, 1);
        verUsuario.setRemember(remember);
        em.getTransaction().begin();
        em.persist(verUsuario);
        em.getTransaction().commit();
    }

    public boolean UserHaveRemember() {
        if(UsersEmpty()){
            return false;
        }
        Usuario user = em.find(Usuario.class, 1);
        return user.getRemember();
    }

    public void borrarTodosLosUsuarios() {

        Query queryUsuarios = em.createNamedQuery("Usuario.findAll");
        List<Usuario> listUsuario = queryUsuarios.getResultList();
        for (int i = 0; i < listUsuario.size(); i++) {
            Usuario removerUsuario = listUsuario.get(i);
            if (removerUsuario != null) {
                em.getTransaction().begin();
                em.remove(removerUsuario);
                em.getTransaction().commit();
            }
        }
        System.out.println("Usuarios eliminados");
    }

    public void borrarUsuario(int id) {

        Usuario removerUsuario = em.find(Usuario.class, id);
        if (removerUsuario != null) {
            em.getTransaction().begin();
            em.remove(removerUsuario);
            em.getTransaction().commit();
        }
    }
    
    public void borrarProducto(int id) {

        Producto removerProducto = em.find(Producto.class, id);
        if (removerProducto != null) {
            em.getTransaction().begin();
            em.remove(removerProducto);
            em.getTransaction().commit();
        }
    }

    public void closeConnection() {

        try {
            DriverManager.getConnection("jdbc:derby:SmartBusiness;create=true");
            //DriverManager.getConnection("jdbc:derby://127.0.0.1:1527/SmartBusiness;shutdown=true");
            emf.close();
            em.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}