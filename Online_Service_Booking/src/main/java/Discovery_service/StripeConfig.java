package Discovery_service;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    // You don't need to return anything; just set the Stripe API key
    public void configureStripe() {
        Stripe.apiKey = stripeApiKey;
    }
}
