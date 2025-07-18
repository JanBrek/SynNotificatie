
package nl.jan.rest.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Formaat van validatiefouten.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "code",
    "reason"
})
@Generated("jsonschema2pojo")
public class FieldValidationError {

    /**
     * Naam van het veld met ongeldige gegevens
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Naam van het veld met ongeldige gegevens")
    private String name;
    /**
     * Systeemcode die het type fout aangeeft
     * (Required)
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("Systeemcode die het type fout aangeeft")
    private String code;
    /**
     * Uitleg wat er precies fout is met de gegevens
     * (Required)
     * 
     */
    @JsonProperty("reason")
    @JsonPropertyDescription("Uitleg wat er precies fout is met de gegevens")
    private String reason;

    /**
     * Naam van het veld met ongeldige gegevens
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Naam van het veld met ongeldige gegevens
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Systeemcode die het type fout aangeeft
     * (Required)
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * Systeemcode die het type fout aangeeft
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Uitleg wat er precies fout is met de gegevens
     * (Required)
     * 
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Uitleg wat er precies fout is met de gegevens
     * (Required)
     * 
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

}
