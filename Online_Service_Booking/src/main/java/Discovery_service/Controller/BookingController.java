package Discovery_service;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookSlot(@RequestParam String service, 
                                           @RequestParam String slot, 
                                           @RequestParam Long userId) {
       
    	boolean success=bookingService.bookSlot(service, slot, userId);
    	
        return success ? ResponseEntity.ok("Booking confirmed")
                       : ResponseEntity.status(HttpStatus.SC_CONFLICT).body("Slot unavailable");
    }
}

