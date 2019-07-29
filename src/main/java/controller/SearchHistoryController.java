package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.SearchHistoryRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="mvdb1.database.windows.net", allowedHeaders="*", methods = { GET, POST, PUT, DELETE, OPTIONS})
public class SearchHistoryController {

    public SearchHistoryController(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Autowired
    SearchHistoryRepository searchHistoryRepository;

    @GetMapping("/searchHistory")
    public List<SearchHistory> getAllSearchHistory() {
        return searchHistoryRepository.findAll();
    }

    @GetMapping("/searchHistory/{id}")
    public Optional<SearchHistory> getSearchHistory(@PathVariable Long id){
        return searchHistoryRepository.findById(id);
    }

    @DeleteMapping("/searchHistory/{id}")
    public boolean deleteSearchHistory(@PathVariable Long id) {
        searchHistoryRepository.deleteById(id);
        return true;
    }

    @PutMapping("/searchHistory/update")
    public SearchHistory updateSearchHistory(@RequestBody SearchHistory searchHistory) {
        return searchHistoryRepository.save(searchHistory);
    }

    @PostMapping("/searchHistory/create")
    public SearchHistory createSearchHistory(@RequestBody SearchHistory searchHistory) {
        return searchHistoryRepository.save(searchHistory);
    }

    @RequestMapping("/searchHistory/add")
    public String addSearchHistory(){
        SearchHistory searchHistory = new SearchHistory(1, 505954, "T-34", 10752, "TestUser");
        searchHistoryRepository.save(searchHistory);
        return "Search History successfully saved to the database";
    }
}
