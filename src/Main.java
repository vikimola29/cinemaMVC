import com.ubb.postuniv.domain.*;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.IUpsertRepository;
import com.ubb.postuniv.repository.InMemoryRepository;
import com.ubb.postuniv.repository.RepositoryToUpsertRepositoryAdapter;
import com.ubb.postuniv.service.ClientCardService;
import com.ubb.postuniv.service.FilmService;
import com.ubb.postuniv.service.ReservationService;
import com.ubb.postuniv.service.TextSearch;
import com.ubb.postuniv.userinterface.Console;

public class Main {
    public static void main(String[] args) throws Exception {
        IRepository<Film> filmRepository = new InMemoryRepository<>();
        IRepository<ClientCard> clientCardRepository = new InMemoryRepository<>();
        IRepository<Reservation> reservationRepository = new InMemoryRepository<>();



        filmRepository.create(new Film(1, "Cecil", 2020,  10, true));
        filmRepository.create(new Film(2, "Bob", 2021,  22.4, true));
        filmRepository.create(new Film(3, "Cecil", 2021,  22.4, true));

        clientCardRepository.create(new ClientCard(1, "Cecil", "Baldwin", 313243, "14.03.1990", "1920.03.14 16:30", 30));
        clientCardRepository.create(new ClientCard(2, "Cecil", "Baldwin", 313243, "14.03.1990", "1920.03.14 16:30", 30));
        clientCardRepository.create(new ClientCard(3, "Carlos", "Scientist", 314343, "14.03.1990", "1920.03.14 16:30", 30));

        reservationRepository.create(new Reservation(1, 1, 1,"14.03.1990 16:30"));
        reservationRepository.create(new Reservation(2, 2, 2,"14.03.1990 16:30"));
        reservationRepository.create(new Reservation(3, 1, 1,"14.03.1990 16:30"));

        IUpsertRepository<Film> filmRepositoryAdapted = new RepositoryToUpsertRepositoryAdapter<>(filmRepository);
        IUpsertRepository<ClientCard> clientCardRepositoryAdapted = new RepositoryToUpsertRepositoryAdapter<>(clientCardRepository);

        ReservationValidator reservationValidator = new ReservationValidator();
        FilmValidator filmValidator = new FilmValidator();
        ClientCardValidator clientCardValidator = new ClientCardValidator();

        FilmService filmService = new FilmService(filmRepositoryAdapted, filmValidator);
        ClientCardService clientCardService = new ClientCardService(clientCardRepositoryAdapted, clientCardValidator);
        ReservationService reservationService = new ReservationService(reservationRepository, filmRepository, clientCardRepository, reservationValidator);

        TextSearch searchText = new  TextSearch(filmRepository, clientCardRepository);

        Console console = new Console(filmService, clientCardService, reservationService, searchText);
        console.runConsole();
    }
}