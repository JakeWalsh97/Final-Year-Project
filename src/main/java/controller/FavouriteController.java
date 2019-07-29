package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.FavouiteRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="mvdb1.database.windows.net", allowedHeaders="*", methods = { GET, POST, PUT, DELETE, OPTIONS})
public class FavouriteController {

    public FavouriteController(FavouiteRepository favouiteRepository) {
        this.favouiteRepository = favouiteRepository;
    }

    @Autowired
    FavouiteRepository favouiteRepository;

    @GetMapping("/favourites")
    public List<Favourite> getFavourites(){
        return favouiteRepository.findAll();
    }

    @GetMapping("/favourites/{id}")
    public Optional<Favourite> getFavourite(@PathVariable Long id){
        return favouiteRepository.findById(id);
    }

    @DeleteMapping("/favourites/{id}")
    public boolean deleteFavourite(@PathVariable Long id){
        favouiteRepository.deleteById(id);
        return true;
    }

    @PutMapping("/favourites/update")
    public Favourite updateFavourite(@RequestBody Favourite favourite){
        return favouiteRepository.save(favourite);
    }

    @PostMapping("/favourites/create")
    public Favourite createFavourite(@RequestBody Favourite favourite){
        return favouiteRepository.save(favourite);
    }
}
