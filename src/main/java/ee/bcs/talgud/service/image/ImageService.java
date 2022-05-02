package ee.bcs.talgud.service.image;


import ee.bcs.talgud.domain.picture.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService {

    @Resource
    private PictureService pictureService;

    public void addPicture(ImageRequest request) {
        pictureService.addPicture(request);
    }

    public List<ImageResponse> getAllPicturesForProject(Integer projectId) {
        return pictureService.getAllPicturesForProject(projectId);
    }
}
