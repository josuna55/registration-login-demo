package net.guides.springboot.registrationlogindemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    //Esta anotación es para que el id se genere automáticamente y se delega
    //en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    /*Esta anotación es para que se cree una tabla intermedia entre User y Role y se almacenen los roles de cada usuario. EAGER es para que se carguen todos los roles de un usuario al cargar el usuario y LAZY es para que se carguen los roles de un usuario solo cuando se acceda a ellos*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_roles",    //Nombre de la tabla intermedia
        joinColumns = @JoinColumn(
            name = "USER_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(
            name = "ROLE_ID", referencedColumnName = "ID"))
    private List<Role> roles = new ArrayList<>();

    public void setRole(List<Role> asList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRole'");
    }
}
