
package nl.jan.generated.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "naam",
    "documentatieLink",
    "filters"
})
@Generated("jsonschema2pojo")
@Entity
public class Kanaal extends PanacheEntityBase {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    /**
     * URL-referentie naar dit object. Dit is de unieke identificatie en locatie van dit object.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL-referentie naar dit object. Dit is de unieke identificatie en locatie van dit object.")
    private URI url;
    /**
     * Naam van het KANAAL (ook wel "Exchange" genoemd) dat de bron vertegenwoordigd.
     * (Required)
     * 
     */
    @JsonProperty("naam")
    @JsonPropertyDescription("Naam van het KANAAL (ook wel \"Exchange\" genoemd) dat de bron vertegenwoordigd.")
    private String naam;
    /**
     * URL naar documentatie.
     * 
     */
    @JsonProperty("documentatieLink")
    @JsonPropertyDescription("URL naar documentatie.")
    private URI documentatieLink;
    /**
     * Lijst van mogelijke filter kenmerken van een KANAAL. Deze filter kenmerken kunnen worden gebruikt bij het aanmaken van een ABONNEMENT.
     * 
     */
    @JsonProperty("filters")
    @JsonPropertyDescription("Lijst van mogelijke filter kenmerken van een KANAAL. Deze filter kenmerken kunnen worden gebruikt bij het aanmaken van een ABONNEMENT.")
    private List<String> filters = new ArrayList<String>();

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    /**
     * URL-referentie naar dit object. Dit is de unieke identificatie en locatie van dit object.
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * URL-referentie naar dit object. Dit is de unieke identificatie en locatie van dit object.
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * Naam van het KANAAL (ook wel "Exchange" genoemd) dat de bron vertegenwoordigd.
     * (Required)
     * 
     */
    @JsonProperty("naam")
    public String getNaam() {
        return naam;
    }

    /**
     * Naam van het KANAAL (ook wel "Exchange" genoemd) dat de bron vertegenwoordigd.
     * (Required)
     * 
     */
    @JsonProperty("naam")
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * URL naar documentatie.
     * 
     */
    @JsonProperty("documentatieLink")
    public URI getDocumentatieLink() {
        return documentatieLink;
    }

    /**
     * URL naar documentatie.
     * 
     */
    @JsonProperty("documentatieLink")
    public void setDocumentatieLink(URI documentatieLink) {
        this.documentatieLink = documentatieLink;
    }

    /**
     * Lijst van mogelijke filter kenmerken van een KANAAL. Deze filter kenmerken kunnen worden gebruikt bij het aanmaken van een ABONNEMENT.
     * 
     */
    @JsonProperty("filters")
    public List<String> getFilters() {
        return filters;
    }

    /**
     * Lijst van mogelijke filter kenmerken van een KANAAL. Deze filter kenmerken kunnen worden gebruikt bij het aanmaken van een ABONNEMENT.
     * 
     */
    @JsonProperty("filters")
    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

 /*   *//**
     * Updates only filled fields
     * @param kanaal
     *//*
    public void partialupdate(Kanaal kanaal){

        //kanaal.setUrl(this.url);
    }*/
}
