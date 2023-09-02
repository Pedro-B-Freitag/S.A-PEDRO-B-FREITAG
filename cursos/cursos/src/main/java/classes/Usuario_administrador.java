package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuario_administrador")
@Entity(name = "usuario_administrador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "usuario_administrador_id")

public class Usuario_administrador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_administrador_id;

    public Usuario_administrador(DTOS.Usuario_administradorDTO data){
        usuario_administrador_id = data.usuario_administrador_id();
    }
}
    