package in.codingstreams.etbffservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyReport {
    private Map<String,Double> totalExpensesByExpCat;
    private Double totalExpenses;
}
