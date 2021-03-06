package dev.domain;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VehiculeEntreprise extends Vehicule {

	protected byte nbPlaces;
	
	@OneToOne(cascade = CascadeType.ALL)
	protected Localisation localisation;
	
	@OneToMany(mappedBy = "vehiculeEntreprise")
	protected List<ReservationEntreprise> reservationsEntreprise = new ArrayList<ReservationEntreprise>();
	
	@OneToOne(cascade = CascadeType.ALL)
	protected StatutVehicule statutVehicule;

	public VehiculeEntreprise() {
		super();
	}

	public VehiculeEntreprise(String immatriculation, String marque, String photoUrl, Blob photo, String modele,
			String categorie, byte nbPlaces, Localisation localisation,
			List<ReservationEntreprise> reservationsEntreprise, StatutVehicule statutVehicule) {
		super(immatriculation, marque, photoUrl, photo, modele, categorie);
		this.nbPlaces = nbPlaces;
		this.localisation = localisation;
		this.reservationsEntreprise = reservationsEntreprise;
		this.statutVehicule = statutVehicule;
	}

	public List<ReservationEntreprise> getReservationsEntreprise() {
		return reservationsEntreprise;
	}

	public void setReservationsEntreprise(List<ReservationEntreprise> reservationsEntreprise) {
		this.reservationsEntreprise = reservationsEntreprise;
	}

	public byte getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(byte nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public StatutVehicule getStatutVehicule() {
		return statutVehicule;
	}

	public void setStatutVehicule(StatutVehicule statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

	public void addReservationEntreprise(ReservationEntreprise reservationEntreprise) {
		reservationsEntreprise.add(reservationEntreprise);
	}
}
