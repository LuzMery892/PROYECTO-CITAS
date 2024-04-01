/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Luz
 */
@Entity
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PacIdentificacion")
    private String pacIdentificacion;
    @Column(name = "PacNombre")
    private String pacNombre;
    @Column(name = "PacApellidos")
    private String pacApellidos;
    @Column(name = "PacFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacFechaNacimiento;
    @Column(name = "PacGenero")
    private String pacGenero;

    public Pacientes() {
    }

    public Pacientes(String pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public String getPacIdentificacion() {
        return pacIdentificacion;
    }

    public void setPacIdentificacion(String pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public String getPacNombre() {
        return pacNombre;
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre = pacNombre;
    }

    public String getPacApellidos() {
        return pacApellidos;
    }

    public void setPacApellidos(String pacApellidos) {
        this.pacApellidos = pacApellidos;
    }

    public Date getPacFechaNacimiento() {
        return pacFechaNacimiento;
    }

    public void setPacFechaNacimiento(Date pacFechaNacimiento) {
        this.pacFechaNacimiento = pacFechaNacimiento;
    }

    public String getPacGenero() {
        return pacGenero;
    }

    public void setPacGenero(String pacGenero) {
        this.pacGenero = pacGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacIdentificacion != null ? pacIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacIdentificacion == null && other.pacIdentificacion != null) || (this.pacIdentificacion != null && !this.pacIdentificacion.equals(other.pacIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Pacientes[ pacIdentificacion=" + pacIdentificacion + " ]";
    }
    
}
