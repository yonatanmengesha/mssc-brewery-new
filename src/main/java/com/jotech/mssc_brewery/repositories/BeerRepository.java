package com.jotech.mssc_brewery.repositories;

import com.jotech.mssc_brewery.domain.Beer;
import com.jotech.mssc_brewery.web.model.BeerDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer,UUID>,CrudRepository<Beer, UUID> {
}
