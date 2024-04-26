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

public class ReportExp {
    private String amount;
    private String expenseCategory;
    private String createdAt;
}
