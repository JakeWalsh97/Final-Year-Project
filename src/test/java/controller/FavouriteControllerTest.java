package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repository.FavouiteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavouriteControllerTest {

    /**
     * Mocking both the FavouriteController and FavouriteRepository to simulate the real database functionality.
     */
    @Mock
    FavouriteController favouriteController;

    @Mock
    FavouiteRepository favouiteRepository;

    /**
     * Using a setUp method to initialize the favouriteController to avoid repeating code.
     */
    @Before
    public void setUp()
    {
        favouriteController = new FavouriteController(favouiteRepository);
    }

    /**
     * Calling getFavourites method and returning all favourites from the database.
     */
    @Test
    public void getFavouritesTest_happyPath()
    {
        List<Favourite> response = favouriteController.getFavourites();

        System.out.println(response.toString());
    }

    /**
     * Calling getFavourite method and returning a specific favourite from database using ID.
     */
    @Test
    public void getFavouriteTest_happyPath()
    {
        long id = 1;
        Optional<Favourite> response = favouriteController.getFavourite(id);

        System.out.println(response.toString());
    }

    /**
     * Calling createFavourite and deleteFavourite methods to test the add and delete functionality of the database.
     */
    @Test
    public void createFavourite_and_deleteFavouriteTest_happyPath()
    {
        Favourite favourite = new Favourite(10000, "Test", 10000, "Test", "Test", new Date(System.currentTimeMillis()));
        favouriteController.createFavourite(favourite);
        favouiteRepository.save(favourite);

        favouriteController.deleteFavourite(favourite.id);
        System.out.println("Favourite deleted from database!");
    }
}
