/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import java.util.*;


public class GestorPacienteControl implements ActionListener {

    Modelo.PacientesJpaController pacientesModelo;
    vista.ConsPacienteInternalFrame consultarPacienteVista;

    public GestorPacienteControl(vista.ConsPacienteInternalFrame consultarPacienteVista) {
        this.consultarPacienteVista = consultarPacienteVista;
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoCitasPU");             
        pacientesModelo = new Modelo.PacientesJpaController(emf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tmodelo;
        String valor=consultarPacienteVista.txt_valor.getText();
        int parametro=0;

        if (consultarPacienteVista.rdb_identificacion.isSelected()) {
            parametro = 1;
        }
        if (consultarPacienteVista.rdb_nombres.isSelected()) {
            parametro = 2;
        }
        if (consultarPacienteVista.rdb_apellidos.isSelected()) {
            parametro = 3;
        }
        if (consultarPacienteVista.rdb_genero.isSelected()) {
            parametro = 4;
        }

        List<Modelo.Pacientes> pacientes = pacientesModelo.findPacientesEntities();
        String registro[] = new String[5];

        String[] Titulos = {"Identificacion", "Nombre", "Apellidos", "fechaNacimiento", "Genero"};
        
        tmodelo = new DefaultTableModel();
        tmodelo.setColumnIdentifiers(Titulos);
       

        for (Modelo.Pacientes p:pacientes) {
            registro[0] = p.getPacIdentificacion();
            registro[1] = p.getPacNombre();
            registro[2] = p.getPacApellidos();
            registro[3] = p.getPacFechaNacimiento().toString();
            registro[4] = p.getPacGenero();
            tmodelo.addRow(registro);
        }

        consultarPacienteVista.Tbl_datos.setModel(tmodelo);
    }
}