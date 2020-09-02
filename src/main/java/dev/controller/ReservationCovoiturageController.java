package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.ReservationCovoiturageDto;
import dev.service.ReservationCovoiturageService;

@RestController
@RequestMapping("/reservations-covoiturage")
@Secured("ROLE_COLLABORATEUR")
public class ReservationCovoiturageController {

	protected ReservationCovoiturageService service;

	public ReservationCovoiturageController(ReservationCovoiturageService service) {
		super();
		this.service = service;
	}

	// GET /reservations-covoiturage/matricule
	@GetMapping("/{matricule}")
	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatriculeTest(@PathVariable String matricule) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatricule(matricule));
	}

	// POST /reservations-covoiturage
//	@PostMapping
//	public ResponseEntity<?> create(@RequestBody @Valid ReservationCovoiturageDto reservationCovoiturageDto,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			throw new ReservationCovoiturageInvalideException(
//					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
//		}
//
//		return ResponseEntity.status(HttpStatus.OK).body(service.create(reservationCovoiturageDto));
//	}

}
