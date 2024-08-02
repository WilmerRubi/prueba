package hn.unah.lenguajes.hotel.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.hotel.modelos.TipoHabitacion;

public interface TipoHabitacionrepositorio extends JpaRepository<TipoHabitacion, Long>{

    public List <TipoHabitacion> getBydescripcion(String descripcion);

    @Query("select f from tipohabitacion f where valorAdicional > :precio")
    public List<TipoHabitacion> obtenerPorPrecioMayor(@Param("precio") int precio);

}

