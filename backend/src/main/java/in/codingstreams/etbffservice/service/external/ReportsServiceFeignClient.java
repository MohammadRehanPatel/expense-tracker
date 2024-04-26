package in.codingstreams.etbffservice.service.external;


import in.codingstreams.etbffservice.controller.dto.ReportsRequest;
import in.codingstreams.etbffservice.controller.dto.ReportsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${services.et-rs.name}",url = "${services.et-rs.url}")
public interface ReportsServiceFeignClient {


    @PostMapping("/users/{userId}/reports/weekly-report")
    public ResponseEntity<ReportsResponse> getWeeklyReport(
            @PathVariable String userId,
            @RequestBody ReportsRequest request
    );

//    Monthly Report

    @PostMapping("/users/{userId}/reports/monthly-report")
    public ResponseEntity<ReportsResponse> getMonthlyReport(
            @PathVariable String userId,
            @RequestBody ReportsRequest  request
    );

}
