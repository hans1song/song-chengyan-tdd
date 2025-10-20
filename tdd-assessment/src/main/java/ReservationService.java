import java.util.*;

public class ReservationService {
    private final IBookRepository bookRepo;
    private final IReservationRepository reservationRepo;

    public ReservationService(IBookRepository bookRepo, IReservationRepository reservationRepo) {
        this.bookRepo = bookRepo;
        this.reservationRepo = reservationRepo;
    }

    /**
     * Reserve a book for a user.
     * Throws IllegalArgumentException if book not found.
     * Throws IllegalStateException if no copies available or user already reserved.
     */
    public void reserve(String userId, String bookId) {
        Book book = findAndValidateBook(bookId, userId);
        createReservationAndUpdateBook(book, userId);
    }

    private Book findAndValidateBook(String bookId, String userId) {
        Book book = bookRepo.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if (book.getCopiesAvailable() == 0) {
            throw new IllegalStateException("No copies available");
        }
        if (reservationRepo.existsByUserAndBook(userId, bookId)) {
            throw new IllegalStateException("User already reserved");
        }
        return book;
    }

    private void createReservationAndUpdateBook(Book book, String userId) {
        Reservation reservation = new Reservation();
        reservation.setUserId(userId);
        reservation.setBookId(book.getId());
        reservationRepo.save(reservation);

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepo.save(book);
    }

    /**
     * Cancel an existing reservation for a user.
     * Throws IllegalArgumentException if no such reservation exists.
     */
    public void cancel(String userId, String bookId) {
        // TODO: Implement using TDD
        if (!reservationRepo.existsByUserAndBook(userId, bookId)) {
            throw new IllegalArgumentException("No reservation found for this user and book.");
        }
        reservationRepo.delete(userId, bookId);
        Book book = bookRepo.findById(bookId);
        if (book != null) {
            book.setCopiesAvailable(book.getCopiesAvailable() + 1);
            bookRepo.save(book);
        }
    }

    /**
     * List all active reservations for a given user.
     */
    public List<Reservation> listReservations(String userId) {
        // TODO: Implement using TDD
        return null;
    }

    /**
     * list all reservations for a book.
     */
    public List<Reservation> listReservationsForBook(String bookId) {
        // TODO: Implement using TDD
        return null;
    }

}
