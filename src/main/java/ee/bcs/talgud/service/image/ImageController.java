package ee.bcs.talgud.service.image;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("")
    @Operation(summary = "Lisab uue pildi")
    public void addPicture(@RequestBody ImageRequest request) {
        imageService.addPicture(request);
    }

    @GetMapping("")
    @Operation(summary = "Leiab kõik pildid")
    public List<ImageResponse> getAllPictures(@RequestParam Integer projectId) {
        return imageService.getAllPicturesForProject(projectId);
    }

    @DeleteMapping("")
    @Operation(summary = "Kustutab pildi")
    public void removeImageById(@RequestParam Integer pictureId) {
        imageService.removeImageById(pictureId);
    }
}
