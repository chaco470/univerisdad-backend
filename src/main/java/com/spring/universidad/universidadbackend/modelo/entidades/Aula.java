package com.spring.universidad.universidadbackend.modelo.entidades;

import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_aula", nullable = false)
    private Integer numeroAula;
    @Column(name = "medidas_mtsxmts")
    private Double mts2;
    @Column(name = "cantidad_pupitres")
    private Integer pupitres;
    @Column(name = "tipo_pizzarron")
    @Enumerated(EnumType.STRING)
    private TipoPizzarron tipoPizzarron;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Aula() {
    }

    public Aula(Integer id, Integer numeroAula, Double mts2, Integer pupitres, TipoPizzarron tipoPizzarron) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.mts2 = mts2;
        this.pupitres = pupitres;
        this.tipoPizzarron = tipoPizzarron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula) {
        this.numeroAula = numeroAula;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public Integer getPupitres() {
        return pupitres;
    }

    public void setPupitres(Integer pupitres) {
        this.pupitres = pupitres;
    }

    public TipoPizzarron getTipoPizzarron() {
        return tipoPizzarron;
    }

    public void setTipoPizzarron(TipoPizzarron tipoPizzarron) {
        this.tipoPizzarron = tipoPizzarron;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @PrePersist
    private void antesDePersistir(){
        fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void AntesDeUpdate(){
        fechaModificacion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", numeroAula=" + numeroAula +
                ", mts2=" + mts2 +
                ", pupitres=" + pupitres +
                ", tipoPizzarron=" + tipoPizzarron +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && numeroAula.equals(aula.numeroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroAula);
    }
}
