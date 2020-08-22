package com.techtrek.customerservice.math_resource;

import com.techtrek.customerservice.math.AreaV1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class AreaCalculationController {

    @GetMapping(value = "/area/rectangle/{length}/{width}")
    public ResponseEntity<AreaV1> rectangle(@PathVariable int length, @PathVariable int width) {
        return ResponseEntity.ok(new AreaV1("rectangle", length * width));
    }
}