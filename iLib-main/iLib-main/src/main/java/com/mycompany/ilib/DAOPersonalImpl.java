package com.mycompany.ilib;

import com.mycompany.models.Personal;
import com.mycompany.interfaces.DAOPersonal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonalImpl implements DAOPersonal {
    private final Connection conn;

    public DAOPersonalImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Personal> listar(String filtro) throws Exception {
        List<Personal> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, correo, usuario, fecha_creacion FROM personal WHERE LOWER(nombre) LIKE LOWER(?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + filtro + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Personal personal = new Personal();
                    personal.setId(rs.getInt("id"));
                    personal.setNombre(rs.getString("nombre"));
                    personal.setApellido(rs.getString("apellido"));
                    personal.setCorreo(rs.getString("correo"));
                    personal.setUsuario(rs.getString("usuario"));
                    personal.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                    lista.add(personal);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar personal: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public Personal obtenerPorId(int id) throws Exception {
        String sql = "SELECT id, nombre, apellido, correo, usuario, fecha_creacion FROM personal WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Personal personal = new Personal();
                    personal.setId(rs.getInt("id"));
                    personal.setNombre(rs.getString("nombre"));
                    personal.setApellido(rs.getString("apellido"));
                    personal.setCorreo(rs.getString("correo"));
                    personal.setUsuario(rs.getString("usuario"));
                    personal.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                    return personal;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener personal por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void insertar(Personal personal) throws Exception {
        String sql = "INSERT INTO personal (nombre, apellido, correo, usuario, contrasena, id_administrador, fecha_creacion) " +
                     "VALUES (?, ?, ?, ?, crypt(?, gen_salt('bf')), ?, CURRENT_TIMESTAMP)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, personal.getNombre());
            ps.setString(2, personal.getApellido());
            ps.setString(3, personal.getCorreo());
            ps.setString(4, personal.getUsuario());
            ps.setString(5, personal.getContrasena());
            ps.setInt(6, personal.getIdAdministrador());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al insertar personal: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(Personal personal) throws Exception {
        String sql = "UPDATE personal SET nombre = ?, apellido = ?, correo = ?, usuario = ?, contrasena = crypt(?, gen_salt('bf')), " +
                     "id_administrador = ?, fecha_actualizacion = CURRENT_TIMESTAMP WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, personal.getNombre());
            ps.setString(2, personal.getApellido());
            ps.setString(3, personal.getCorreo());
            ps.setString(4, personal.getUsuario());
            ps.setString(5, personal.getContrasena());
            ps.setInt(6, personal.getIdAdministrador());
            ps.setInt(7, personal.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar personal: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM personal WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar personal: " + e.getMessage(), e);
        }
    }
}

