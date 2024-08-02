package hn.unah.lenguajes.hotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.hotel.modelos.TipoHabitacion;
import hn.unah.lenguajes.hotel.repositorios.TipoHabitacionrepositorio;

@Service
public class TipoHabitacionServicio {

    @Autowired

    private TipoHabitacionrepositorio tipoHabitacionrepositorio;

    public List<TipoHabitacion> obtenerTiposHabitacion(){
        return this.tipoHabitacionrepositorio.findAll();
    }
    public TipoHabitacion crearHabitacion(String descripcion, double valorAdicional){
            TipoHabitacion tipoHabitacion = new TipoHabitacion();
            tipoHabitacion.setDescripcion(descripcion);
            tipoHabitacion.setValorAdicional(valorAdicional);
            return this.tipoHabitacionrepositorio.save(tipoHabitacion);
                
    }
    public TipoHabitacion buscarPorId(long id){
        return this.tipoHabitacionrepositorio.findById(id).get();
    }

    public String eliminarpPorId(long id){
        if(this.tipoHabitacionrepositorio.existsById(id)){
            this.tipoHabitacionrepositorio.deleteById(id);
            return " se ha eliminado el registro";
        }
        return "no existe el registro";
    }
    public TipoHabitacion actualizarPorId(long id, TipoHabitacion tipoHabitacion){
        if (this.tipoHabitacionrepositorio.existsById(id)){
            TipoHabitacion tipoHabitacionActualizar = this.tipoHabitacionrepositorio.findById(id).get();
            tipoHabitacionActualizar.setDescripcion(tipoHabitacion.getDescripcion());
            tipoHabitacionActualizar.setValorAdicional(tipoHabitacion.getValorAdicional());
            this.tipoHabitacionrepositorio.save(tipoHabitacionActualizar);
            return tipoHabitacionActualizar;
        }
        return null;
    }

    }
    
