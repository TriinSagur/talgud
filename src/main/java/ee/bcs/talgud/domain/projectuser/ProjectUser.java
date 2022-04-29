package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "project_user")
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "is_participant", nullable = false)
    private Boolean isParticipant = false;

    public ProjectUser(Project project, User user, Boolean isModerator, Boolean isParticipant) {
        this.project = project;
        this.user = user;
        this.isModerator = isModerator;
        this.isParticipant = isParticipant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsModerator() {
        return isModerator;
    }

    public void setIsModerator(Boolean isModerator) {
        this.isModerator = isModerator;
    }

    public Boolean getIsParticipant() {
        return isParticipant;
    }

    public void setIsParticipant(Boolean isParticipant) {
        this.isParticipant = isParticipant;
    }

}