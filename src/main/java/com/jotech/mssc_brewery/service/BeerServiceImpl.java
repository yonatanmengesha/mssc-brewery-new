package com.jotech.mssc_brewery.service;

import com.jotech.mssc_brewery.domain.Beer;
import com.jotech.mssc_brewery.repositories.BeerRepository;
import com.jotech.mssc_brewery.web.mappers.BeerMapper;
import com.jotech.mssc_brewery.web.model.BeerDto;
import com.jotech.mssc_brewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BeerServiceImpl implements BeerService {

    BeerRepository beerRepository;

    @Autowired
    BeerMapper beerMapper;

    @Autowired
    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        Optional<Beer> optionalBeer = beerRepository.findById(beerId);

        if(optionalBeer.isPresent()){

            return  beerMapper.beerToBeerDto(optionalBeer.get());
        }

        return null;
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDto
                (beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo impl - would add a real impl to update beer
        BeerDto foundBeerDto =  beerMapper.beerToBeerDto(beerRepository.findById(beerId).get());

        foundBeerDto.setId(beerDto.getId());
        foundBeerDto.setBeerName(beerDto.getBeerName());
        foundBeerDto.setBeerStyle(beerDto.getBeerStyle());
        foundBeerDto.setUpc(beerDto.getUpc());
        foundBeerDto.setCreatedDate(beerDto.getCreatedDate());
        foundBeerDto.setLastUpdatedDate(beerDto.getLastUpdatedDate());

        beerRepository.save(beerMapper.beerDtoToBeer(foundBeerDto));






    }

    @Override
    public void deleteBeerById(UUID beerId) {

        log.debug("Deleting Beer by Id ...");

        beerRepository.deleteById(beerId);
    }
}
