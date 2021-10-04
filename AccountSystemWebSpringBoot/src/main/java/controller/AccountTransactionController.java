package controller;

import dto.AccountTransactionDTO;
import flow.CreateAccountTransactionFlowImpl;
import io.swagger.annotations.*;
//import org.hibernate.mapping.List;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTransactionFlow;

//@RestController;
@RequestMapping("account-transaction")

public class AccountTransactionController {
    
    private static final Logger LOGGER = 
            LoggerFactory.getLogger((CreateAccountTransactionFlowImpl.class));
    
    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    
    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow,
                                        FetchAccountTransactionFlow fetchAccountTransactionFlow) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }           
    
    @PostMapping("")
    //@ApiOperation(value = "Creates a new AccountTransaction.",
            //notes = "Creates a new AccountTransaction in the DB.");
    
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully.",
                    response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",
                    response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.",
                    response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountTransactionDTO>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.", required = true)
            @RequestBody AccountTransactionDTO AccountTransaction) {
        long startTime = System.nanoTime();
        LOGGER.debug("Create a new AccountTransaction.");

        AccountTransactionDTO AccountTransactionResponse =
                createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDTO> response =
                new GeneralResponse<>(true, AccountTransactionResponse);
        ResponseEntity<GeneralResponse<AccountTransactionDTO>> generalResponseResponseEntity =
                new ResponseEntity<>(response, HttpStatus.CREATED);

        LOGGER.info("Response time {}", ((System.nanoTime() - startTime) / 1000000L));

        return generalResponseResponseEntity;
    }

    @GetMapping("/all")

    @ApiOperation(value = "Gets all the configured Account Types.",
            notes = "Returns a list of Account Types.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types returned.",
                    response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",
                    response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found",
                    response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.",
                    response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<List<AccountTransactionDTO>>> getAll() {
            List<AccountTransactionDTO> AccountTransactions =
            fetchAccountTransactionFlow.getAllAccountTransactions();

            GeneralResponse<List<AccountTransactionDTO>> response =
                    new GeneralResponse<>(true, AccountTransactions);

            return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{transactionID}")

    @ApiOperation(value = "Fetches the specified AccountTransaction.",
            notes = "Fetches the corresponding AccountTransaction.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction found.",
                    response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",
                    response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found",
                    response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error.",
                    response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountTransactionDTO>> getAccountTransaction(
            @ApiParam(value = "The TransactionID that uniquely identifies the AccountTransaction.",
            example = "50002",
            name = "TransactionID",
            required = true)
            @PathVariable("TransactionID") final long TransactionID) {

        AccountTransactionDTO AccountTransaction =
                fetchAccountTransactionFlow.getAllAccountTransactionByID(TransactionID);

        GeneralResponse<AccountTransactionDTO> response =
                new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
