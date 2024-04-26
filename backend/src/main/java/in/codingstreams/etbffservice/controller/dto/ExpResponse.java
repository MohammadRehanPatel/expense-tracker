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

public class ExpResponse {
    private String expId;
    private String title;
    private String amount;

    private ExpCatResponse expCat;
    private String date;
    private String time;
}
