package nl.jan.rest;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import nl.jan.rest.beans.Kanaal;
import nl.jan.rest.beans.PatchedKanaal;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/kanaal")
public interface KanaalResource {
  /**
   * <p>
   * Opvragen, aanmaken en bewerken van KANAALen.
   * </p>
   * <p>
   * Op een KANAAL publiceren componenten (bronnen) hun NOTIFICATIEs. Alleen
   * componenten die NOTIFICATIEs willen publiceren dienen een KANAAL aan te
   * maken. Dit KANAAL kan vervolgens aan consumers worden gegeven om zich op te
   * abonneren.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  List<Kanaal> kanaal_list(@QueryParam("naam") String naam);

  /**
   * <p>
   * Opvragen, aanmaken en bewerken van KANAALen.
   * </p>
   * <p>
   * Op een KANAAL publiceren componenten (bronnen) hun NOTIFICATIEs. Alleen
   * componenten die NOTIFICATIEs willen publiceren dienen een KANAAL aan te
   * maken. Dit KANAAL kan vervolgens aan consumers worden gegeven om zich op te
   * abonneren.
   * </p>
   * 
   */
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Kanaal kanaal_create(@HeaderParam("Content-Type") @NotNull String contentType, @NotNull Kanaal data);

  /**
   * <p>
   * Opvragen, aanmaken en bewerken van KANAALen.
   * </p>
   * <p>
   * Op een KANAAL publiceren componenten (bronnen) hun NOTIFICATIEs. Alleen
   * componenten die NOTIFICATIEs willen publiceren dienen een KANAAL aan te
   * maken. Dit KANAAL kan vervolgens aan consumers worden gegeven om zich op te
   * abonneren.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @GET
  @Produces("application/json")
  Kanaal kanaal_read(@PathParam("uuid") String uuid);

  /**
   * <p>
   * Opvragen, aanmaken en bewerken van KANAALen.
   * </p>
   * <p>
   * Op een KANAAL publiceren componenten (bronnen) hun NOTIFICATIEs. Alleen
   * componenten die NOTIFICATIEs willen publiceren dienen een KANAAL aan te
   * maken. Dit KANAAL kan vervolgens aan consumers worden gegeven om zich op te
   * abonneren.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Kanaal kanaal_update(@HeaderParam("Content-Type") @NotNull String contentType, @PathParam("uuid") String uuid,
      @NotNull Kanaal data);

  /**
   * <p>
   * Opvragen, aanmaken en bewerken van KANAALen.
   * </p>
   * <p>
   * Op een KANAAL publiceren componenten (bronnen) hun NOTIFICATIEs. Alleen
   * componenten die NOTIFICATIEs willen publiceren dienen een KANAAL aan te
   * maken. Dit KANAAL kan vervolgens aan consumers worden gegeven om zich op te
   * abonneren.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Kanaal kanaal_partial_update(@HeaderParam("Content-Type") @NotNull String contentType, @PathParam("uuid") String uuid,
      @NotNull PatchedKanaal data);
}
