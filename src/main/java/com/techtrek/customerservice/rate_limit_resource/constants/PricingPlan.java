package com.techtrek.customerservice.rate_limit_resource.constants;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Duration;

@Slf4j
public enum PricingPlan implements Limit {
    FREE {
        @Override
        public Bandwidth getLimit() {
            return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(1)));
        }
    };

    public static PricingPlan resolvePlanFromApiKey(String apiKey) {
        return FREE;
    }
}