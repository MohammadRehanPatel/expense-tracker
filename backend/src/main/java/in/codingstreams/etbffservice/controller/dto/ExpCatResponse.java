package in.codingstreams.etbffservice.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ExpCatResponse {
    private String expCatId;
    private String name;
    private String date;
    private String time;
}
