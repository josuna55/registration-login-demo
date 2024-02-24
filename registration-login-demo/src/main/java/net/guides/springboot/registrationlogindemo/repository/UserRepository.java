package net.guides.springboot.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.registrationlogindemo.entity.User;

//El repositorio JpaRepository proporciona métodos CRUD estándar, como save (), findById (), delete (), etc. sobre las entidades. 
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);//El método findByEmail () se utiliza para buscar un usuario por correo electrónico en la base de datos. 
   
}
