
package nl.jan.generated.beans;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.net.URI;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kanaal",
    "hoofdObject",
    "resource",
    "resourceUrl",
    "actie",
    "aanmaakdatum",
    "kenmerken"
})
@Generated("jsonschema2pojo")
public class Message {

    /**
     * De naam van het kanaal (`KANAAL.naam`) waar het bericht op moet worden gepubliceerd.
     * (Required)
     * 
     */
    @JsonProperty("kanaal")
    @JsonPropertyDescription("De naam van het kanaal (`KANAAL.naam`) waar het bericht op moet worden gepubliceerd.")
    private String kanaal;
    /**
     * hoofdobject
     * <p>
     * URL-referentie naar het hoofd object van de publicerende API die betrekking heeft op de `resource`.
     * (Required)
     * 
     */
    @JsonProperty("hoofdObject")
    @JsonPropertyDescription("URL-referentie naar het hoofd object van de publicerende API die betrekking heeft op de `resource`.")
    private URI hoofdObject;
    /**
     * De resourcenaam waar de notificatie over gaat.
     * (Required)
     * 
     */
    @JsonProperty("resource")
    @JsonPropertyDescription("De resourcenaam waar de notificatie over gaat.")
    private String resource;
    /**
     * URL-referentie naar de `resource` van de publicerende API.
     * (Required)
     * 
     */
    @JsonProperty("resourceUrl")
    @JsonPropertyDescription("URL-referentie naar de `resource` van de publicerende API.")
    private URI resourceUrl;
    /**
     * De actie die door de publicerende API is gedaan. De publicerende API specificeert de toegestane acties.
     * (Required)
     * 
     */
    @JsonProperty("actie")
    @JsonPropertyDescription("De actie die door de publicerende API is gedaan. De publicerende API specificeert de toegestane acties.")
    private String actie;
    /**
     * Datum en tijd waarop de actie heeft plaatsgevonden.
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @JsonProperty("aanmaakdatum")
    @JsonPropertyDescription("Datum en tijd waarop de actie heeft plaatsgevonden.")
    private Date aanmaakdatum;
    /**
     * Mapping van kenmerken (sleutel/waarde) van de notificatie. De publicerende API specificeert de toegestane kenmerken.
     * 
     */
    @JsonProperty("kenmerken")
    @JsonPropertyDescription("Mapping van kenmerken (sleutel/waarde) van de notificatie. De publicerende API specificeert de toegestane kenmerken.")
    private Kenmerken kenmerken;

    /**
     * De naam van het kanaal (`KANAAL.naam`) waar het bericht op moet worden gepubliceerd.
     * (Required)
     * 
     */
    @JsonProperty("kanaal")
    public String getKanaal() {
        return kanaal;
    }

    /**
     * De naam van het kanaal (`KANAAL.naam`) waar het bericht op moet worden gepubliceerd.
     * (Required)
     * 
     */
    @JsonProperty("kanaal")
    public void setKanaal(String kanaal) {
        this.kanaal = kanaal;
    }

    /**
     * hoofdobject
     * <p>
     * URL-referentie naar het hoofd object van de publicerende API die betrekking heeft op de `resource`.
     * (Required)
     * 
     */
    @JsonProperty("hoofdObject")
    public URI getHoofdObject() {
        return hoofdObject;
    }

    /**
     * hoofdobject
     * <p>
     * URL-referentie naar het hoofd object van de publicerende API die betrekking heeft op de `resource`.
     * (Required)
     * 
     */
    @JsonProperty("hoofdObject")
    public void setHoofdObject(URI hoofdObject) {
        this.hoofdObject = hoofdObject;
    }

    /**
     * De resourcenaam waar de notificatie over gaat.
     * (Required)
     * 
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * De resourcenaam waar de notificatie over gaat.
     * (Required)
     * 
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * URL-referentie naar de `resource` van de publicerende API.
     * (Required)
     * 
     */
    @JsonProperty("resourceUrl")
    public URI getResourceUrl() {
        return resourceUrl;
    }

    /**
     * URL-referentie naar de `resource` van de publicerende API.
     * (Required)
     * 
     */
    @JsonProperty("resourceUrl")
    public void setResourceUrl(URI resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * De actie die door de publicerende API is gedaan. De publicerende API specificeert de toegestane acties.
     * (Required)
     * 
     */
    @JsonProperty("actie")
    public String getActie() {
        return actie;
    }

    /**
     * De actie die door de publicerende API is gedaan. De publicerende API specificeert de toegestane acties.
     * (Required)
     * 
     */
    @JsonProperty("actie")
    public void setActie(String actie) {
        this.actie = actie;
    }

    /**
     * Datum en tijd waarop de actie heeft plaatsgevonden.
     * (Required)
     * 
     */
    @JsonProperty("aanmaakdatum")
    public Date getAanmaakdatum() {
        return aanmaakdatum;
    }

    /**
     * Datum en tijd waarop de actie heeft plaatsgevonden.
     * (Required)
     * 
     */
    @JsonProperty("aanmaakdatum")
    public void setAanmaakdatum(Date aanmaakdatum) {
        this.aanmaakdatum = aanmaakdatum;
    }

    /**
     * Mapping van kenmerken (sleutel/waarde) van de notificatie. De publicerende API specificeert de toegestane kenmerken.
     * 
     */
    @JsonProperty("kenmerken")
    public Kenmerken getKenmerken() {
        return kenmerken;
    }

    /**
     * Mapping van kenmerken (sleutel/waarde) van de notificatie. De publicerende API specificeert de toegestane kenmerken.
     * 
     */
    @JsonProperty("kenmerken")
    public void setKenmerken(Kenmerken kenmerken) {
        this.kenmerken = kenmerken;
    }

}
