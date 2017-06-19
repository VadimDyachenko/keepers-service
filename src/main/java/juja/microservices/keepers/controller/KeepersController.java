package juja.microservices.keepers.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import juja.microservices.keepers.entity.KeeperDirectionRequest;
import juja.microservices.keepers.service.KeepersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.HttpURLConnection;
import java.util.List;

/**
 * @author Vadim Dyachenko
 */
@RestController
public class KeepersController {

    @Inject
    private KeepersService keepersService;

    @GetMapping(value = "/keepers/{uuid}", produces = "application/json")
    @ApiOperation(
            value = "Get a list of all directions of active keeper",
            notes = "This method returns a list of all directions of active keeper"
    )
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of all directions of active keeper"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Bad request"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_METHOD, message = "Bad method")
    })
    public ResponseEntity<?> getDirections(@PathVariable String uuid) {
        List<KeeperDirectionRequest> result = keepersService.getDirections(uuid);

        return ResponseEntity.ok(result);
    }
}
