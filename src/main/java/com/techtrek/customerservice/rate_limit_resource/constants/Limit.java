package com.techtrek.customerservice.rate_limit_resource.constants;

import io.github.bucket4j.Bandwidth;

public interface Limit {
    public Bandwidth getLimit();
}
