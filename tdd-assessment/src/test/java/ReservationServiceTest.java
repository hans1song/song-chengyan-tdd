import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ReservationServiceTest {

    private IBookRepository bookRepository;
    private IReservationRepository reservationRepository;
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        bookRepository = new MemoryBookRepository();
        reservationRepository = new MemoryReservationRepository();
        reservationService = new ReservationService(bookRepository, reservationRepository);
    }

// reserve method test cases
    @Test
    void reserve_whenBookExists() {
        Book book = new Book("1", "The Lord of the Rings", 1);
        bookRepository.save(book);
        reservationService.reserve("user1", "1");
        assertTrue(reservationRepository.existsByUserAndBook("user1", "1"));
    }
    @Test
    void reserve_whenBookDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> reservationService.reserve("user1", "1"));
    }

    @Test
    void reserve_whenNoCopiesAvailable() { 
        Book book = new Book("1", "The Lord of the Rings", 0);
        bookRepository.save(book);
       assertThrows(IllegalStateException.class, () -> reservationService.reserve("user1", "1"));
    }
    
    @Test
    void reserve_whenUserAlreadyReserved() {
        Book book = new Book("1", "The Lord of the Rings", 1);
        bookRepository.save(book);
        reservationService.reserve("user1", "1");
        assertThrows(IllegalStateException.class, () -> reservationService.reserve("user1", "1"));
    }

// cancel method test cases
    @Test
    void cancel_whenReservationExists() {
        Book book = new Book("1", "The Lord of the Rings", 1);
        bookRepository.save(book);
        reservationService.reserve("user1", "1");
        reservationService.cancel("user1", "1");
        assertFalse(reservationRepository.existsByUserAndBook("user1", "1"));
    }

    @Test
    void cancel_whenReservationDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> reservationService.cancel("user1", "1"));
        
    }



    
    
    
}
