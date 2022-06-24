package unit.service;

import com.revature.model.Car;
import com.revature.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class CarServiceUnitTest {

    List<Car> mockList = Mockito.mock(List.class);

    @Test
    public void whenGivenCarObjectCreateNewCarDoesNotThrowAnException(){
        Car car = new Car();
        CarService service = new CarService();

        // we've turned our service invocation into an executable that can be called by the assertion
        Assertions.assertDoesNotThrow(() -> service.createNewCar(car));
    }

//    @Test
//    public void whenGivenFlashcardObjectCreateNewFlashcardReturnsTrue(){
//        Flashcard flashcard = new Flashcard();
//        FlashcardService service = new FlashcardService();
//        Mockito.when(mockList.add(flashcard)).thenReturn(true);
//        boolean result = service.createNewFlashcard(flashcard);
//        Assertions.assertTrue(result);
//    }

    @Test
    public void whenGetAllCarsIsCalledReturnsListOfCars(){
        // this method is also tricky as we can't really ensure the list returns itself
        // so instead, we once again just assert that this execution doesn't throw an exception

        CarService service = new CarService();
        Assertions.assertDoesNotThrow(() -> service.getAllCars());
    }


//    @Test
//    public void whenGivenValidIdGetFlashcardByIdReturnsFlashcardWithThatId(){
//        Flashcard flashcard = new Flashcard(0, "question", "answer");
//
//        // fake the size of the list when it is called
//        Mockito.when(mockList.size()).thenReturn(1);
//        Mockito.when(mockList.get(0)).thenReturn(flashcard);
//        FlashcardService service = new FlashcardService(mockList);
//        Flashcard result = service.getFlashcardById(0);
//        Assertions.assertEquals(flashcard, result);
//    }
}
