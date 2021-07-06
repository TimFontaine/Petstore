package petstore.controller;

import com.tim.petstore.model.Pet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import petstore.config.Config;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PetController  {

    private static final Log log = LogFactory.getLog(PetController.class);

    private final WebClient webClient;

    @Autowired
    private Config config;

    @Autowired
    private PetService petService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    public PetController(WebClient webClient) {
        this.webClient = webClient;
    }

    @RequestMapping(value = "/getPet", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Pet> getPetById() {
        return petService.hello();
    }

    @RequestMapping(value = "/name")
    public Mono<String> name() {
        return WebClient.builder().build().get().uri("http://client-service").retrieve().bodyToMono(String.class);
    }


    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
            Mono<String> petMono = webClient.get().retrieve().bodyToMono(String.class);
        return petMono.block();
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")
    public List getCountries()
    {
        List listOfCountries = new ArrayList();
        return listOfCountries;
    }

    @RequestMapping("/service")
    public List<String> service() {
        try {
            return this.discoveryClient.getServices();

        } catch (Exception e) {
            return Arrays.asList(e.getMessage());
        }
    }







}
