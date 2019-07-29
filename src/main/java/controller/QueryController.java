package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.QueryRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="mvdb1.database.windows.net", allowedHeaders="*", methods = { GET, POST, PUT, DELETE, OPTIONS})
public class QueryController {

    public QueryController(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Autowired
    QueryRepository queryRepository;

    @GetMapping("/queries")
    public List<Query> getQueries(){
        return queryRepository.findAll();
    }

    @GetMapping("/queries/{id}")
    public Optional<Query> getQuery(@PathVariable Long id){
        return queryRepository.findById(id);
    }

    @DeleteMapping("/queries/{id}")
    public boolean deleteQuery(@PathVariable Long id){
        queryRepository.deleteById(id);
        return true;
    }

    @PutMapping("/queries/update")
    public Query updateQuery(@RequestBody Query query){
        return queryRepository.save(query);
    }

    @PostMapping("/queries/create")
    public Query createQuery(@RequestBody Query query){
        return queryRepository.save(query);
    }

    @RequestMapping("/query/add")
    public String addQuery(){
        Query query = new Query(1, "Jake", "Problem with Favourites", "Some of my favourite films are not loading when I click on the favourites button. Can you help me with this?", new Date(System.currentTimeMillis()), "");
        queryRepository.save(query);
        return "Query Successfully saved to the database";
    }
}
