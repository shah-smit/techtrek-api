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
    },
    BASIC {
        @Override
        public Bandwidth getLimit() {
            return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(1)));
        }
    },
    PROFESSIONAL {
        @Override
        public Bandwidth getLimit() {
            return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(1)));
        }
    };

    public static PricingPlan resolvePlanFromApiKey(String apiKey) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        log.info("CurrentPrincipal Name {}", currentPrincipalName);
        if (apiKey == null || apiKey.isEmpty()) {
            return FREE;
        } else if (apiKey.startsWith("PX001-")) {
            return PROFESSIONAL;
        } else if (apiKey.startsWith("BX001-")) {
            return BASIC;
        }
        return FREE;
    }
}