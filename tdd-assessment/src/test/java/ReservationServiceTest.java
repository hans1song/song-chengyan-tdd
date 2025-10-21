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

// listReservations method test cases
    @Test
    void listReservations_whenUserHasReservations() {
        Book book1 = new Book("1", "Book One", 1);
        Book book2 = new Book("2", "Book Two", 1);
        bookRepository.save(book1);
        bookRepository.save(book2);

        reservationService.reserve("user1", "1");
        reservationService.reserve("user1", "2");

        assertEquals(2, reservationService.listReservations("user1").size());
        assertTrue(reservationService.listReservations("user1").stream()
                .anyMatch(r -> r.getBookId().equals("1")));
        assertTrue(reservationService.listReservations("user1").stream()
                .anyMatch(r -> r.getBookId().equals("2")));
    }

    @Test
    void listReservations_whenUserHasNoReservations() {
        assertTrue(reservationService.listReservations("user1").isEmpty());
    }

// listReservationsForBook method test case
    @Test
    void listReservationsForBook_whenBookHasReservations() {
        Book book = new Book("1", "Book One", 2);
        bookRepository.save(book);
        reservationService.reserve("user1", "1");
        reservationService.reserve("user2", "1");
        assertEquals(2, reservationService.listReservationsForBook("1").size());
    }

    @Test
    void listReservationsForBook_whenBookHasNoReservations() {
        assertTrue(reservationService.listReservationsForBook("1").isEmpty());
    }    


// Add a boundary test(Reserving the last copy.) ps. The other two error tests have been written above

    @Test
    void reserve_whenReservingLastCopy_decrementsCopiesToZero() {
        Book book = new Book("1", "The Last Copy", 1);
        bookRepository.save(book);
        reservationService.reserve("user1", "1");
        Book updatedBook = bookRepository.findById("1");
        assertEquals(0, updatedBook.getCopiesAvailable());
    
    }

// PartC start

   
}
