package com.example.annotation_processing.mapping;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapperServiceTest {

    @Test
    void map_mapstructMapper_implMapperShouldBeVisible() {
        // given
        // FIXME: IntelliJ with WSL2 cannot automatically resolve the class MyMapperImpl, which leads to
        //  "Cannot resolve symbol 'MyMapperImpl'", but the test and the rest of the Gradle project is still working.
        var myMapperImpl = new MyMapperImpl();
        var mapperService = new MapperService(myMapperImpl);
        var source = new Source("property");

        // when
        var mapResult = mapperService.doMapping(source);

        // then
        assertThat(mapResult.property()).isEqualTo("property");
    }

}