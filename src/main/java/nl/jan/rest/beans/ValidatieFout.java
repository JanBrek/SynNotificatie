
package nl.jan.rest.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Formaat van HTTP 4xx en 5xx fouten.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "code",
    "title",
    "status",
    "detail",
    "instance",
    "invalidParams"
})
@Generated("jsonschema2pojo")
public class ValidatieFout {

    /**
     * URI referentie naar het type fout, bedoeld voor developers
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("URI referentie naar het type fout, bedoeld voor developers")
    private String type;
    /**
     * Systeemcode die het type fout aangeeft
     * (Required)
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("Systeemcode die het type fout aangeeft")
    private String code;
    /**
     * Generieke titel voor het type fout
     * (Required)
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Generieke titel voor het type fout")
    private String title;
    /**
     * De HTTP status code
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("De HTTP status code")
    private Integer status;
    /**
     * Extra informatie bij de fout, indien beschikbaar
     * (Required)
     * 
     */
    @JsonProperty("detail")
    @JsonPropertyDescription("Extra informatie bij de fout, indien beschikbaar")
    private String detail;
    /**
     * URI met referentie naar dit specifiek voorkomen van de fout. Deze kan gebruikt worden in combinatie met server logs, bijvoorbeeld.
     * (Required)
     * 
     */
    @JsonProperty("instance")
    @JsonPropertyDescription("URI met referentie naar dit specifiek voorkomen van de fout. Deze kan gebruikt worden in combinatie met server logs, bijvoorbeeld.")
    private String instance;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("invalidParams")
    private List<FieldValidationError> invalidParams = new ArrayList<FieldValidationError>();

    /**
     * URI referentie naar het type fout, bedoeld voor developers
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * URI referentie naar het type fout, bedoeld voor developers
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
     * Generieke titel voor het type fout
     * (Required)
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Generieke titel voor het type fout
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * De HTTP status code
     * (Required)
     * 
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     * De HTTP status code
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Extra informatie bij de fout, indien beschikbaar
     * (Required)
     * 
     */
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    /**
     * Extra informatie bij de fout, indien beschikbaar
     * (Required)
     * 
     */
    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * URI met referentie naar dit specifiek voorkomen van de fout. Deze kan gebruikt worden in combinatie met server logs, bijvoorbeeld.
     * (Required)
     * 
     */
    @JsonProperty("instance")
    public String getInstance() {
        return instance;
    }

    /**
     * URI met referentie naar dit specifiek voorkomen van de fout. Deze kan gebruikt worden in combinatie met server logs, bijvoorbeeld.
     * (Required)
     * 
     */
    @JsonProperty("instance")
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("invalidParams")
    public List<FieldValidationError> getInvalidParams() {
        return invalidParams;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("invalidParams")
    public void setInvalidParams(List<FieldValidationError> invalidParams) {
        this.invalidParams = invalidParams;
    }

}
