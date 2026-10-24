package dev.lana.teste;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository: é uma interface do Spring Data JPA que fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) em entidades JPA. Ela é parametrizada com a entidade (Usuario) e o tipo do ID (Long).
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
