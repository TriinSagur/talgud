package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "is_moderator", nullable = false)
    private Boolean isModerator = false;

    public ProjectUser(Project project, User user, Boolean isModerator) {
        this.project = project;
        this.user = user;
        this.isModerator = isModerator;
    }

}