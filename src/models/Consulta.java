 
package models;
 
import java.time.LocalDate; 

public class Consulta {
    private int id;
    private String paciente_id;
    private String medico_id;
    private LocalDate dataConsulta;
    private Status status;
    private String especialidade_id;
    
     
    public Consulta(String paciente_id,String medico_id ,LocalDate dataConsulta, Status status, String especialidade) {
        this.paciente_id = paciente_id;
        this.medico_id = medico_id;
        this.dataConsulta = dataConsulta;
        this.status = status;
        this.especialidade_id = especialidade;
    }
    
    public enum Status{
        EM_ESPERA,
        ATENDIDO,
        CANCELADA,
        REMARCADA
    }
    

    public void setId(int id) {
        this.id = id;
    } 
    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade_id = especialidade;
    }

    public int getId() {
        return id;
    }
    public String getPaciente_id() {
        return paciente_id;
    }
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
    public Status getStatus() {
        return status;
    }
    public String getEspecialidade() {
        return especialidade_id;
    }
    
     public String getMedico_id() {
        return medico_id;
    }
     public  String[] toList(){
        String[] list = new String[6];
        list[0] = String.valueOf(id) ;
        list[1] = dataConsulta.toString();
        list[2] = medico_id;
        list[3] = paciente_id;
        list[4] = status.toString();
        list[5] = especialidade_id; 
        return list;
     }
    
    //private Medico medico;
    public void agendarConsulta(){}
    public void cancelarConsulta(){}
    public void remarcarConsulta(){}

    
   

    
}
