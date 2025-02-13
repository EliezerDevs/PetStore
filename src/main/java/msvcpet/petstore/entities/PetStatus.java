package msvcpet.petstore.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class PetStatus {

    private UUID transatcionId;
    private LocalDateTime dateCreated;
    private Boolean status;
    private String name;


    public UUID getTransatcionId() {
        return transatcionId;
    }

    public void setTransatcionId(UUID transatcionId) {
        this.transatcionId = transatcionId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
