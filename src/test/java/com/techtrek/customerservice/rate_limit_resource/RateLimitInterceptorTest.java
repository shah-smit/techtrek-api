package com.techtrek.customerservice.rate_limit_resource;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;

import static com.techtrek.customerservice.test_data_provider.RateLimitInterceptorTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RateLimitInterceptorTest {

    @InjectMocks
    private RateLimitInterceptor rateLimitInterceptor;

    @Mock
    private PricingPlanService pricingPlanService;

    @Mock
    private Bucket bucket;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Test
    public void testShouldReturnFalseWhenOutOfConsumptionProbeAvailable() throws Exception {
        when(bucket.tryConsumeAndReturnRemaining(anyLong())).thenReturn(ConsumptionProbe.rejected(0, 100));
        when(pricingPlanService.resolveBucket(anyString())).thenReturn(bucket);

        boolean result = rateLimitInterceptor.preHandle(buildRequest(), httpServletResponse, null);

        assertFalse(result);
        Mockito.verify(httpServletResponse, times(1)).addHeader(eq(HEADER_RETRY_AFTER), any());
        Mockito.verify(httpServletResponse, times(1)).sendError(eq(HttpStatus.TOO_MANY_REQUESTS.value()), eq("You have exhausted your API Request Quota"));
        Mockito.verify(httpServletResponse, times(1)).setContentType(eq(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void testShouldReturnFalseWhenHeaderNotFound() throws Exception {
        boolean result = rateLimitInterceptor.preHandle(buildRequestWithOutAuthorizationHeader(), httpServletResponse, null);

        assertFalse(result);
        Mockito.verify(httpServletResponse, times(1)).sendError(eq(HttpStatus.BAD_REQUEST.value()), eq("Missing Header: "+AUTHORIZATION));
    }

    @Test
    public void testShouldReturnTrue() throws Exception {
        when(bucket.tryConsumeAndReturnRemaining(anyLong())).thenReturn(ConsumptionProbe.consumed(100));
        when(pricingPlanService.resolveBucket(anyString())).thenReturn(bucket);

        boolean result = rateLimitInterceptor.preHandle(buildRequest(), httpServletResponse, null);

        assertTrue(result);
        Mockito.verify(httpServletResponse, times(1)).addHeader(eq(HEADER_LIMIT_REMAINING), eq("100"));
    }


}
