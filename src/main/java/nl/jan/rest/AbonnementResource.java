package nl.jan.rest;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
import nl.jan.rest.beans.Abonnement;
import nl.jan.rest.beans.PatchedAbonnement;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/abonnement")
public interface AbonnementResource {
  /**
   * <p>
   * Opvragen en bewerken van ABONNEMENTen.
   * </p>
   * <p>
   * Een consumer kan een ABONNEMENT nemen op een KANAAL om zo NOTIFICATIEs te
   * ontvangen die op dat KANAAL gepubliceerd worden.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  List<Abonnement> abonnement_list();

  /**
   * <p>
   * Opvragen en bewerken van ABONNEMENTen.
   * </p>
   * <p>
   * Een consumer kan een ABONNEMENT nemen op een KANAAL om zo NOTIFICATIEs te
   * ontvangen die op dat KANAAL gepubliceerd worden.
   * </p>
   * 
   */
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Abonnement abonnement_create(@HeaderParam("Content-Type") @NotNull String contentType, @NotNull Abonnement data);

  /**
   * <p>
   * Opvragen en bewerken van ABONNEMENTen.
   * </p>
   * <p>
   * Een consumer kan een ABONNEMENT nemen op een KANAAL om zo NOTIFICATIEs te
   * ontvangen die op dat KANAAL gepubliceerd worden.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @GET
  @Produces("application/json")
  Abonnement abonnement_read(@PathParam("uuid") String uuid);

  /**
   * <p>
   * Opvragen en bewerken van ABONNEMENTen.
   * </p>
   * <p>
   * Een consumer kan een ABONNEMENT nemen op een KANAAL om zo NOTIFICATIEs te
   * ontvangen die op dat KANAAL gepubliceerd worden.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Abonnement abonnement_update(@HeaderParam("Content-Type") @NotNull String contentType, @PathParam("uuid") String uuid,
      @NotNull Abonnement data);

  /**
   * <p>
   * Opvragen en bewerken van ABONNEMENTen.
   * </p>
   * <p>
   * Een consumer kan een ABONNEMENT nemen op een KANAAL om zo NOTIFICATIEs te
   * ontvangen die op dat KANAAL gepubliceerd worden.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @DELETE
  void abonnement_delete(@PathParam("uuid") String uuid);

  /**
   * <p>
   * Opvragen en bewerken van ABONNEMENTen.
   * </p>
   * <p>
   * Een consumer kan een ABONNEMENT nemen op een KANAAL om zo NOTIFICATIEs te
   * ontvangen die op dat KANAAL gepubliceerd worden.
   * </p>
   * 
   */
  @Path("/{uuid}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Abonnement abonnement_partial_update(@HeaderParam("Content-Type") @NotNull String contentType,
      @PathParam("uuid") String uuid, @NotNull PatchedAbonnement data);
}
