package cencor.meif.fix.client.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mhernandez on 5/29/15.
 */
@Entity
@Table(name = "ACK2", schema = "", catalog = "FixClientDB")
public class Ack2Entity implements Serializable {
    private Long id;
    private String clOrdId;
    private Long valido;
    private String mensajeError;
    private String fixMsg;
    private Timestamp fechaInsercion;

    @Id
    @Column(name = "Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ClOrdID")
    public String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(String clOrdId) {
        this.clOrdId = clOrdId;
    }

    @Basic
    @Column(name = "Valido")
    public Long getValido() {
        return valido;
    }

    public void setValido(Long valido) {
        this.valido = valido;
    }

    @Basic
    @Column(name = "MensajeError")
    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Basic
    @Column(name = "FixMsg")
    public String getFixMsg() {
        return fixMsg;
    }

    public void setFixMsg(String fixMsg) {
        this.fixMsg = fixMsg;
    }

    @Basic
    @Column(name = "FechaInsercion")
    public Timestamp getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Timestamp fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ack2Entity that = (Ack2Entity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (clOrdId != null ? !clOrdId.equals(that.clOrdId) : that.clOrdId != null) return false;
        if (valido != null ? !valido.equals(that.valido) : that.valido != null) return false;
        if (mensajeError != null ? !mensajeError.equals(that.mensajeError) : that.mensajeError != null) return false;
        if (fixMsg != null ? !fixMsg.equals(that.fixMsg) : that.fixMsg != null) return false;
        if (fechaInsercion != null ? !fechaInsercion.equals(that.fechaInsercion) : that.fechaInsercion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clOrdId != null ? clOrdId.hashCode() : 0);
        result = 31 * result + (valido != null ? valido.hashCode() : 0);
        result = 31 * result + (mensajeError != null ? mensajeError.hashCode() : 0);
        result = 31 * result + (fixMsg != null ? fixMsg.hashCode() : 0);
        result = 31 * result + (fechaInsercion != null ? fechaInsercion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ack2Entity{" +
                "id=" + id +
                ", clOrdId='" + clOrdId + '\'' +
                ", valido=" + valido +
                ", mensajeError='" + mensajeError + '\'' +
                ", fixMsg='" + fixMsg + '\'' +
                ", fechaInsercion=" + fechaInsercion +
                '}';
    }
}
