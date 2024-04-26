package in.codingstreams.etbffservice.service.reports;

import in.codingstreams.etbffservice.controller.dto.MonthlyReport;
import in.codingstreams.etbffservice.controller.dto.WeeklyReport;

public interface ReportsService {
    WeeklyReport getWeeklyReport(String userId);

    MonthlyReport getMonthlyReport(String userId, String startDate);
}
