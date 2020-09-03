package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {

	Optional<Utilisateur> findByEmail(String email);
    
    List<Utilisateur> findByMatricule(String matricule);
}
