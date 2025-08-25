package nl.jan.generated;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import nl.jan.generated.beans.Message;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/notificaties")
public interface NotificatiesResource {
  /**
   * <p>
   * Publiceren van NOTIFICATIEs.
   * </p>
   * <p>
   * Een NOTIFICATIE wordt gepubliceerd op een KANAAL. Alle consumers die een
   * ABONNEMENT hebben op dit KANAAL ontvangen de NOTIFICATIE.
   * </p>
   * 
   */
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Message notificaties_create(@HeaderParam("Content-Type") @NotNull String contentType, @NotNull Message data);
}
