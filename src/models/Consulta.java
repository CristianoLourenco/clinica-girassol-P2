package models;

import dao.ConsultaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {

    private int id;
    private String paciente_id;
    private String medico_id;
    private LocalDateTime dataConsulta;
    private Status status;
    private String especialidade_id;

    public Consulta(String paciente_id, String medico_id, LocalDateTime dataConsulta, Status status, String especialidade) {
        this.paciente_id = paciente_id;
        this.medico_id = medico_id;
        this.dataConsulta = dataConsulta;
        this.status = status;
        this.especialidade_id = especialidade;
    }

    public Consulta() {
        this.status = Status.EM_ESPERA;
        this.paciente_id = "";
        this.medico_id = "";
        this.especialidade_id = "";
    }

    public enum Status {
        EM_ESPERA,
        ATENDIDO,
        CANCELADA,
        REMARCADA
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPaciente_id(String paciente_id) {
        this.paciente_id = paciente_id;
    }

    public void setMedico_id(String medico_id) {
        this.medico_id = medico_id;
    }

    public void setEspecialidade_id(String especialidade_id) {
        this.especialidade_id = especialidade_id;
    }

    public int getId() {
        return id;
    }

    public String getPaciente_id() {
        return paciente_id;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public Status getStatus() {
        return status;
    }

    public String getEspecialidade_id() {
        return this.especialidade_id;
    }

    public String getMedico_id() {
        return medico_id;
    }

    public boolean isValid() {
        if (dataConsulta == null || medico_id.isEmpty() || paciente_id.isEmpty() || especialidade_id.isEmpty()) {
            return false;
        }
        return true;
    }

    public String[] toList() {
        String[] list = new String[7];
        list[0] = String.valueOf(id);
        list[1] = medico_id;
        list[2] = paciente_id;
        list[3] = dataConsulta.toLocalDate().toString();        
        list[4] = dataConsulta.toLocalTime().toString();
        list[5] = status.toString();
        list[6] = especialidade_id;
        return list;
    }

    //private Medico medico;
    public boolean agendarConsulta() {
        ConsultaDAO dao = new ConsultaDAO(this);
        return dao.insertDaoObject();

    }

    public void cancelarConsulta() {
    }

    public void remarcarConsulta() {
    }

}
