/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import Modelo.exceptions.PreexistingEntityException;


public class PacienteControl implements ActionListener 
    {
    vista.RegpacienteInternalFrame pacienteVista;
    Modelo.Pacientes pacienteModelo;
    Modelo.PacientesJpaController gestorPacienteModelo;
    

    public PacienteControl(vista.RegpacienteInternalFrame pacienteVista) {
        this.pacienteVista = pacienteVista;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCitasPU");
        gestorPacienteModelo = new Modelo.PacientesJpaController(emf);
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pacienteVista.RegistrarBtn)) {
            String identificacion =(pacienteVista.txt_identificacion.getText());
            String nombres = pacienteVista.txt_nombres.getText();
            String apellidos = pacienteVista.txt_apellidos.getText();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String FechaNacimiento = formato.format(pacienteVista.Dtd_fecha_nacimiento.getDate());
            String genero= ""; // Asigna un valor por defecto
                if (pacienteVista.rdb_masculino.isSelected()) {
                    genero= "M";
                } else if (pacienteVista.rdb_femenino.isSelected()) {
                    genero = "F";
                }           
        pacienteModelo = new Modelo.Pacientes();
        pacienteModelo.setPacIdentificacion(identificacion);
        pacienteModelo.setPacApellidos(apellidos);
        pacienteModelo.setPacNombre(nombres);
        pacienteModelo.setPacFechaNacimiento(new Date (FechaNacimiento));
        pacienteModelo.setPacGenero(genero);
        try
        {
            gestorPacienteModelo.create(pacienteModelo);
            JOptionPane.showMessageDialog(pacienteVista, "Paciente registrado correctamente");            
        }
        catch(PreexistingEntityException ex)
        {
            JOptionPane.showMessageDialog(pacienteVista, "El paciente ya existe");            
        }
        catch(Exception ex)
        {JOptionPane.showMessageDialog(pacienteVista,ex.getMessage());
        
        }
        }
               
        if (e.getSource().equals(pacienteVista.NuevoBtn)) {
            pacienteVista.txt_identificacion.setText("");
            pacienteVista.txt_nombres.setText("");
            pacienteVista.txt_apellidos.setText("");
            pacienteVista.Dtd_fecha_nacimiento.setDate(null);
            pacienteVista.rdb_masculino.setSelected(true);
            pacienteVista.rdb_femenino.setSelected(false);
            pacienteVista.txt_identificacion.requestFocus();
        }
}
    }