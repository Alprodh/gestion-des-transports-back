package dev.domain;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ReservationCovoituragePassager {
	
	@EmbeddedId
	ReservationCovoituragePassagerKey id = new ReservationCovoituragePassagerKey();
 
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("utilisateurId")
    protected Utilisateur passager;
 
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("reservationCovoiturageId")
    protected ReservationCovoiturage reservationCovoiturage;
    
    @OneToOne(cascade = CascadeType.ALL)
	protected StatutReservationCovoiturage statutReservationCovoiturage;

    public ReservationCovoituragePassager() {}
    
	public ReservationCovoituragePassager(Utilisateur passager, ReservationCovoiturage reservationCovoiturage,
			StatutReservationCovoiturage statutReservationCovoiturage) {
		this.passager = passager;
		this.reservationCovoiturage = reservationCovoiturage;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}

	public ReservationCovoituragePassagerKey getId() {
		return id;
	}

	public void setId(ReservationCovoituragePassagerKey id) {
		this.id = id;
	}

	public Utilisateur getPassager() {
		return passager;
	}

	public void setPassager(Utilisateur passager) {
		this.passager = passager;
	}

	public ReservationCovoiturage getReservationCovoiturage() {
		return reservationCovoiturage;
	}

	public void setReservationCovoiturage(ReservationCovoiturage reservationCovoiturage) {
		this.reservationCovoiturage = reservationCovoiturage;
	}

	public StatutReservationCovoiturage getStatutReservationCovoiturage() {
		return statutReservationCovoiturage;
	}

	public void setStatutReservationCovoiturage(StatutReservationCovoiturage statutReservationCovoiturage) {
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}
}
