
package nl.jan.generated.beans;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Map van kenmerken (sleutel/waarde) waarop notificaties gefilterd worden. Alleen notificaties waarvan de kenmerken voldoen aan het filter worden doorgestuurd naar de afnemer van het ABONNEMENT.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
@Generated("jsonschema2pojo")
public class Filters extends PanacheEntityBase implements Serializable {

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
