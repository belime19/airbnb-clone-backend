package com.goldenCollar.InMyHouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Propriete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idPrpreite;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    TypePropriete typePropriete;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PROPRIETAIRE_ID",referencedColumnName = "ID")
    private Utilisateur proprietaire;

    @JsonIgnore
    @OneToMany(mappedBy = "propriete")
    private Set<Reservation> reservations =new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;
    @Column(name = "SURFACE")
    private double surface;

    @Column(name = "PRIX_UNITAIRE")
    private double prixUnitaire;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "DESCRIPTION", columnDefinition="TEXT")
    private String description;

    @Column(name = "ETOILES")
    private int etoiles;

    @Column(name = "IMAGE")
    private String image;

    public Propriete() {
    }

    public Propriete(TypePropriete typePropriete, Utilisateur proprietaire, Set<Reservation> reservations, Adresse adresse, double surface, double prixUnitaire, String titre, String description, int etoiles, String image) {
        this.proprietaire = proprietaire;
        this.reservations = reservations;
        this.adresse = adresse;
        this.surface = surface;
        this.prixUnitaire = prixUnitaire;
        this.titre = titre;
        this.description = description;
        this.etoiles = etoiles;
        this.image = image;
        this.typePropriete = typePropriete;
    }

    public Long getIdPrpreite() {
        return idPrpreite;
    }

    public void setIdPrpreite(Long idPrpreite) {
        this.idPrpreite = idPrpreite;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }


    public Set<Reservation> getReservation() {
        return reservations;
    }

    public void setReservation(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TypePropriete getTypePropriete() {
        return typePropriete;
    }

    public void setTypePropriete(TypePropriete typePropriete) {
        this.typePropriete = typePropriete;
    }
}
