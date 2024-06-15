 
package models;
 
import java.time.LocalDate; 

public class Consulta {
    private String id;
    private final Paciente paciente;
    private LocalDate dataConsulta;
    private boolean status;
    private Especialidade especialidade;
    
     
    public Consulta(Paciente paciente, LocalDate dataConsulta, boolean status, Especialidade especialidade) {
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.status = status;
        this.especialidade = especialidade;
    }

    public void setId(String id) {
        this.id = id;
    } 
    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
    public boolean isStatus() {
        return status;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    
    //private Medico medico;
    public void agendarConsulta(){}
    public void cancelarConsulta(){}
    public void remarcarConsulta(){}
    
}
