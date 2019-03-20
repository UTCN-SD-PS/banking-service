package utcn.labs.sd.bankingservice.domain.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utcn.labs.sd.bankingservice.core.configuration.SwaggerTags;
import utcn.labs.sd.bankingservice.domain.dto.AccountDTO;

import java.util.Collections;
import java.util.List;

@Api(tags = {SwaggerTags.BANKING_SERVICE_TAG})
@RestController
@RequestMapping("/bank/admin/employee")
@CrossOrigin
class EmployeeController {


    @ApiOperation(value = "getAllEmployees", tags = SwaggerTags.EMPLOYEE_TAG)
    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return Collections.emptyList();
    }


}
