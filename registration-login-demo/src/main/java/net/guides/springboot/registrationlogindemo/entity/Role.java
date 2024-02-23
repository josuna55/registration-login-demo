package net.guides.springboot.registrationlogindemo.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    
    //Indica que esta entidad es el lado no propietario de la relación, y que la propiedad de la relación está en el otro lado, en el campo roles. 
    //Esto significa que el otro lado de la relación es el que maneja la actualización de la tabla de unión.
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
