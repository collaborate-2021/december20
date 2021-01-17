package com.example.demo.resource;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Hello {
    private static final Logger logger
            = LoggerFactory.getLogger(Hello.class);
    Counter testCounter;
    AtomicInteger testGauge;
    MeterRegistry meterRegistry;
    DistributionSummary distributionSummary;

    public Hello(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        testCounter = meterRegistry.counter("request_count");
        testGauge = meterRegistry.gauge("request_rate", new AtomicInteger(0));
        logger.debug("Started app");
        distributionSummary = DistributionSummary.builder("response_time_at_local")
                .publishPercentiles(0.5, 0.95) // median and 95th percentile
//                .publishPercentileHistogram()
                .scale(100)
                .register(meterRegistry);
    }

    //    @Timed
    @RequestMapping("/hello")
    @GetMapping
    public String hello() {
        long startTime = System.currentTimeMillis();
        Timer.Sample sample = Timer.start(meterRegistry);
        logger.info("Example log from {}", Hello.class.getSimpleName());
        testCounter.increment();
        testGauge.incrementAndGet();
        try {
            return "Hello World";
        } finally {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            sample.stop(meterRegistry.timer("response_time"));
            distributionSummary.record(elapsedTime);
        }
    }

}
