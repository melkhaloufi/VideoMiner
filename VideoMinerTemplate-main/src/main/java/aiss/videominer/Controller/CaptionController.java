package aiss.videominer.Controller;

import aiss.videominer.model.Caption;
import aiss.videominer.repository.CaptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("VideoMiner")
public class CaptionController {
    @Autowired
    CaptionRepository captionRepository;

    @GetMapping("/captions")
    public List<Caption> getCaption(){
        List<Caption> captions = captionRepository.findAll();
        return captions;
    }

    @GetMapping("/captions/{id}")
    public Caption findOne(@PathVariable String id){
        Optional<Caption> caption = captionRepository.findById(id);
        return caption.get();
    }
}
