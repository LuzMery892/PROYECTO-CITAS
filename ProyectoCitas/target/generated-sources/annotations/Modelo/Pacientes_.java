package Modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-01T14:51:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pacientes.class)
public class Pacientes_ { 

    public static volatile SingularAttribute<Pacientes, String> pacGenero;
    public static volatile SingularAttribute<Pacientes, Date> pacFechaNacimiento;
    public static volatile SingularAttribute<Pacientes, String> pacIdentificacion;
    public static volatile SingularAttribute<Pacientes, String> pacApellidos;
    public static volatile SingularAttribute<Pacientes, String> pacNombre;

}