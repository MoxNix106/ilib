package com.mycompany.interfaces;

import com.mycompany.models.Personal; // Asegúrate de importar la clase Personal del paquete correcto
import java.util.List;

public interface DAOPersonal {
    /**
     * Lista los registros de personal con un filtro opcional.
     * @param filtro El filtro para buscar registros (puede ser vacío para listar todos).
     * @return Una lista de objetos Personal.
     * @throws Exception Si ocurre un error durante la consulta.
     */
    List<Personal> listar(String filtro) throws Exception;

    /**
     * Obtiene un registro de personal por su ID.
     * @param id El ID del registro a obtener.
     * @return Un objeto Personal correspondiente al ID.
     * @throws Exception Si ocurre un error durante la consulta.
     */
    Personal obtenerPorId(int id) throws Exception;

    /**
     * Inserta un nuevo registro de personal.
     * @param personal El objeto Personal con los datos a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    void insertar(Personal personal) throws Exception;

    /**
     * Actualiza un registro existente de personal.
     * @param personal El objeto Personal con los datos actualizados.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    void actualizar(Personal personal) throws Exception;

    /**
     * Elimina un registro de personal por su ID.
     * @param id El ID del registro a eliminar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    void eliminar(int id) throws Exception;
}
