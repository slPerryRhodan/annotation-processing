package com.example.annotation_processing.mapping;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MapperService {

    private final MyMapper myMapper;

    public Target doMapping(Source source) {
        var target = myMapper.map(source);
        IO.println(target);
        return target;
    }
}
