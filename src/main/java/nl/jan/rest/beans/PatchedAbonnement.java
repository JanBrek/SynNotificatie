
package nl.jan.rest.beans;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "callbackUrl",
    "auth",
    "kanalen"
})
@Generated("jsonschema2pojo")
public class PatchedAbonnement {

    /**
     * URL-referentie naar dit object. Dit is de unieke identificatie en locatie van dit object.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL-referentie naar dit object. Dit is de unieke identificatie en locatie van dit object.")
    private URI url;
    /**
     * De URL waar notificaties naar toe gestuurd dienen te worden. Deze URL dient uit te komen bij een API die geschikt is om notificaties op te ontvangen.
     * 
     */
    @JsonProperty("callbackUrl")
    @JsonPropertyDescription("De URL waar notificaties naar toe gestuurd dienen te worden. Deze URL dient uit te komen bij een API die geschikt is om notificaties op te ontvangen.")
    private URI callbackUrl;
    /**
     * Autorisatie header
     * <p>
     * Autorisatie header invulling voor het vesturen naar de "Callback URL". Voorbeeld: Bearer a4daa31...
     * 
     */
    @JsonProperty("auth")
    @JsonPropertyDescription("Autorisatie header invulling voor het vesturen naar de \"Callback URL\". Voorbeeld: Bearer a4daa31...")
    private String auth;
    /**
     * Een lijst van kanalen en filters waarop het ABONNEMENT wordt afgenomen.
     * 
     */
    @JsonProperty("kanalen")
    @JsonPropertyDescription("Een lijst van kanalen en filters waarop het ABONNEMENT wordt afgenomen.")
    private List<FilterGroup> kanalen = new ArrayList<FilterGroup>();

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
     * De URL waar notificaties naar toe gestuurd dienen te worden. Deze URL dient uit te komen bij een API die geschikt is om notificaties op te ontvangen.
     * 
     */
    @JsonProperty("callbackUrl")
    public URI getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * De URL waar notificaties naar toe gestuurd dienen te worden. Deze URL dient uit te komen bij een API die geschikt is om notificaties op te ontvangen.
     * 
     */
    @JsonProperty("callbackUrl")
    public void setCallbackUrl(URI callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * Autorisatie header
     * <p>
     * Autorisatie header invulling voor het vesturen naar de "Callback URL". Voorbeeld: Bearer a4daa31...
     * 
     */
    @JsonProperty("auth")
    public String getAuth() {
        return auth;
    }

    /**
     * Autorisatie header
     * <p>
     * Autorisatie header invulling voor het vesturen naar de "Callback URL". Voorbeeld: Bearer a4daa31...
     * 
     */
    @JsonProperty("auth")
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * Een lijst van kanalen en filters waarop het ABONNEMENT wordt afgenomen.
     * 
     */
    @JsonProperty("kanalen")
    public List<FilterGroup> getKanalen() {
        return kanalen;
    }

    /**
     * Een lijst van kanalen en filters waarop het ABONNEMENT wordt afgenomen.
     * 
     */
    @JsonProperty("kanalen")
    public void setKanalen(List<FilterGroup> kanalen) {
        this.kanalen = kanalen;
    }

}
