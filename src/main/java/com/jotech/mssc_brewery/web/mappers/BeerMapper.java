package com.jotech.mssc_brewery.web.mappers;

import com.jotech.mssc_brewery.domain.Beer;
import com.jotech.mssc_brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses ={DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);

}
