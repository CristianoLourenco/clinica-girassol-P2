package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Factura {
        private String facturaId;
        private String facturaPaciente;
        private String facturaConsulta;
        private LocalTime horaFactura;
        private LocalDate dataFactura;
        private BigDecimal valor;
        
        public boolean emitirFactura (Paciente paciente, BigDecimal valor, LocalDate dataEmissao){
            return true;
        }
        
        public  BigDecimal calcularTotalFacturas (LocalDate dataInicio, LocalDate dataFim){
            return null;
        }

        
        
    /**
     * @return the facturaId
     */
    public String getFacturaId() {
        return facturaId;
    }

    /**
     * @param facturaId the facturaId to set
     */
    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    /**
     * @return the facturaPaciente
     */
    public String getFacturaPaciente() {
        return facturaPaciente;
    }

    /**
     * @param facturaPaciente the facturaPaciente to set
     */
    public void setFacturaPaciente(String facturaPaciente) {
        this.facturaPaciente = facturaPaciente;
    }

    /**
     * @return the facturaConsulta
     */
    public String getFacturaConsulta() {
        return facturaConsulta;
    }

    /**
     * @param facturaConsulta the facturaConsulta to set
     */
    public void setFacturaConsulta(String facturaConsulta) {
        this.facturaConsulta = facturaConsulta;
    }

    /**
     * @return the horaFactura
     */
    public LocalTime getHoraFactura() {
        return horaFactura;
    }

    /**
     * @param horaFactura the horaFactura to set
     */
    public void setHoraFactura(LocalTime horaFactura) {
        this.horaFactura = horaFactura;
    }

    /**
     * @return the dataFactura
     */
    public LocalDate getDataFactura() {
        return dataFactura;
    }

    /**
     * @param dataFactura the dataFactura to set
     */
    public void setDataFactura(LocalDate dataFactura) {
        this.dataFactura = dataFactura;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
        
        
        
}
