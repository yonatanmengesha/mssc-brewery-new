package com.jotech.mssc_brewery.web.mappers;

import com.jotech.mssc_brewery.domain.Beer;
import com.jotech.mssc_brewery.domain.Beer.BeerBuilder;
import com.jotech.mssc_brewery.web.model.BeerDto;
import com.jotech.mssc_brewery.web.model.BeerDto.BeerDtoBuilder;
import com.jotech.mssc_brewery.web.model.v2.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T21:14:28-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( beer.getBeerStyle().name() );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.lastUpdatedDate( dateMapper.asOffsetDateTime( beer.getLastUpdatedDate() ) );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDto.getId() );
        beer.beerName( beerDto.getBeerName() );
        if ( beerDto.getBeerStyle() != null ) {
            beer.beerStyle( Enum.valueOf( BeerStyleEnum.class, beerDto.getBeerStyle() ) );
        }
        beer.upc( beerDto.getUpc() );
        beer.createdDate( dateMapper.asTimestamp( beerDto.getCreatedDate() ) );
        beer.lastUpdatedDate( dateMapper.asTimestamp( beerDto.getLastUpdatedDate() ) );

        return beer.build();
    }
}
