package org.apache.activemq.artemis.scenarios.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.apache.activemq.artemis.scenarios.model.requests.OrdersIncomeRequest;
import org.apache.activemq.artemis.scenarios.model.response.OrdersResponse;
import org.apache.activemq.artemis.scenarios.service.IncomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.apache.activemq.artemis.scenarios.resource.Constants.APPLICATION_YAML;

@Path("/incomeOrders")
public class IncomeOrdersResource {

    private static final Logger LOGGER = LogManager.getLogger(IncomeOrdersResource.class);

    @POST
    @Consumes(APPLICATION_YAML)
    @Produces(APPLICATION_YAML)
    public Response startScenario(OrdersIncomeRequest scenarioRequest) throws Exception {
        IncomeService incomeService = new IncomeService();
        OrdersResponse result = incomeService.process(scenarioRequest);

        return Response.ok(result).build();
    }
}
