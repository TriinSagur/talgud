package ee.bcs.talgud.domain.picture;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.service.image.ImageRequest;
import ee.bcs.talgud.service.image.ImageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

    @Resource
    private ProjectService projectService;

    @Resource
    private PictureMapper pictureMapper;

    public void addPicture(ImageRequest request) {
        byte[] data = request.getData().getBytes(StandardCharsets.UTF_8);
        Project project = projectService.getProjectById(request.getProjectId());
        Picture picture = new Picture();
        picture.setData(data);
        picture.setProject(project);
        pictureRepository.save(picture);
    }

    public List<ImageResponse> getAllPicturesForProject(Integer projectId) {
        List<Picture> pictures = pictureRepository.findByProject_Id(projectId);
        return pictureMapper.toResponses(pictures);
    }
}
