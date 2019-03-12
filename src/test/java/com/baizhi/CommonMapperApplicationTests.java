package com.baizhi;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonMapperApplicationTests {

    @Autowired
    private CarouselDao carouselDao;
    @Test
    public void contextLoads() {
        List<Carousel> carousels = carouselDao.selectAll();
        for (Carousel carousel : carousels) {
            System.out.println(carousel);
        }
    }


    @Test
    public void upload() {
        Carousel carousel = new Carousel();
        carousel.setId("111");
        carouselDao.insert(carousel);

    }

}
