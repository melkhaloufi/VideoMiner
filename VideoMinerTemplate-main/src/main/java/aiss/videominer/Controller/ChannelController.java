package aiss.videominer.Controller;

import aiss.videominer.model.Channel;
import aiss.videominer.repository.ChannelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("VideoMiner/channels")
public class ChannelController {
    @Autowired
    ChannelRepository channelRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Channel create(@RequestBody @Valid Channel channel) {
        Channel _channel = channelRepository.save(new Channel(channel.getId(), channel.getName(), channel.getDescription(),
                channel.getCreatedTime(), channel.getVideos()));
        return _channel;
    }
}
