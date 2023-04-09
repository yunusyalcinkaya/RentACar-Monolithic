package kodlama.io.rentACar.adapters;

import kodlama.io.rentACar.business.abstracts.PosService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccessful = new SecureRandom().nextBoolean();
        if (!isPaymentSuccessful) throw new RuntimeException("Payment is failed.");
    }
}
