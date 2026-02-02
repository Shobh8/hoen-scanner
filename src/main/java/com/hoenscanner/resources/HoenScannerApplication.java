package com.hoenscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoenscanner.core.SearchResult;
import com.hoenscanner.resources.SearchResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    @Override
    public void run(HoenScannerConfiguration configuration, Environment environment) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<SearchResult> results = new ArrayList<>();

        results.addAll(mapper.readValue(
                getClass().getResourceAsStream("/hotels.json"),
                new TypeReference<List<SearchResult>>() {}));

        results.addAll(mapper.readValue(
                getClass().getResourceAsStream("/rental_cars.json"),
                new TypeReference<List<SearchResult>>() {}));

        environment.jersey().register(new SearchResource(results));
    }
}
