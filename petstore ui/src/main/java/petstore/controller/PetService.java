package petstore.controller;

import com.tim.petstore.model.Pet;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PetService {

    private final WebClient webClient ;

    private PetService(WebClient.Builder webClientBuilder ) {
        this.webClient  = webClientBuilder.baseUrl("http://petstore-stock").build();

    }

    public Mono<Pet> hello() {
        Mono<Pet> petMono = webClient.get().uri("/pet/{id}", 11).retrieve().bodyToMono(Pet.class);
        return petMono;
    }







}
