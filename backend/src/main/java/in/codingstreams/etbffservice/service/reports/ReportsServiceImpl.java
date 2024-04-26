package in.codingstreams.etbffservice.service.reports;

import in.codingstreams.etbffservice.constant.LoggingConstants;
import in.codingstreams.etbffservice.controller.dto.*;
import in.codingstreams.etbffservice.service.expense.ExpService;
import in.codingstreams.etbffservice.service.external.ReportsServiceFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportsServiceImpl implements  ReportsService{

    private final ExpService expService;
    private final ReportsServiceFeignClient reportsServiceFeignClient;



    private static ReportExp mapToReportExp(Expense expense) {
        return ReportExp.builder()
                .amount(expense.getAmount())
                .createdAt(String.valueOf(expense.getCreatedAt()))
                .expenseCategory(expense.getExpCat().getName())
                .build();
    }

    @Override
    public WeeklyReport getWeeklyReport(String userId) {

        var methodName="ReportsServiceImpl:getWeeklyReport";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId);

//        Get all expenses (weekly)
//        Start Date
        var dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var today=  LocalDateTime.now().toLocalDate();
        var startDate = dateTimeFormatter.format(LocalDateTime.now().toLocalDate());
        LocalDateTime.now().toLocalDate();
//        End Date
        var endDate = dateTimeFormatter.format(today.minusDays(-7));

        var expensePage = expService.listExpByUserId(userId, null, startDate, endDate);

        var reportsRequest = ReportsRequest.builder()
                .expenses(expensePage.getContent()
                        .stream()
                        .map(ReportsServiceImpl::mapToReportExp)
                        .collect(Collectors.toList())
                )
                .build();

        var  weeklyReport = reportsServiceFeignClient.getWeeklyReport(userId, reportsRequest).getBody().getWeeklyReport();

        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);

        return weeklyReport;
    }

    @Override
    public MonthlyReport getMonthlyReport(String userId, String startDate) {

        var methodName="ReportsServiceImpl:getMonthlyReport";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId);


//        Get all expenses (monthly)

        var dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


//        End Date
        var endDate = dateTimeFormatter.format(
                LocalDate.parse(startDate,dateTimeFormatter).plusMonths(1)
        );

        var expensePage = expService.listExpByUserId(userId, null, startDate, endDate);

        var reportsRequest = ReportsRequest.builder()
                .expenses(expensePage.getContent()
                        .stream()
                        .map(expense -> ReportExp.builder()
                                .amount(expense.getAmount())
                                .createdAt(String.valueOf(expense.getCreatedAt()))
                                .expenseCategory(expense.getExpCat().getName())
                                .build())
                        .collect(Collectors.toList()))
                
                .build();

        var  monthlyReport = reportsServiceFeignClient.getMonthlyReport(userId, reportsRequest).getBody().getMonthlyReport();


        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);
        return monthlyReport;
    }
}
