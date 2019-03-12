package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CarouselServiceImpl implements CarouselService{
    @Autowired
    private CarouselDao carouselDao;

    @Override
    public void addCarousel(Carousel carousel){
        carouselDao.insert(carousel);
    }
}
