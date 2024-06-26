 
package models;
 
import java.time.LocalDate; 

public class Consulta {
    private String id;
    private String paciente_id;
    private String medico_id;
    private LocalDate dataConsulta;
    private boolean status;
    private String especialidade;
    
     
    public Consulta(String paciente_id,String medico_id ,LocalDate dataConsulta, boolean status, String especialidade) {
        this.paciente_id = paciente_id;
        this.medico_id = medico_id;
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
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }
    public String getPaciente_id() {
        return paciente_id;
    }
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
    public boolean getStatus() {
        return status;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    
     public String getMedico_id() {
        return medico_id;
    }
    
    //private Medico medico;
    public void agendarConsulta(){}
    public void cancelarConsulta(){}
    public void remarcarConsulta(){}

    
   

    
}
