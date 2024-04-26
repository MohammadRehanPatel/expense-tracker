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

public class ExpenseCategory {
    private String expCatId;
    private String userId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
