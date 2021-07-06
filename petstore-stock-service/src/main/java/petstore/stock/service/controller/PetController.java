package petstore.stock.service.controller;


import com.tim.petstore.api.PetApi;
import com.tim.petstore.model.Category;
import com.tim.petstore.model.Pet;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {

    @Override
    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet to return",required=true) @PathVariable("petId") Long petId) {

        Category category = new Category();
        category.setId(1L);
        category.setName("dog");
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Doggy");
        pet.setCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(pet);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
       return "hello";
    }
}
