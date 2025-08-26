
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
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filters",
    "naam"
})
@Generated("jsonschema2pojo")
@Entity
public class FilterGroup extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    /**
     * Map van kenmerken (sleutel/waarde) waarop notificaties gefilterd worden. Alleen notificaties waarvan de kenmerken voldoen aan het filter worden doorgestuurd naar de afnemer van het ABONNEMENT.
     * 
     */
    @JsonProperty("filters")
    @JsonPropertyDescription("Map van kenmerken (sleutel/waarde) waarop notificaties gefilterd worden. Alleen notificaties waarvan de kenmerken voldoen aan het filter worden doorgestuurd naar de afnemer van het ABONNEMENT.")
    private Filters filters;
    /**
     * De naam van het KANAAL (`KANAAL.naam`) waarop een abonnement is of wordt genomen.
     * (Required)
     * 
     */
    @JsonProperty("naam")
    @JsonPropertyDescription("De naam van het KANAAL (`KANAAL.naam`) waarop een abonnement is of wordt genomen.")
    private String naam;

    /**
     * Map van kenmerken (sleutel/waarde) waarop notificaties gefilterd worden. Alleen notificaties waarvan de kenmerken voldoen aan het filter worden doorgestuurd naar de afnemer van het ABONNEMENT.
     * 
     */
    @JsonProperty("filters")
    public Filters getFilters() {
        return filters;
    }

    /**
     * Map van kenmerken (sleutel/waarde) waarop notificaties gefilterd worden. Alleen notificaties waarvan de kenmerken voldoen aan het filter worden doorgestuurd naar de afnemer van het ABONNEMENT.
     * 
     */
    @JsonProperty("filters")
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    /**
     * De naam van het KANAAL (`KANAAL.naam`) waarop een abonnement is of wordt genomen.
     * (Required)
     * 
     */
    @JsonProperty("naam")
    public String getNaam() {
        return naam;
    }

    /**
     * De naam van het KANAAL (`KANAAL.naam`) waarop een abonnement is of wordt genomen.
     * (Required)
     * 
     */
    @JsonProperty("naam")
    public void setNaam(String naam) {
        this.naam = naam;
    }

}
