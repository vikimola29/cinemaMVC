import com.ubb.postuniv.domain.ClientCard;
import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.domain.Reservation;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.InMemoryRepository;
import com.ubb.postuniv.service.ClientCardService;
import com.ubb.postuniv.service.FilmService;
import com.ubb.postuniv.service.ReservationService;
import com.ubb.postuniv.userinterface.Console;

public class Main {
    public static void main(String[] args) throws Exception {
        IRepository<Film> filmRepository = new InMemoryRepository<>();
        IRepository<ClientCard> clientCardRepository = new InMemoryRepository<>();
        IRepository<Reservation> reservationRepository = new InMemoryRepository<>();

        filmRepository.create(new Film(1, "A", 2020,  10, "Bbb"));
        filmRepository.create(new Film(2, "B", 2021,  22.4, "Bbb"));

        clientCardRepository.create(new ClientCard(1, "Cecil", "Baldwin", 313243, "1990.03.14", "1920.03.14 16:30", 30));
        clientCardRepository.create(new ClientCard(2, "Carlos", "Scientist", 314343, "1990.03.14", "1920.03.14 16:30", 30));


        FilmService filmService = new FilmService(filmRepository);
        ClientCardService clientCardService = new ClientCardService(clientCardRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, filmRepository, clientCardRepository);

        Console console = new Console(filmService, clientCardService, reservationService);
        console.runConsole();
    }
}