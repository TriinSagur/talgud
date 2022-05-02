package ee.bcs.talgud.service.image;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("/in")
    public void addPicture(@RequestBody ImageRequest request) {
        imageService.addPicture(request);
    }

    @GetMapping("/all")
    public List<ImageResponse> getAllPictures(@RequestParam Integer projectId) {
        return imageService.getAllPicturesForProject(projectId);
    }
}
