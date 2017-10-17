package repositories;

import com.google.inject.ImplementedBy;
import models.Comment;

@ImplementedBy(CommentRepositoryImplementation.class)
public interface CommentRepository extends BaseRepository<Comment> {
}
