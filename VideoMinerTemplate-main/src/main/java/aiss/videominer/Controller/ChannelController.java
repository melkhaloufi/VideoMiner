package aiss.videominer.Controller;

import aiss.videominer.model.Channel;
import aiss.videominer.repository.ChannelRepository;
import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("VideoMiner")
public class ChannelController {
    @Autowired
    ChannelRepository channelRepository;


    public ChannelController(ChannelRepository channelRepository){
        this.channelRepository =  channelRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/channels")
    public Channel create(@RequestBody @Valid Channel channel) {
        Channel _channel = channelRepository.save(new Channel(channel.getId(), channel.getName(), channel.getDescription(),
                channel.getCreatedTime(), channel.getVideos()));
        return _channel;
    }

    @GetMapping("/channels")
    public List<Channel> getChannels(){
        List<Channel> channels=channelRepository.findAll();
        return channels;
    }

    @GetMapping("/channels/{id}")
    public Channel findOne(@PathVariable String id){
            //throws ChannelNotFoundException {
        Optional<Channel> channel = channelRepository.findById(id);
        //if (!channel.isPresent()) {
          //  throw new ChannelNotFoundException();
        //}
        return channel.get();
    }
}

