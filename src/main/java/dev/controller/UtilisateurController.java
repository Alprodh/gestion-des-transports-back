package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.ChauffeurDto;
import dev.controller.dto.UtilisateurDto;
import dev.service.UtilisateurService;

@RestController
@RequestMapping("/administrateur")
@Secured("ROLE_ADMINISTRATEUR")
public class UtilisateurController {
	
	protected UtilisateurService service;

	/**
	 * @param service
	 */
	public UtilisateurController(UtilisateurService service) {
		this.service = service;
	}

	// GET /administrateur/chauffeurs
		/**
		 * Lister toutes les utilsateurs avec un role de Chauffeur
		 * 
		 * @return
		 */
		@GetMapping("/chauffeurs")
		@Secured("ROLE_ADMINISTRATEUR")
		public ResponseEntity<List<ChauffeurDto>> listerChauffeurs() {
			return ResponseEntity.status(HttpStatus.OK).body( service.listerChauffeurs());
		}
		
		// GET /administrateur/chauffeurs/{matricule}
		/**
		 * Ajouter un utilisateur avec un role de Chauffeur
		 * 
		 * @return
		 */
		@PatchMapping(value = "chauffeurs/{matricule}")
		@Secured("ROLE_ADMINISTRATEUR")
		public ResponseEntity<?> ajoutChauffeur(@PathVariable("matricule") String matricule) {
			UtilisateurDto chauffeurDto = service.modifierRole(matricule);
			return ResponseEntity.status(HttpStatus.OK).body(chauffeurDto);
		}

}
