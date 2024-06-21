package payload.request;

import lombok.Data;

@Data

public class UpdateRoomTypeRequest {
    private int id;
    private String name;
}
