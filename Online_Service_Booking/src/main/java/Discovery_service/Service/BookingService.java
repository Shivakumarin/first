package Discovery_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public boolean bookSlot(String service, String slot, Long userId) {
        List<Bookingdetails> existing = bookingRepository.findBySlot(slot);
        if (!existing.isEmpty()) {
            return false;
        }

        Bookingdetails booking = new Bookingdetails();
        booking.setService(service);
        booking.setSlot(slot);
        booking.setUserId(userId);

        bookingRepository.save(booking);
        return true;
    }

	
}

