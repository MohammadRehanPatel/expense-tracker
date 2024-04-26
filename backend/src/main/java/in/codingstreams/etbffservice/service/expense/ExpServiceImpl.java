package in.codingstreams.etbffservice.service.expense;

import in.codingstreams.etbffservice.constant.LoggingConstants;
import in.codingstreams.etbffservice.controller.dto.Expense;
import in.codingstreams.etbffservice.controller.dto.ExpenseData;
import in.codingstreams.etbffservice.service.expcat.ExpCatService;
import in.codingstreams.etbffservice.service.external.ExpenseServiceFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExpServiceImpl implements ExpService {

   private  final ExpenseServiceFeignClient expenseServiceFeignClient;

    @Override
    public Expense createExpense(String userId, ExpenseData data) {

        var methodName= "ExpServiceImpl:createExpense";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId,data);

        var savedExpense = expenseServiceFeignClient.createExpense(userId,data).getBody();

        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);

//        Return Saved Expense Category

        return savedExpense;
    }

    @Override
    public Expense getExpById(String userId, String expId) {

        var methodName= "ExpServiceImpl:getExpById";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId,expId);

        var expense = expenseServiceFeignClient.getExpById(userId,expId).getBody();

        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);

        return expense;
    }

    @Override
    public Page<Expense> listExpByUserId(String userId, Pageable pageable, String startDate, String endDate) {

        var methodName= "ExpServiceImpl:listExpByUserId";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId);

        var expenses = expenseServiceFeignClient.listExpByUserId(userId, pageable, startDate, endDate).getBody();


        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);
        return expenses;
    }

    @Override
    public Expense updateExpense(String userId, String expId, ExpenseData data) {

        var methodName= "ExpServiceImpl:updateExpense";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId,data);

        var expense = expenseServiceFeignClient.updateExpense(userId, expId,data).getBody();

        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);

//        Return Saved Expense

        return expense;
    }

    @Override
    public void deleteExpById(String userId, String expId) {

        var methodName= "ExpServiceImpl:deleteExpById";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId);

         expenseServiceFeignClient.deleteExpById(userId, expId);


        log.info(LoggingConstants.END_METHOD_LOG,methodName,userId);
    }

}
