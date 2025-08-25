package nl.jan.generated;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import nl.jan.generated.beans.Kanaal;
import nl.jan.generated.beans.PatchedKanaal;

import java.util.List;

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
