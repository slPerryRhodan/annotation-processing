package com.example.annotation_processing.mapping;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapperServiceTest {

    @Test
    void map_mapstructMapper_implMapperShouldBeVisible() {
        // given
        // FIXME: IntelliJ with WSL2 cannot automatically resolve the class MyMapperImpl, which leads to
        //  "Cannot resolve symbol 'MyMapperImpl'", but the test and the rest of the is still working.
        // WORKAROUND for WSL2 which is not necessary on Windows system:
            // 1: Mark generated code under main (build/generated/sources/annotationProcessor/java/main) as "Generated Source Root"
            // 2: In this test class here execute at the unresolved MyMapperImpl class the context menu action "Add dependency on module 'annotation-processing'"
            // 3: In MyMapperImpl class execute at @Component annotation the context menu action "Add library 'spring.context' to class path"
            // 4: In MyMapperImpl class execute at MyMapper interface the context menu action "Add Add dependency on module 'annotation-processing.main'"
        var myMapperImpl = new MyMapperImpl();
        var mapperService = new MapperService(myMapperImpl);
        var source = new Source("property");

        // when
        var mapResult = mapperService.doMapping(source);

        // then
        assertThat(mapResult.property()).isEqualTo("property");
    }

}