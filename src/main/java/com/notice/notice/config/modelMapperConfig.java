package com.notice.notice.config;
import com.notice.notice.category.category;
import com.notice.notice.notice.notice;
import com.notice.notice.notice.noticeCreationDto;
import com.notice.notice.notice.noticeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.notice.notice.category.categoryRepository;
import java.util.List;
import java.util.stream.Collectors;

// Configuración de ModelMapper, para auto mapear las entidades
@Configuration
@RequiredArgsConstructor
public class modelMapperConfig {
    private final categoryRepository categoryRepo;
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Se configura para que no mapee los valores nulos
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        // Mapeo personalizado para notice a noticeDto
        Converter<List<Integer>, List<category>> categoryConverter = ctx ->
                ctx.getSource().stream()
                        .map(id -> categoryRepo.findById((long) id).orElse(null)) // Busca cada categoría por ID
                        .collect(Collectors.toList());


        // Mapeo personalizado para noticeCreationDto a notice
        modelMapper.addMappings(new PropertyMap<noticeCreationDto, notice>() {
            @Override
            protected void configure() {
                using(categoryConverter).map(source.getCategories(), destination.getCategories());
            }
        });
        return modelMapper;
    }
}
