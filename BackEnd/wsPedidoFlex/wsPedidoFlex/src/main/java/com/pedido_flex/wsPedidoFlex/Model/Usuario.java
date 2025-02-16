package com.pedido_flex.wsPedidoFlex.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long usuario_id;

    @Column(name ="usuario_email")
    private String usuario_email;

    @Column(name ="usuario_contraseña")
    private String usuario_contrasena;

    @Column(name ="usuario_estado_id")
    private Integer usuario_estado_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_rol_id", referencedColumnName = "rol_id", nullable = false)
    private Roles rol;

    @Column(name ="usuario_observaciones")
    private String usuario_observaciones;

    @Column(name ="usuario_fecha_alta",insertable = false, updatable = false)
    private LocalDateTime usuario_fecha_alta;

    @Column(name ="usuario_fecha_modificacion")
    private LocalDateTime usuario_fecha_modificacion;

    @Column(name ="usuario_fecha_baja")
    private LocalDateTime usuario_fecha_baja;

    @Column(name ="usuario_usuario_alta")
    private String usuario_usuario_alta;

    @Column(name ="usuario_usuario_modificacion")
    private String usuario_usuario_modificacion;

    @Column(name ="usuario_usuario_baja")
    private String usuario_usuario_baja;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToOne(mappedBy = "cliente_Usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    private Cliente cliente; // Un usuario puede tener un cliente

    public Usuario(String usuario_email, String usuario_contrasena){
        this.usuario_email = usuario_email;
        this.usuario_contrasena = usuario_contrasena;
    }

    public Usuario get(){
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(this.usuario_id);
        usuario.setUsuario_email(this.usuario_email);
        usuario.setUsuario_contrasena(this.usuario_contrasena);
        usuario.setUsuario_estado_id(this.usuario_estado_id);
        usuario.setRol(this.rol);
        usuario.setUsuario_observaciones(this.usuario_observaciones);
        usuario.setUsuario_fecha_alta(this.usuario_fecha_alta);
        usuario.setUsuario_fecha_modificacion(this.usuario_fecha_modificacion);
        usuario.setUsuario_fecha_baja(this.usuario_fecha_baja);
        usuario.setUsuario_usuario_alta(this.usuario_usuario_alta);
        usuario.setUsuario_usuario_modificacion(this.usuario_usuario_modificacion);
        usuario.setUsuario_usuario_baja(this.usuario_usuario_baja);
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getUsuario_contrasena() {
        return usuario_contrasena;
    }

    public void setUsuario_contrasena(String usuario_contrasena) {
        this.usuario_contrasena = usuario_contrasena;
    }

    public Integer getUsuario_estado_id() {
        return usuario_estado_id;
    }

    public void setUsuario_estado_id(Integer usuario_estado_id) {
        this.usuario_estado_id = usuario_estado_id;
    }

    public String getUsuario_observaciones() {
        return usuario_observaciones;
    }

    public void setUsuario_observaciones(String usuario_observaciones) {
        this.usuario_observaciones = usuario_observaciones;
    }

    public LocalDateTime getUsuario_fecha_alta() {
        return usuario_fecha_alta;
    }

    public void setUsuario_fecha_alta(LocalDateTime usuario_fecha_alta) {
        this.usuario_fecha_alta = usuario_fecha_alta;
    }

    public LocalDateTime getUsuario_fecha_modificacion() {
        return usuario_fecha_modificacion;
    }

    public void setUsuario_fecha_modificacion(LocalDateTime usuario_fecha_modificacion) {
        this.usuario_fecha_modificacion = usuario_fecha_modificacion;
    }

    public LocalDateTime getUsuario_fecha_baja() {
        return usuario_fecha_baja;
    }

    public void setUsuario_fecha_baja(LocalDateTime usuario_fecha_baja) {
        this.usuario_fecha_baja = usuario_fecha_baja;
    }

    public String getUsuario_usuario_alta() {
        return usuario_usuario_alta;
    }

    public void setUsuario_usuario_alta(String usuario_usuario_alta) {
        this.usuario_usuario_alta = usuario_usuario_alta;
    }

    public String getUsuario_usuario_modificacion() {
        return usuario_usuario_modificacion;
    }

    public void setUsuario_usuario_modificacion(String usuario_usuario_modificacion) {
        this.usuario_usuario_modificacion = usuario_usuario_modificacion;
    }

    public String getUsuario_usuario_baja() {
        return usuario_usuario_baja;
    }

    public void setUsuario_usuario_baja(String usuario_usuario_baja) {
        this.usuario_usuario_baja = usuario_usuario_baja;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            return "Error al serializar el objeto Usuario: " + e.getMessage();
        }
    }
}
