package metier;

import java.time.LocalDate;


public class Abonnement{
	
	private int idCl;
	private int idRev;
	private LocalDate dateDeb;
	private LocalDate dateFin;
	
	
	public Abonnement(int idCl, int idRev, LocalDate dateDeb, LocalDate dateFin) {
		super();
		this.idCl = idCl;
		this.idRev = idRev;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
	}
	
	public int getIdCl() {
		return idCl;
	}

	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}

	public int getIdRev() {
		return idRev;
	}

	public void setIdRev(int idRev) {
		this.idRev = idRev;
	}

	public LocalDate getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(LocalDate dateDeb) {
		this.dateDeb = dateDeb;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	


	
	

		
}
