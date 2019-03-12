package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("/upload")
    public String upload(Carousel carousel, MultipartFile source, HttpSession session){
        System.out.println("JSP接收到的轮播图对象~~~~~~~~~~~~~"+carousel);
        System.out.println("添加的輪播圖++++++"+source);


        try{
            String path = session.getServletContext().getRealPath("//upload");
            String name= source.getOriginalFilename();
            String picPath = path+"\\"+name;
            System.out.println("輪播圖路徑*********"+picPath);

            source.transferTo(new File(picPath));

            carousel.setPicpath("/upload"+"\\"+name);

            carouselService.addCarousel(carousel);

            return "ture";
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
        @RequestMapping("/download")
        public void download(HttpServletRequest request, HttpServletResponse response, String title, HttpSession session) throws IOException {
            //文件的下载其实就是将文件从服务器发送到浏览器

            System.out.println("文件的名称==============="+title);

            //1.获取文件路径
            String realPath = session.getServletContext().getRealPath("/upload");
            //2.获取文件
            File file = new File(realPath,title);
            //3.根据文件后缀设置相应类型
                        /*title.lastIndexOf(".") 获取队后一个点的下标
                        title.substring()获取下标后的文件名*/
            String subString = title.substring(title.lastIndexOf("."));
            response.setContentType(request.getSession().getServletContext().getMimeType(subString));

            //4.设置响应头
            response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(title, "utf-8"));
            /*content-disposition不区分大小写,但是如果拼写出错，则文件下载后直接在线播放*/
            //5.响应
            FileInputStream inputStream = new FileInputStream(file);
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }


}

