package aiss.videominer.Controller;

import aiss.videominer.model.Channel;
import aiss.videominer.model.Video;
import aiss.videominer.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("VideoMiner")
public class VideoController {
    @Autowired
    VideoRepository videoRepository;

    @GetMapping("/videos")
    public List<Video> getvideos(){
        List<Video>  videos=videoRepository.findAll();
        return videos;
    }

    @GetMapping("/videos/{id}")
    public Video findOne(@PathVariable String id){
        Optional<Video> video = videoRepository.findById(id);
        return video.get();
    }

}
