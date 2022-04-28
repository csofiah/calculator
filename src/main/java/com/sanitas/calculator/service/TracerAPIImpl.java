package com.sanitas.calculator.service;

import io.corp.calculator.TracerAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TracerAPIImpl  implements TracerAPI {


    public <T> void trace( final T result ) {
        log.info( "result :: " + result.toString() );
    }
}
